//package rl.prog2.demos.gui.fx.dice;
//
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Simple dice simulator application with two buttons. It creates random numbers
// * between 1 and 6 and shows them to the user. A Cascading Style Sheet (CSS) is
// * used to give the application a fancy look.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulator2 extends DiceSimulator1 {
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
//		primaryStage.setTitle("Dice Simulator 2");
//
//		// Define a new style class, so that different groups of buttons can
//		// be rendered in different styles.
//		throwBtn.getStyleClass().add("my-button");
//		exitBtn.getStyleClass().add("my-button");
//		// Define ids for some of the components so that they can be rendered
//		// in a special way.
//		exitBtn.setId("exitBtn");
//		faceValueField.setId("faceValueField");
//
//		Scene scene = primaryStage.getScene();
//		// Finally, load and apply the style sheet.
//		scene.getStylesheets().add(getClass().getResource("DiceSimulator.css").toExternalForm());
//	}
//
//}