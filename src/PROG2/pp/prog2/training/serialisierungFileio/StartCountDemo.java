package pp.prog2.training.serialisierungFileio;

import java.io.*;

/**
 * @author Paulina Pyczot
 * @date 28.06.2023
 * Programm zur Zählung, wie oft es gestartet wurde
 **/

public class StartCountDemo implements Serializable {
    public static void main(String[] args) {
        new StartCountDemo().start();
    }

    public void start() {
        int count = 0;
        count = readStarts();
        System.out.println("Number of starts: " + count);
        writeStarts(++count);
    }

    //Schreibmethode zuerst implementieren, danach die Lesemethode (um besser testen zu können):
    private void writeStarts(int i) {
        try {
            // s. Skript Kapitel 8, S. 10:
//            FileOutputStream fos = new FileOutputStream("NumOfStarts.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(i);
//            oos.close();

            // Test, um rauszubekommen, wo die File abgelegt wird:
            //System.out.println(new File("xyz").getAbsoluteFile()); // wird in C:\Users\pauli\Programming\Semester2\xyz, s. Datei NumOfStarts.ser abgelegt
            //System.out.println(new File("xyz").getAbsolutePath());// wird in C:\Users\pauli\Programming\Semester2\xyz abgelegt (gibt dasselbe aus wie getAbsoluteFile()

            // Besser als FileOutputStream:
            FileWriter fwriter = new FileWriter("NumOfStarts.txt");
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            bwriter.write(/*"Number of starts:"+ */String.valueOf(i));
            bwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private int readStarts() {
        int result = -1;
        try {
            // s. Skript Kapitel 8, S. 12:
            // schlecht lesbar, deshalb bessere Variante mit FileReader weiter unten:
//            FileInputStream fis = new FileInputStream("NumOfStarts.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            result = (Integer) ois.readObject();
//            ois.close();

            // Besser:
            FileReader freader = new FileReader("NumOfStarts.txt");
            BufferedReader breader = new BufferedReader(freader);
            result = Integer.parseInt(breader.readLine());
            breader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
