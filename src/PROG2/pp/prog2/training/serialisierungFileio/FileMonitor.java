package pp.prog2.training.serialisierungFileio;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/**
 * @author Paulina Pyczot
 * @date 29.06.2023
 * Skript Kapitel 8, S. 27
 * Choose PDF-File to convert into byte stream
 **/

public class FileMonitor extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            FileInputStream stream = new FileInputStream(file); //Byte-weises Lesen ermöglicht
            StringBuilder asText = new StringBuilder();
            StringBuilder asNumbers = new StringBuilder("000"); //Auffüllen auf 3 Stellen
            DecimalFormat df = new DecimalFormat();
            while (stream.available() > 0) {
                int el = stream.read();
                asNumbers.append(df.format(el)).append(" ");
                char c = (char) el;
                if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                    asText.append(c);
                } else {
                    asText.append('.');
                }
                if (asText.length() == 10) { //Zeile ausgeben
                    System.out.println(asNumbers + "   " + asText);
                    asNumbers = new StringBuilder();
                    asText = new StringBuilder();
                }
            }

            if (asText.length() > 0) { //Zeile ausgeben
                System.out.println(asNumbers + "   " + asText);
            }

        }
    }
}
