package pp.prog2.exercises.set09;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 15.05.2023
 **/

// Aufgabe 3:
public class Counter3 extends Application {
    private int counter = 0;
    private TextField textField = new TextField("0");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        textField.setEditable(false);
        textField.setFont(Font.font(40));
        textField.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();

        Button count = new Button("Count");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");

        count.setOnAction(ev -> increaseCounter());
        reset.setOnAction(ev -> resetCounter());
        exit.setOnAction(ev -> Platform.exit());

        vBox.getChildren().addAll(textField,hBox);
        hBox.getChildren().addAll(count,reset,exit);
        vBox.setPadding(new Insets(10));
        hBox.setSpacing(10);

        stage.setScene(new Scene(vBox));
        stage.setTitle("Counter");
        stage.show();
    }

    private void exit() {
        Platform.exit();
    }

    private void resetCounter() {
        counter = 0;
        textField.setText(String.valueOf(counter));
    }

    private void increaseCounter() {
        counter++;
        textField.setText(String.valueOf(counter));
    }
}
