package EMS.telemetryServer;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExcelToHashMap {
    private final HashMap<String, ArrayList<Information>> canMessages = new HashMap<>();

    private static final String PATH =  "CAN_Messages.xlsx";

    /**
     * Constructor: call execute function when object is created
     */
    public ExcelToHashMap(){
        //execute();
    }

    /**
     * Download and save the CAN-Excel, put Data into a hashmap (key: Measurement ID, value: List of CANSignal objects)
     */
    private void execute(){
        try {

            /*
            URL fetchWebsite = new URL("https://docs.google.com/spreadsheets/d/1Spvt3tbIlDkceVoz6OV1Y5TPjs28UbzUj7xR-eJdkGU/export?format=xlsx");
            ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());

            try (FileOutputStream fos = new FileOutputStream(PATH)) {
                fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
             */

            try (BufferedInputStream in = new BufferedInputStream(new URL("https://docs.google.com/spreadsheets/d/1Spvt3tbIlDkceVoz6OV1Y5TPjs28UbzUj7xR-eJdkGU/export?format=xlsx").openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(PATH)) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                // handle exception
            }

             Workbook wbk = new XSSFWorkbook(PATH);

            Sheet all = wbk.getSheet("All");
            int lastRow = all.getLastRowNum();

            Iterator<Row> iterator = all.iterator();
            Row currentRow = iterator.next();
            currentRow = iterator.next();

            while (iterator.hasNext()) {

                Cell currentIDCell = currentRow.getCell(3);
                Cell currentDlcCell = currentRow.getCell(4);
                Cell currentNameCell;
                currentRow = iterator.next();
                if (currentIDCell != null && !currentIDCell.getStringCellValue().equals("")) {

                    ArrayList<Information> list = new ArrayList<>();
                    Header header = new Header();
                    header.setDlc((int)currentDlcCell.getNumericCellValue());
                    list.add(header);

                    currentNameCell = currentRow.getCell(2);
                    Cell currentUnitCell = currentRow.getCell(30);
                    Cell currentStartBitCell = currentRow.getCell(5);
                    Cell currentLengthCell = currentRow.getCell(6);
                    Cell currentSignedCell = currentRow.getCell(7);
                    Cell currentFactorCell = currentRow.getCell(31);
                    Cell currentOffsetCell = currentRow.getCell(32);
                    Cell currentBigEndian = currentRow.getCell(35);
                    while (currentNameCell != null && !currentNameCell.getStringCellValue().equals("")) {

                        CANSignal signal = new CANSignal();
                        signal.setName(currentNameCell.getStringCellValue());

                        if (currentUnitCell != null && !currentUnitCell.getStringCellValue().equals("")) {
                            signal.setUnit(currentUnitCell.getStringCellValue());
                        }

                        if (currentStartBitCell != null){
                            signal.setStartBit((int)currentStartBitCell.getNumericCellValue());
                        }

                        if (currentLengthCell != null){
                            signal.setLength((int)currentLengthCell.getNumericCellValue());
                        }

                        if (currentSignedCell != null && currentSignedCell.getStringCellValue().equals("-")){
                            signal.setIsSigned(true);
                        }

                        if (currentFactorCell != null){
                            signal.setFactor(currentFactorCell.getNumericCellValue());
                        }

                        if (currentOffsetCell != null){
                            signal.setOffset(currentOffsetCell.getNumericCellValue());
                        }

                        if (currentBigEndian != null && currentBigEndian.getNumericCellValue() == 0.0){
                            signal.setBigEndian(true);
                        }

                        list.add(signal);

                        if (iterator.hasNext()) {
                            currentRow = iterator.next();
                        }
                        currentNameCell = currentRow.getCell(2);
                        currentUnitCell = currentRow.getCell(30);
                        currentStartBitCell = currentRow.getCell(5);
                        currentLengthCell = currentRow.getCell(6);
                        currentSignedCell = currentRow.getCell(7);
                        currentFactorCell = currentRow.getCell(31);
                        currentOffsetCell = currentRow.getCell(32);
                        currentBigEndian = currentRow.getCell(35);
                    }
                    canMessages.put(currentIDCell.getStringCellValue(), list);
                }
            }
            //wbk.close;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Return hashmap created from excel file
     */
    public HashMap<String, ArrayList<Information>> getHashmap(){
        return canMessages;
    }
}
