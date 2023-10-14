package pp.prog2.exercises.set09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 15.05.2023
 **/

// Aufgabe 2:
public class Counter2 extends Application {
    private int counter = 0;
    private TextField textField = new TextField("0");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        textField.setEditable(false);

        Button button = new Button("Count");
        button.setOnAction(ev -> increaseCounter());
        vBox.getChildren().addAll(textField,button);

        stage.setScene(new Scene(vBox));
        stage.setTitle("Counter");
        stage.show();
    }

    private void increaseCounter() {
        counter++;
        textField.setText(String.valueOf(counter));
    }
}
