//package rl.prog2.demos.gui.fx.dice;
//
//import java.util.Random;
//
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Simple dice simulator application with two buttons. It creates random numbers
// * between 1 and 6 and shows them to the user. Event handlers are used to
// * define the reactions on button events.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulator1 extends DiceSimulator0b {
//
//	protected static Random rand = new Random();
//
//	/** Creates a window and starts the application. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Starts the application. */
//	@Override
//	protected void createScene(Stage primaryStage) {
//		super.createScene(primaryStage);
//		primaryStage.setTitle("Dice Simulator 1");
//
//		throwBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent ev) {
//				throwDie();
//			}});
//		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent ev) {
//				Platform.exit();
//			}});
////		throwBtn.setOnAction(ev -> System.out.println("A"));
////		throwBtn.addEventHandler(ActionEvent.ACTION, ev -> System.out.println("B"));
////		throwBtn.addEventHandler(ActionEvent.ACTION, ev -> System.out.println("C"));
//
//		// short version using lambda expressions:
////		throwBtn.setOnAction(ev -> throwDie());
////		exitBtn.setOnAction(ev -> Platform.exit());
//	}
//
//	/** Throws a die and displays the face value in the face value field. */
//	public void throwDie() {
//		int value = rand.nextInt(6) + 1;
//		faceValueField.setText(Integer.toString(value));
//	}
//}
