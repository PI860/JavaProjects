package pp.prog2.training.javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
//import java.awt.*;

public class NmToKmConverter extends Application {

    private TextField nmField;
    private TextField kmField;

    @Override
    public void start(Stage stage) throws Exception {
        Label nmLabe = new Label("Nautical Miles");
        nmField = new TextField();
        Button convertBtn = new Button("Convert");
        Label kmLabel = new Label("");
        kmField = new TextField();
        HBox root = new HBox(10);
        root.setPadding(new Insets(200)); // Größe der HBox
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nmLabe, nmField, convertBtn, kmField, kmLabel);


        //add event handlers
        // convertBtn.setOnAction(new EventHandler<ActiveEvent>());

        //set up stage
        stage.setTitle("nautical miles to kilometers converter");
        stage.setScene(new Scene(root));
        stage.show();

    }

    private void convert() {
        String nmText = nmField.getText();
    }

    //psvm in NmToKmConverter2 implementiert!
    //public static void main(String[] args) {
    //    launch(args);
    //}

}

