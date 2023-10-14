//package rl.prog2.demos.gui.fx.dice.mvc.view;
//
//import java.io.IOException;
//import java.util.Observable;
//import java.util.Observer;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Spinner;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import rl.prog2.demos.gui.fx.dice.DieButton;
//import rl.prog2.demos.gui.fx.dice.mvc.controller.DiceSimulatorCmd;
//import rl.prog2.demos.gui.fx.dice.mvc.controller.DiceSimulatorController;
//import rl.prog2.demos.gui.fx.dice.mvc.model.DiceSimulatorModel;
//import rl.prog2.demos.gui.fx.dice.mvc.model.Die;
//
///**
// * View component of the dice simulator. It is responsible for the look of the
// * application. Most work is delegated to the FXML file
// * <code>DiceSimulatorView.fxml</code>, the corresponding code-behind file
// * <code>DiceSimulatorViewCtrl.java</code>, and the CSS file
// * <code>DiceSimulator.css</code> (in parent package). Events are mapped
// * to commands and then communicated to the controller component. The view
// * listens to model changes and updates accordingly.
// *
// * @author Ruediger Lunde
// *
// */
//public class DiceSimulatorView implements Observer {
//	private DiceSimulatorViewCtrl ctrl;
//	private DiceSimulatorModel model;
//
//	public DiceSimulatorView(Stage primaryStage, DiceSimulatorModel model) throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("DiceSimulatorView.fxml"));
//		AnchorPane pane = loader.load();
//		ctrl = loader.getController();
//		this.model = model;
//		model.addObserver(this);
//
//		primaryStage.setTitle("Dice Simulator MVC");
//		Scene scene = new Scene(pane);
//		scene.getStylesheets().add(DieButton.class.getResource("DiceSimulator.css").toExternalForm());
//		primaryStage.setScene(scene);
//	}
//
//	public ComboBox<String> getDieCountCombo() {
//		return ctrl.dieCountCombo;
//	}
//
//	public Spinner<Integer> getFaceCountSpin() {
//		return ctrl.faceCountSpin;
//	}
//
//	public Pane getDiePane() {
//		return ctrl.diePane;
//	}
//
//	public void setController(DiceSimulatorController controller) {
//		ctrl.controller = controller;
//	}
//
//	/**
//	 * Makes view state consistent to model state.
//	 */
//	@Override
//	public void update(Observable o, Object arg) {
//		if (!ctrl.dieCountCombo.getValue().equals(Integer.toString(model.getDieCount())))
//			ctrl.dieCountCombo.setValue(Integer.toString(model.getDieCount()));
//		if (ctrl.faceCountSpin.getValue() != model.getFaceCount())
//			ctrl.faceCountSpin.getValueFactory().setValue(model.getFaceCount());
//		if (ctrl.diePane.getChildren().size() != model.getDice().size()) {
//			ctrl.diePane.getChildren().clear();
//			for (int i = 0; i < model.getDice().size(); i++) {
//				final DieButton dieBtn = new DieButton(model.getFaceCount() < 7);
//				dieBtn.setOnAction(ev -> ctrl.controller.execute(DiceSimulatorCmd.CHANGE_DIE_SELECTION, dieBtn));
//				ctrl.diePane.getChildren().add(dieBtn);
//			}
//		}
//		for (int i = 0; i < model.getDice().size(); i++) {
//			DieButton dieBtn = (DieButton) ctrl.diePane.getChildren().get(i);
//			Die die = model.getDice().get(i);
//			if (dieBtn.isSelected() != die.isPutAside())
//				dieBtn.setSelected(die.isPutAside());
//			if (dieBtn.getFaceValue() != die.getFaceValue())
//				dieBtn.setFaceValue(die.getFaceValue());
//		}
//		// System.out.println("update");
//	}
//}
