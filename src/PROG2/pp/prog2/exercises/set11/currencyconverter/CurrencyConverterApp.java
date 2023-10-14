package pp.prog2.exercises.set11.currencyconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Paulina Pyczot
 * @date 11.06.2023
 **/

// Aufgabe 2:
public class CurrencyConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrencyConverter.fxml"));
        AnchorPane pane = loader.load();

        // FXML-Layout aus SceneBuilder auf Primärbühne anzeigen:
        primaryStage.setTitle("Currency Converter");
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("CurrencyConverter.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
