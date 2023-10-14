package EMS.telemetryServer; /**
 * @author Leon Welsch
 * @version 1.0
 */

import EMS.telemetryServer.Information;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.exceptions.InfluxException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

import static com.influxdb.client.InfluxDBClient.*;

public class Dataproducer {

    private final HashMap<String, ArrayList<Information>> hashmap;

    /**
     * Constructor: creates a new object ExcelToHashmap to generates a new hashmap from the CAN-Excel
     */
    public Dataproducer(){
        ExcelToHashMap excelHashMap = new ExcelToHashMap();
        hashmap = excelHashMap.getHashmap();
    }

    /**
     * Method decodes data and returns an array list of the decoded values
     * @param serialData data read in at the serial interface
     * @return array list of the decoded data each element is a measurement which includes the name, unit, value and an id from on CANSignal
     */
    public ArrayList<Measurement> decodeData(byte[] serialData){

        // Stores the values from each decoded CANSignal
        ArrayList<Measurement> measurements = new ArrayList<>();

        // Stores the current ID, which is currently being analyzed
        int id;
        // Stores the Data-Length-Code of the current ID
        int dlc;
        // The message is examined, the counter is increased by the DLC of the current message
        // Each loop decodes one id
        for(int i = 0; i < serialData.length; i += dlc + 2){

            // Stores the ID, which are 2 bytes
            id = (Byte.toUnsignedInt(serialData[i]) << 8) | Byte.toUnsignedInt(serialData[i + 1]);
            if(id == 0){
                break;
            }

            // Stores the id in hex format similar to the name in excel
            String id_hex = "0x" + Integer.toHexString(id);

            // Get arraylist from hashmap with this id
            ArrayList<Information> list = hashmap.get(id_hex);
            // Stop decoding message if list is empty and the signal can't be decoded
            if(list.size() == 0){
                System.out.println("List is empty");
                //break;
            }
            Header h1 = (Header) list.get(0);

            // Stores the DLC, indicated by the ID
            dlc = h1.getDlc();

            // Convert the input message to a boolean array to be able to read each bit
            boolean[] bitstream = new boolean[dlc * 8];
            for(int k = 0; k < dlc; k++){
                for(int l = 0; l < 8; l++){
                    bitstream[k * 8 + l] = (serialData[i + 2 + k] & (1 << l)) > 0;
                }
            }

            // FOR DEBUG
            // printBitstream(bitstream);

            // Each loop decodes one signal
            for(int j = 1; j < list.size(); j++){
                Measurement measurement = new Measurement();
                CANSignal s1 = (CANSignal) list.get(j);
                measurement.setName(s1.getName());
                measurement.setUnit(s1.getUnit());
                int length = s1.getLength();
                int startbit = s1.getStartBit();
                long value = 0;
                // Check if the data is saved in big endian byte order
                if(s1.getBigEndian()){
                    sortBigEndian(bitstream, length, startbit);
                }
                // Check if data is a signed value
                // If true, the data must be decoded in the format its saved e.g. byte (8-bit data length) to save the sign
                // If false, the datatype long convert all values to unsigned (max data length is 32-bit)
                if(s1.getIsSigned()){
                    // signed value
                    switch (length) {
                        case 8 -> value = (byte) getValue(bitstream, length, startbit);
                        case 16 -> value = (short) getValue(bitstream, length, startbit);
                        case 32 -> value = (int) getValue(bitstream, length, startbit);
                        default -> {
                        }
                    }
                }else{
                    // unsigned value
                    value = getValue(bitstream, length, startbit);

                }
                // To obtain the correct value, the decoded value must be offset by a factor and offset
                double outputValue;
                outputValue = (double)value + s1.getOffset() * s1.getFactor();

                measurement.setValue(outputValue);
                measurement.setId(id_hex);

                // Maybe start to transfer data to InfluxDb....
                measurements.add(measurement);

                // FOR DEBUG
                System.out.print("ID: " + measurement.getId() + " Name: " + measurement.getName() + " Value: " + measurement.getValue() + " Unit: " + measurement.getUnit());

            }
        }
        return measurements;
    }

    /**
     * Prints measurements on serial monitor
     * @param measurements measurements which should print on serial monitor
     */
    public void showMeasurements(ArrayList<Measurement> measurements){
        for(int i = 0; i < measurements.size(); i++){
            Measurement measurement = measurements.get(i);
            System.out.print("ID: " + measurement.getId() + " Name: " + measurement.getName() + " Value: " + measurement.getValue() + " Unit: " + measurement.getUnit());
        }
    }

    /**
     * Decodes the value of on signal
     * @param bitstream bitstream of the message from one id
     * @param length number of bits of the current signal
     * @param startbit startbit of the current signal
     * @return decoded value
     */
    private long getValue(boolean[] bitstream, int length, int startbit){
        long value = 0;
        // FOR DEBUG
        // System.out.println("Startbit: " + startbit);
        // System.out.println("Length: " + length);
        for(int i = 0; i < length; i++){
            if(bitstream[startbit + i]) {
                value |= 1 << i;
            }
        }
        // FOR DEBUG
        // System.out.println("Value: " + value);
        return value;
    }

    /**
     * Sorts the byte order of a signal from little to big endian
     * @param bitstream bitstream of the message from one id
     * @param length number of bits of the current signal
     * @param startbit startbit of the current signal
     */
    private void sortBigEndian(boolean[] bitstream, int length, int startbit){
        boolean[] newBitstream = new boolean[bitstream.length];
        int counter = length + startbit;
        for(int i = 0; i < length/8; i++){
            for(int j = 0; j < 8; j++){
                newBitstream[i * 8 + j] = bitstream[counter - 8 + j - (8 * i)];
            }
        }
        System.arraycopy(newBitstream, 0, bitstream, 0, bitstream.length);
    }


    /**
     * Prints bitstream on serial monitor
     * @param bitstream bitstream which should print on serial monitor
     */
    private void printBitstream(boolean[] bitstream){
        System.out.print("Bitstream: ");
        for(int i = 0; i < bitstream.length; i++){
            if(i%4 == 0){
                System.out.print(" ");
            }
            if(bitstream[i]){
                System.out.print("1");
            }else{
                System.out.print("0");
            }

        }
        System.out.print("\n");
    }

}
