package pp.prog2.training.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 03.05.2023
 * Template für Run Configurations JavaFX:
 * VM options: --module-path "C:\Program Files\JavaFX\javafx-sdk-20.0.1\lib"  --add-modules javafx.controls,javafx.graphics,javafx.fxml
 * siehe auch https://moodle-thu.de/pluginfile.php/90652/mod_label/intro/javafx-guide.html
 **/


    public class myVeryFirstJavaFXProgram extends Application {
/** Creates a window and starts the application. */
        public static void main(String[] args) {
        launch(args);
        }
/** Starts the application. */

@Override
public void start(Stage stage) {
// Create a button and set its text.
        Button btn = new Button("my very first button");
        Button start = new Button("Start");
        btn.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 30)); // funktioniert nicht mit java.awt
        //btn.setFont(Font.getFont(Font.SERIF));
// Add it to a pane which is resizable and shows the button in its center.
        GridPane gPane= new GridPane();
        gPane.setHgap(5);
        gPane.setVgap(5);
        gPane.getChildren().add(btn); // funktioniert nicht mit java.awt

        // Test für PROG2 Klausur mit gpane in hbox funktioniert nicht:
        //HBox hBox = new HBox();
        //hBox.getChildren().add(start,gPane,btn);

        //StackPane sPane = new StackPane();
        //sPane.getChildren().add(gPane,start);

// Create a top-level container for the stage, define its content and size.
        // Scene scene= new Scene(sPane, 300, 200);
        stage.setTitle("My first GUI");
        stage.setScene(new Scene(gPane));
        stage.show();
        }
        }
