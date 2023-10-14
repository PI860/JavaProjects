package EMS.telemetryServer; /**
 * @author Leon Welsch
 * @version 1.0
 */

import com.fazecast.jSerialComm.*;

public class TravosIII {

    /**
     * Object for the serial interface
     */
    private SerialPort comPort;
    /**
     * Object for testing a new serial interface
     */
    private SerialPort[] searchComPort = new SerialPort[5];

    /**
     * The raw data is stored in message.
     * It contains the ID (2 Byte) and the data of the ID
     */
    private byte[] message = new byte[128];

    /**
     * Method to communicate with other classes
     * @return actual message
     */
    public byte[] getMessage(){
        return this.message;
    }

    /**
     * Constructor: Starts the serial communication, when object is created
     */
    public TravosIII(){
        startComm();
        cmd_reset_req();
    }

    /**
     * Method to print actual message on serial monitor
     */
    public void printMessage(){
        for (byte b : message) {
            System.out.printf("%02x \n", b);
        }
    }

    /**
     * Method to initialise the serial interface
     */
    public void startComm(){
        System.out.println(SerialPort.getCommPorts());
        comPort = SerialPort.getCommPort("/dev/ttyUSB0");

        /*
        // Search for names of the connected serial ports and print them on serial monitor
        searchComPort = SerialPort.getCommPorts();
        for(int i = 0; i < searchComPort.length; i++){
            System.out.println(searchComPort[i] + ":" + searchComPort[i].getSystemPortName() + " " + searchComPort[i].getDescriptivePortName());
        }

         */

        comPort.openPort();
        comPort.setBaudRate(115200);
        comPort.setNumDataBits(8);
        comPort.setNumStopBits(1);
        comPort.setParity(0);
    }

    /**
     * Method to check if there are any bytes available on the serial interface
     * @return statement of bytes available
     */
    public boolean isByteAvailable(){
        return comPort.bytesAvailable() > 0;
    }

    /**
     * Method to read one message from the serial interface
     */
    public void readBytes(){
        // Pointer which searches for the element with 0x02 (start byte)
        int pointer02 = 0;
        // Buffer read 300 bytes from serial interface
        byte[] readBuffer = new byte[300];
        comPort.readBytes(readBuffer, readBuffer.length);
        // Boolean findStartMessage detects if the beginning of a message has already been found
        // Every message starts with 0x02 (start-byte) 0x81 (cmd-byte) 0x82 (length-byte) and 0x02 (start-byte raw data)
        boolean findStartMessage = false;
        // If no message was found in the buffer, the boolean nothingFound changes to true
        boolean nothingFound = false;

        // Searches for the start of the message as long as it has not yet been found
        while(!findStartMessage) {
            // As long as the start byte was not found, the pointer is incremented
            while (readBuffer[pointer02] != 0x02) {
                pointer02++;
                // To prevent the message from not being completely filled with the buffer, a maximum pointer value is determined and checked
                // If this value is exceeded, there is no valid message in this buffer
                if(pointer02 >= readBuffer.length - message.length - 1) {
                    nothingFound = true;
                    break;
                }
            }
            // If nothing was found, the search is to be aborted
            if(nothingFound){
                System.out.println("Es konnte keine gültige Nachricht gefunden werden lel");
                break;
            }
            // If an element with the content 0x02 was found, it is checked whether the next two elements have the values 0x81 (-127) and 0x82 (-126)
            // The first element of the raw data again starts with a start byte 0x02, this is also searched for
            // If the start sequence was found completely, the start of the message was identified successfully
            // If the start of the message was not found, the pointer is incremented and the search continues
            if (!nothingFound && readBuffer[pointer02 + 1] == -127 && readBuffer[pointer02 + 2] == -126 && readBuffer[pointer02 + 3] == 0x02) {
                findStartMessage = true;
            }else{
                pointer02++;
            }
        }

        // If a message was found, the following content is copied from the buffer into the message
        // The first three elements are skipped because 0x02 0x81 0x82 serve as headers of the radio module and have nothing to do with the message
        // Furthermore, the start byte from the payload (0x02) is also skipped
        // Now element 0 and 1 of the array message contain the first ID.
        if(findStartMessage){
            for(int i = 0; i < message.length; i++){
                message[i] = readBuffer[pointer02+4];
                pointer02++;
            }
        }
    }


    /**
     * The method sends the reset command to the radio module via the serial interface
     */
    public void cmd_reset_req(){
        byte startByte = 0x2;
        byte cmdByte = 0x5;
        byte lengthByte = 0x0;
        int checksum = startByte ^ cmdByte ^ lengthByte;
        byte[] message = new byte[4];
        message[0] = startByte;
        message[1] = cmdByte;
        message[2] = lengthByte;
        message[3] = (byte)checksum;
        comPort.writeBytes(message, message.length);
    }
}
