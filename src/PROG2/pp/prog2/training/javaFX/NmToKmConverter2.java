package pp.prog2.training.javaFX;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 10.05.2023
 **/

public class NmToKmConverter2 extends NmToKmConverter{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        super.start(stage);
        stage.setTitle("Nm to km Converter");
        Scene scene = stage.getScene();
        scene.getStylesheets().add(getClass().getResource("NmToKmConverter.css").toExternalForm());

    }
}
