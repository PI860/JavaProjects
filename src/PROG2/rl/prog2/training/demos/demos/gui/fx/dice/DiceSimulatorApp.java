//package rl.prog2.demos.gui.fx.dice;
//
//import java.io.IOException;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Dice simulator application which consists of a window showing a menu, a tool
// * bar, a panel with die buttons, and some other controls. The layout is defined
// * in a separate XML file called <code>DiceSimulatorView.fxml</code> which was
// * created with the standard JavaFX GUI builder tool Scene Builder. A controller
// * class <code>DiceSimulatorViewCtrl</code> handles user events. This
// * implementation is self-contained, it doesn't extend the previous simulator
// * versions.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulatorApp extends Application {
//
//	/** Creates a window and starts the application. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Starts the application. */
//	@Override
//	public void start(Stage primaryStage) throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("DiceSimulatorView.fxml"));
//		AnchorPane pane = loader.load();
//
//		primaryStage.setTitle("Dice Simulator App");
//		Scene scene = new Scene(pane);
//		scene.getStylesheets().add(DieButton.class.getResource("DiceSimulator.css").toExternalForm());
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//}
