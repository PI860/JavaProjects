package pp.prog2.training.threads;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Calendar;


/**
 * @author Paulina Pyczot
 * @date 22.06.2023
 * Kommentiertes Beispiel für JAVA FX-App
 **/

public class DigiClock extends Application { //extends Application benötigt zum Einbinden einer Java-App

    private TextField textFld;
    private StackPane pane;

    //private String text;

    public static void main(String[] args) {
        launch(args);
    } // launch args startet Java-App aus "extends Application"

    public void start(Stage stage) {
        //System.out.println("test");
        textFld = new TextField();
        textFld.setAlignment(Pos.CENTER);
        textFld.setEditable(false);
        textFld.setPadding(new Insets(10));
        textFld.setFont(Font.font(30));
        textFld.setText("00:00:00");
        pane = new StackPane();
        pane.getChildren().add(textFld);
        stage.setScene(new Scene(pane));
        stage.setTitle("DigiClock");
        //runClock(); // darf nicht drin sein, wenn die while-Schleife unten läuft

        //Thread um die Uhr kontinuierlich zu aktualisieren:
        Thread thread = new Thread(this::runClock);
        //wird ersetzt durch ->  new Thread(() -> runClock());
        thread.setDaemon(true); //WICHTIG -> damit thread sich beendet, wenn haupt thread beendet wird -> ansonsten weiter laufend
        thread.start();

        Thread t1 = new Thread("AV");

        stage.show();
    }

    public void runClock() {
        while (true) {
            Calendar c = Calendar.getInstance();
            String text = String.format("%s:%s:%s", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
            Platform.runLater(() -> textFld.setText(text));
            //Threadabbruch:
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        //String text mit Uhrzeit(h,m,s aus Calendar-Klasse) ins Textfield übergeben (statisch!):
        //textFld.setText(text); Test,
        //pane.getChildren().add(new TextField()); //kritisch mit Thread zusammen

        //Threadanzeige: String text mit Uhrzeit(h,m,s aus Calendar-Klasse) ins Textfield übergeben (dynamisch!):
        //Schlechter:
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                textFld.setText(text);
//            }
//        });

        //Besser mit Lambda-Ausdruck!:


        //c.get(Calendar.MINUTE);
        //System.out.println(c.get(Calendar.MINUTE));
        //DateTimeFormatter.ofPattern("hh:mm:ss");

    }
}
