//package EMS.telemetryServer;
//
//import com.influxdb.client.InfluxDBClient;
//import com.influxdb.client.InfluxDBClientFactory;
//
//public class Main {
//    /**
//     * counter counts the number of received messages
//     */
//    static int counter = 0;
//
//    /**
//     * Main method in which the connection to the radio module is established and data is read.
//     * In addition, these are processed and finally passed on to the database.
//     * @param args
//     */
//    public static void main(String[] args){
//
//        // Example for accessing the Hashmap:
//        /*
//        ExcelToHashMap excelHashMap = new ExcelToHashMap();
//        HashMap<Object, ArrayList> hashmap = excelHashMap.getHashmap();
//        ArrayList list = hashmap.get("0x11"); // ID: String
//        Header h1 = (Header) list.get(0);
//        System.out.println("DLC: " + h1.getM_dlc()); // DLC: int, default: 0
//        int i = 1;
//        while(i < list.size()){
//            CANSignal s1 = (CANSignal) list.get(i);
//            System.out.print("Name: " + s1.getM_name());    // Name: String
//            System.out.print(" StartBit: " + s1.getM_startBit());   // StartBit: int, default: 0
//            System.out.print(" Length: " + s1.getM_length());   // Length: int, default: 1
//            System.out.print(" Signed: " + s1.getM_signed()); // Signed: boolean, true = signed, false = unsigned, default: false
//            System.out.print(" Unit: " + s1.getM_unit());   // Unit: String, default: "nan"
//            System.out.print(" Factor: " + s1.getM_factor());   // Factor: double, default: 1.0
//            System.out.print(" Offset: " + s1.getM_offset());   // Offset: double, default: 0.0
//            System.out.print(" BigEndian: " + s1.getM_bigEndian());    // BigEndian: boolean, true = big endian, false = little endian, default: false
//            System.out.println();
//            i++;
//        }
//
//        */
//        // Creation of an object for the dataproducer
//        Dataproducer dataproducer = new Dataproducer();
//        // Creation of an object for the radio module, starts the serial communication
//        TravosIII travos = new TravosIII();
//
//
//         // InfluxDB Credentials:
//        //String token = "A2rgsfAgiB-6LmiU7Eg9ABsbaue-92YlbUaTsU1GKwoNmj8gYB4OM1j5QFzLIR-hti51ojWYNBxXY6ETelduog=="; // token für "Call Telemetry Data"
//        String token = "YrPdPcRHC1QkZCD9fCEDaiU230xYnx36u41iIwax4JiPCgA-uLUXhW-0Oa1e0BAMJgwR9feO5pcHCUg5vnH57g=="; // token für "paulina.pyczot@einstein-motorsport.com"
//        String bucket = "telemetry";
//        String org = "Einstein_Motorsport";
//        String url = "http://141.59.140.233:8086";
//
//        InfluxDBConnectionClass influxConn = new InfluxDBConnectionClass();
//        InfluxDBClient influxDBClient = influxConn.buildConnection(url, token, bucket, org);
//        //InfluxDBClient influxDBClient = InfluxDBClientFactory.create("http://141.59.139.28:8086", token.toCharArray());
//
//        // Endless loop
//        while(true){
//            // If data can be read in with the serial interface, these are to be read in
//            if(travos.isByteAvailable()){
//                travos.readBytes();
//                counter++;
//                // Print the last message
//                //travos.printMessage();
//                //System.out.println("Die Schleife wurde " + counter + " Mal durchlaufen");
//                // Decode message and transfer data to database
//
//                // DEBUG:
//                Measurement measurementTest = new Measurement();
//                measurementTest.setName("TestName");
//                measurementTest.setUnit("TestUnit");
//                measurementTest.setId("TestID");
//                measurementTest.setValue(100.123);
//
//                dataproducer.showMeasurements(dataproducer.decodeData(travos.getMessage()));
//
//
//                // toDb(dataproducer.decodeData(travos.getMessage()));
//            }
//
//
//          // Write data to InfluxDB:
//          //boolean resultSingle = influxConn.writeMultiplePoints(influxDBClient);
//          //boolean resultSingle = influxConn.testPi(influxDBClient);
//          boolean resultSingle = influxConn.writeData(influxDBClient);
//
//          if (resultSingle) {
//              System.out.println("Single Point write done!!");
//          }
//
//          influxConn.queryData(influxDBClient);
//
//          /*
//          boolean resultDelete = false;
//          inConn.deleteRecord(influxDBClient);
//
//          if (resultDelete)
//              System.out.println("Delete Record done!");
//           */
//
//          influxDBClient.close();
//
//        }
//    }
//}
