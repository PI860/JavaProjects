//package rl.prog2.demos.gui.fx;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Simple application which opens a window showing a button with the text
// * "Hello World!".
// *
// * @author Ruediger Lunde
// *
// */
//public class HelloWorld extends Application {
//
//	/** Creates a window and starts the application. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Starts the application. */
//	@Override
//	public void start(Stage primaryStage) {
//
//		// Create a button and set its text.
//		Button btn = new Button("Hello World :-)");
//		btn.setFont(Font.font("SansSerif", FontWeight.EXTRA_BOLD, 30));
//		// Add the button to a pane. It is resizable and shows the button in its center.
//		StackPane pane = new StackPane();
//		pane.getChildren().add(btn);
//
//		// Create a top-level container for the stage, define its content and size.
//		Scene scene = new Scene(pane, 300, 200);
//
//		primaryStage.setTitle("My first GUI");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//}
