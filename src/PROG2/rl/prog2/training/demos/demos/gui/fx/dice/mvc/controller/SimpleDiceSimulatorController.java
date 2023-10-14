//package rl.prog2.demos.gui.fx.dice.mvc.controller;
//
//import javafx.application.Platform;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import rl.prog2.demos.gui.fx.dice.DieButton;
//import rl.prog2.demos.gui.fx.dice.mvc.model.DiceSimulatorModel;
//import rl.prog2.demos.gui.fx.dice.mvc.view.DiceSimulatorView;
//
///**
// * Implements a controller for the dice simulator. It knows model and view,
// * reacts to view commands originating from user events, and is responsible for
// * translating abstract view commands into sequences of concrete model
// * operations to change the state of the application.
// *
// * @author Ruediger Lunde
// */
//public class SimpleDiceSimulatorController implements DiceSimulatorController {
//
//	private DiceSimulatorModel model;
//	private DiceSimulatorView view;
//
//	public SimpleDiceSimulatorController(DiceSimulatorView view, DiceSimulatorModel model) {
//		this.view = view;
//		this.model = model;
//	}
//
//	@Override
//	public void execute(DiceSimulatorCmd cmd, Object source) {
//		switch (cmd) {
//		case CHANGE_DIE_COUNT:
//			model.setDieCount(Integer.parseInt(view.getDieCountCombo().getValue()));
//			break;
//		case CHANGE_FACE_COUNT:
//			model.setFaceCount(view.getFaceCountSpin().getValue());
//			break;
//		case CHANGE_DIE_SELECTION:
//			DieButton dieBtn = (DieButton) source;
//			model.putAside(view.getDiePane().getChildren().indexOf(dieBtn), dieBtn.isSelected());
//			break;
//		case CLEAR_DICE:
//			model.clearDice();
//			break;
//		case THROW_DICE:
//			model.throwDice();
//			break;
//		case ABOUT:
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("About Dialog");
//			alert.setHeaderText("Dice Simulator App");
//			alert.setContentText("This application demonstrates how to work with FXML and the Scene Builder."
//					+ " Select dies to put them aside.");
//
//			alert.showAndWait();
//			break;
//		case EXIT:
//			Platform.exit();
//		}
//	}
//}
