//package rl.prog2.demos.gui.fx;
//
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.SplitPane;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.scene.control.ToggleButton;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.control.ToolBar;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Demonstrates how to use <code>TabPane</code>, <code>SplitPane</code> and
// * <code>StackPane</code>. A frame with a <code>ToolBar</code> and a
// * <code>StackPane</code> is constructed. Two items are added to the pane, a
// * <code>TabPane</code>, and a <code>SplitPane</code>. Visibility is controlled
// * by a <code>ComboBox</code>.
// *
// * @author Ruediger Lunde
// */
//public class FXContainerDemo extends Application {
//	/** Starts the demo. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Adds several components to the stage, and shows it. */
//	public void start(Stage primaryStage) {
//		StackPane stackPane = new StackPane();
//		stackPane.getChildren().addAll(createTabPane(), createSplitPane());
//		ToolBar toolbar = new ToolBar();
//
//		// ComboBox<String> combo = new ComboBox<String>();
//		// combo.getItems().addAll("TabPane", "SplitPane");
//		// combo.setTooltip(new Tooltip("Controls which card is shown."));
//		// combo.valueProperty().addListener(new ChangeListener<String>() {
//		// @Override
//		// public void changed(ObservableValue<? extends String> obs, String o,
//		// String n) {
//		// ObservableList<String> items = combo.getItems();
//		// for (int i = 0; i < stackPane.getChildren().size(); i++) {
//		// stackPane.getChildren().get(i).setVisible(n.equals(items.get(i)));
//		// }
//		// }});
//		// toolbar.getItems().add(combo);
//		// combo.setValue("TabPane");
//
//		// Define buttons
//		final ToggleButton b0 = new ToggleButton("TabPane");
//		final ToggleButton b1 = new ToggleButton("SplitPane");
//		ToggleGroup tg = new ToggleGroup();
//		tg.getToggles().addAll(b0, b1);
//		ChangeListener<Boolean> listener = (obs, o, n) -> {
//			stackPane.getChildren().get(0).setVisible(b0.isSelected());
//			stackPane.getChildren().get(1).setVisible(b1.isSelected());
//			stackPane.requestLayout();
//		};
//		b0.selectedProperty().addListener(listener);
//		b1.selectedProperty().addListener(listener);
//		toolbar.getItems().addAll(b0, b1);
//
//		BorderPane rootPane = new BorderPane();
//		rootPane.setTop(toolbar);
//		rootPane.setCenter(stackPane);
//
//		primaryStage.setTitle("FX Container Demo");
//		primaryStage.setScene(new Scene(rootPane, 600, 400));
//		primaryStage.show();
//		b0.setSelected(true); // call this after show!
//	}
//
//	TabPane createTabPane() {
//		TabPane result = new TabPane();
//		Pane pane1 = createPaneWithButton("Button in first component");
//		Pane pane2 = createPaneWithButton("Button in second component");
//		result.getTabs().addAll(new Tab("Tab 1", pane1), new Tab("Tab 2", pane2));
//		return result;
//	}
//
//	SplitPane createSplitPane() {
//		SplitPane result = new SplitPane();
//		//result.setOrientation(Orientation.VERTICAL);
//		result.setDividerPosition(0, 0.4);
//		Pane pane1 = createPaneWithButton("Button in left component");
//		Pane pane2 = createPaneWithButton("Button in right component");
//		result.getItems().addAll(pane1, pane2);
//		return result;
//	}
//
//	Pane createPaneWithButton(String txt) {
//		StackPane pane = new StackPane();
//		Button btn = new Button(txt);
//		pane.getChildren().add(btn);
//		return pane;
//	}
//}
