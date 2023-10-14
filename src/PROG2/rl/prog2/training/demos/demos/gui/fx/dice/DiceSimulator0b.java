//package rl.prog2.demos.gui.fx.dice;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.Font;
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
//public class DiceSimulator0b extends Application {
//
//	protected TextField faceValueField;
//	protected Button throwBtn;
//	protected Button exitBtn;
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
//		label.setPadding(new Insets(0, 0, 10, 0));
//
//		faceValueField = new TextField();
//		// place text in the center if there is extra space
//		faceValueField.setAlignment(Pos.CENTER);
//		faceValueField.setPrefColumnCount(4);
//		faceValueField.setText("1");
//		faceValueField.setEditable(false);
//		faceValueField.setFocusTraversable(false);
//		faceValueField.setFont(Font.font(40));
//
//		throwBtn = new Button("Throw");
//		exitBtn = new Button("Exit");
//
//		HBox box = new HBox(10);
//		box.setPadding(new Insets(10, 0, 0, 0));
//		box.setAlignment(Pos.CENTER);
//		box.getChildren().addAll(throwBtn, exitBtn);
//
//		BorderPane root = new BorderPane();
//		root.setPadding(new Insets(10, 10, 10, 10));
//		root.setTop(label);
//		root.setCenter(faceValueField);
//		root.setBottom(box);
//
//		primaryStage.setTitle("Dice Simulator 0");
//		primaryStage.setScene(new Scene(root));
//	}
//}