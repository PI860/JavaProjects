//package rl.prog2.demos.gui.fx;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressBar;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.Slider;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ToggleButton;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.RowConstraints;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Simple demo which shows some of the most important JavaFX components.
// *
// * @author Ruediger Lunde
// */
//public class FXComponentDemo extends Application {
//
//	/** Starts the demo. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Adds several components to the stage, and shows it. */
//	public void start(Stage primaryStage) {
//		GridPane pane = new GridPane();
//		pane.setPadding(new Insets(10, 10, 10, 10));
//		pane.setHgap(10);
//		pane.add(new Label("Label"), 0, 0);
//		pane.add(new Button("Button"), 1, 0);
//		pane.add(new ToggleButton("ToggleButton"), 0, 1);
//		pane.add(new CheckBox("CheckBox"), 1, 1);
//		ToggleGroup group = new ToggleGroup();
//		RadioButton button1 = new RadioButton("RadioButton 1");
//		button1.setToggleGroup(group);
//		pane.add(button1, 0, 2);
//		RadioButton button2 = new RadioButton("RadioButton 2");
//		button2.setToggleGroup(group);
//		pane.add(button2, 1, 2);
//		pane.add(withTitle(new Spinner<Integer>(0, 100, 5)), 0, 3);
//		pane.add(withTitle(new Slider()), 1, 3);
//		ComboBox<String> combo = new ComboBox<>();
//		combo.getItems().addAll("item 1", "item 2");
//		combo.setValue("item 1");
//		pane.add(withTitle(combo), 0, 4);
//		ProgressBar bar = new ProgressBar();
//		bar.setProgress(0.7);
//		pane.add(withTitle(bar), 1, 4);
//		pane.add(new TextField("TextField (one line only!)"), 0, 5);
//
//		pane.add(new ScrollPane(new TextArea(
//				"TextArea (should alway be\ncombined with a ScrollPane)")), 1, 5);
//		ColumnConstraints c1 = new ColumnConstraints();
//		RowConstraints c2 = new RowConstraints();
//		c1.setPercentWidth(50);
//		c2.setPercentHeight(100.0 / 6);
//		pane.getColumnConstraints().addAll(c1, c1);
//		pane.getRowConstraints().addAll(c2, c2, c2, c2, c2, c2);
//
//		primaryStage.setTitle("FX Component Demo");
//		primaryStage.setScene(new Scene(pane, 600, 400));
//		primaryStage.show();
//	}
//
//	/**
//	 * Places a title above a component showing the name of the
//	 * component class.
//	 */
//	Pane withTitle(Node comp) {
//		Pane result = new StackPane();
//		Label label = new Label(" " + comp.getClass()
//				.getSimpleName() + " ");
//		StackPane.setAlignment(label, Pos.TOP_LEFT);
//		StackPane.setAlignment(comp, Pos.CENTER_LEFT);
//		result.getChildren().addAll(label, comp);
//		return result;
//	}
//}
