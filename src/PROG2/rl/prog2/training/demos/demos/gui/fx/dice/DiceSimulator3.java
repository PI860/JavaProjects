//package rl.prog2.demos.gui.fx.dice;
//
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Simple dice simulator application with two buttons. It creates random numbers
// * between 1 and 6 and shows them to the user. Here, a specialized button
// * component <code>DieButton</code> is used to visualize the die state. It
// * demonstrates how to customize JavaFX components. A special focus is set on properties
// * and property bindings.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulator3 extends DiceSimulator2 {
//
//	private DieButton dieBtn;
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
//		primaryStage.setTitle("Dice Simulator 3");
//
//		Scene scene = primaryStage.getScene();
//		BorderPane root = (BorderPane) scene.getRoot();
//		dieBtn = new DieButton();
//		BorderPane.setMargin(dieBtn, new Insets(20, 20, 20, 20));
//		root.setCenter(dieBtn);
//	}
//
//	/** Throws a die and displays the face value in the face value field. */
//	@Override
//	public void throwDie() {
//		int value = rand.nextInt(6) + 1;
//		dieBtn.setFaceValue(value);
//	}
//}