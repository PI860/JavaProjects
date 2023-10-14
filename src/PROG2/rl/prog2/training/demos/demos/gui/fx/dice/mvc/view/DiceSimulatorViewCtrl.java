//package rl.prog2.demos.gui.fx.dice.mvc.view;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.MenuItem;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.SpinnerValueFactory;
//import javafx.scene.layout.FlowPane;
//import rl.prog2.demos.gui.fx.dice.mvc.controller.DiceSimulatorCmd;
//import rl.prog2.demos.gui.fx.dice.mvc.controller.DiceSimulatorController;
//
///**
// * Code-behind file which focuses on the user event to controller
// * command mapping, and on the communication with the controller.
// *
// * @author Ruediger Lunde
// *
// */
//public class DiceSimulatorViewCtrl implements Initializable {
//
//	DiceSimulatorController controller;
//
//	@FXML
//	private MenuItem exitItem;
//	@FXML
//	private MenuItem aboutItem;
//	@FXML
//	ComboBox<String> dieCountCombo; // Integer leads to class cast exception in jre1.8.0_77
//	@FXML
//	Spinner<Integer> faceCountSpin;
//	@FXML
//	private Button clearBtn;
//	@FXML
//	FlowPane diePane;
//	@FXML
//	private Button throwBtn;
//
//	public void setController(DiceSimulatorController controller) {
//		this.controller = controller;
//	}
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		dieCountCombo.getItems().addAll("1", "2", "3", "4", "5", "6");
//		dieCountCombo.setValue("1");
//		dieCountCombo.getEditor().setPrefColumnCount(2);
//		dieCountCombo.valueProperty()
//				.addListener((o, oldv, newv) -> controller.execute(DiceSimulatorCmd.CHANGE_DIE_COUNT, o));
//		faceCountSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 99, 6));
//		faceCountSpin.getEditor().setPrefColumnCount(4);
//		faceCountSpin.valueProperty()
//				.addListener((o, oldv, newv) -> controller.execute(DiceSimulatorCmd.CHANGE_FACE_COUNT, o));
//	}
//
//	@FXML
//	public void handle(ActionEvent ev) {
//		Object source = ev.getSource();
//		if (source == exitItem) {
//			Platform.exit();
//		} else if (source == aboutItem) {
//			controller.execute(DiceSimulatorCmd.ABOUT, exitItem);
//		} else if (source == clearBtn) {
//			controller.execute(DiceSimulatorCmd.CLEAR_DICE, clearBtn);
//		} else if (source == throwBtn) {
//			controller.execute(DiceSimulatorCmd.THROW_DICE, throwBtn);
//		}
//	}
//}
