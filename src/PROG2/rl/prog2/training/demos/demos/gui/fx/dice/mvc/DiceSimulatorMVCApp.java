//package rl.prog2.demos.gui.fx.dice.mvc;
//
//import java.io.IOException;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//import rl.prog2.demos.gui.fx.dice.mvc.controller.DiceSimulatorController;
//import rl.prog2.demos.gui.fx.dice.mvc.controller.SimpleDiceSimulatorController;
//import rl.prog2.demos.gui.fx.dice.mvc.model.DiceSimulatorModel;
//import rl.prog2.demos.gui.fx.dice.mvc.view.DiceSimulatorView;
//
///**
// * Advanced version of the Dice Simulator. From the user perspective no
// * difference to <code>DiceSimulatorApp</code> is visible. It uses the same FXML
// * file for the layout (just with the controller class changed), the same die
// * buttons and the same CSS file. But the software architecture is completely
// * different. It follows the Model-View-Controller pattern. In contrast to the
// * first version, game logic and game visualization are completely separated.
// * The logic implementation is independent from the visualization. It can be run
// * and tested in completely different contexts if necessary.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulatorMVCApp extends Application {
//
//	/** Creates a window and starts the application. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Starts the application. */
//	@Override
//	public void start(Stage primaryStage) throws IOException {
//		DiceSimulatorModel model = new DiceSimulatorModel();
//		DiceSimulatorView view = new DiceSimulatorView(primaryStage, model);
//		DiceSimulatorController controller = new SimpleDiceSimulatorController(view, model);
//		view.setController(controller);
//		// synchronize view state with model state
//		view.update(null, null);
//		primaryStage.show();
//	}
//}
