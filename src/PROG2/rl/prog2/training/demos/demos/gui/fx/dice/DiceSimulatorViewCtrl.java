//package rl.prog2.demos.gui.fx.dice;
//
//import java.net.URL;
//import java.util.Random;
//import java.util.ResourceBundle;
//
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.MenuItem;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.SpinnerValueFactory;
//import javafx.scene.layout.FlowPane;
//
///**
// * Code-behind file. It adds some aspects to the layout defined in the <code>DiceSimulatorView.fxml</code>
// * file and defines the reactions on user events.
// *
// * @author Ruediger Lunde
// */
//public class DiceSimulatorViewCtrl implements Initializable {
//
//	private Random rand;
//
//	@FXML
//	private MenuItem exitItem;
//	@FXML
//	private MenuItem aboutItem;
//	@FXML
//	private ComboBox<String> dieCountCombo; // Integer leads to class cast exception in jre1.8.0_77
//	@FXML
//	private Spinner<Integer> faceCountSpin;
//	@FXML
//	private Button clearBtn;
//	@FXML
//	private FlowPane diePane;
//	@FXML
//	private Button throwBtn;
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		rand = new Random();
//		dieCountCombo.getItems().addAll("1", "2", "3", "4", "5", "6");
//		dieCountCombo.setValue("1");
//		dieCountCombo.getEditor().setPrefColumnCount(2);
//		dieCountCombo.valueProperty().addListener((obs, o, n)-> clear());
//		faceCountSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 99, 6));
//		faceCountSpin.getEditor().setPrefColumnCount(4);
//		faceCountSpin.valueProperty().addListener((obs, o, n)-> clear());
//	}
//
//	@FXML
//	public void handle(ActionEvent ev) {
//		Object source = ev.getSource();
//		if (source == exitItem) {
//			Platform.exit();
//		} else if (source == aboutItem) {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("About Dialog");
//			alert.setHeaderText("Dice Simulator App");
//			alert.setContentText("This application demonstrates how to work with FXML and the Scene Builder."
//					+ " Select dies to put them aside.");
//
//			alert.showAndWait();
//		} else if (source == clearBtn) {
//			clear();
//		} else if (source == throwBtn) {
//			throwDice();
//		}
//	}
//
//
//	public void clear() {
//		diePane.getChildren().clear();
//	}
//
//	public void throwDice() {
//		if (diePane.getChildren().isEmpty()) {
//			int dieCount = Integer.parseInt(dieCountCombo.getValue());
//			for (int i = 0; i < dieCount; i++) {
//				DieButton die = new DieButton(faceCountSpin.getValue() < 7);
//				diePane.getChildren().add(die);
//			}
//		}
//		for (Node child : diePane.getChildren()) {
//			DieButton die = (DieButton) child;
//			if (!die.isSelected()) {
//				die.setFaceValue(rand.nextInt(faceCountSpin.getValue()) + 1);
//				// die.setSelected(true);
//			}
//		}
//	}
//}
