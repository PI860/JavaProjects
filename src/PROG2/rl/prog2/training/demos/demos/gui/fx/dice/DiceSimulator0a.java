//package rl.prog2.demos.gui.fx.dice;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Simple dice simulator application which consists of a window showing a face
// * value as text and two buttons. This implementation focuses on layout aspects
// * and doesn't provide any function.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulator0a extends Application {
//
//	protected TextField faceValueField;
//	protected Button throwBtn;
//
//	/** Creates a window and starts the application. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Starts the application. */
//	@Override
//	public void start(Stage primaryStage) {
//		createScene(primaryStage);
//		primaryStage.show();
//	}
//
//	protected void createScene(Stage primaryStage) {
//		Label label = new Label("Current face value:");
//
//		faceValueField = new TextField();
//		faceValueField.setText("1");
//		faceValueField.setPrefColumnCount(4);
//		throwBtn = new Button("Throw");
//
//		BorderPane root = new BorderPane();
//		root.setTop(label);
//		root.setCenter(faceValueField);
//		root.setBottom(throwBtn);
//
//		primaryStage.setTitle("Dice Simulator 0");
//		primaryStage.setScene(new Scene(root));
//	}
//}