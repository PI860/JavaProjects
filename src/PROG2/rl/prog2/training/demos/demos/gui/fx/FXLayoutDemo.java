//package rl.prog2.demos.gui.fx;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.RowConstraints;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.TilePane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Creates frames which demonstrate the behavior of panes with different layout
// * strategies.
// *
// * Fore details see: "Working With Layouts in JavaFX" at
// * https://docs.oracle.com/javafx/2/layout/jfxpub-layout.htm
// *
// * @author Ruediger Lunde
// */
//public class FXLayoutDemo extends Application {
//
//	public final static boolean MAKE_BUTTONS_RESIZABLE = false;
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public void start(Stage arg0) throws Exception {
//		showInStage("GridPane Example2", createGridPaneExample2());
//		showInStage("GridPane Example", createGridPaneExample());
//		showInStage("VBox Example", createExample(new VBox(10)));
//		showInStage("HBox with Allignment", createHBoxExample());
//		showInStage("HBox Example", createExample(new HBox(10)));
//		showInStage("TilePane Example", createExample(new TilePane(10, 20)));
//		showInStage("FlowPane Example", createExample(new FlowPane(10, 20)));
//		showInStage("BorderPane Example", createBorderPaneExample());
//		showInStage("StackPane Example", createStackPaneExample());
//		showInStage("Absolute Positioning Example", createAbsolutePositioningExample());
//	}
//
//	/** Adds six standard buttons to the pane and sets padding. */
//	public static Pane createExample(Pane pane) {
//		Button[] buttons = createButtons("Button 0", "Button 1", "Button 2", "Very Long Button 3", "Button 4",
//				"Button 5");
//		pane.getChildren().addAll(buttons);
//		pane.setPadding(new Insets(15, 15, 15, 15));
//		return pane;
//	}
//
//	/** Adds six standard buttons to the pane and sets padding. */
//	public static HBox createHBoxExample() {
//		Button[] buttons = createButtons("Button 0", "Button 1", "Button 2", "Very Long Button 3", "Button 4",
//				"Button 5");
//		HBox box = new HBox(10);
//		box.setAlignment(Pos.CENTER);
//		box.getChildren().addAll(buttons);
//		box.setPadding(new Insets(15, 15, 15, 15));
//		return box;
//	}
//
//
//	/**
//	 * Creates a BorderPane and adds 5 buttons at the 5 predefined positions.
//	 */
//	public static StackPane createStackPaneExample() {
//		Button[] buttons = createButtons("First", "Second", "Third", "Fourth");
//		double len = 300;
//		for (Button b : buttons) {
//			b.setMaxSize(len, len);
//			len -= 50;
//			b.setAlignment(Pos.TOP_CENTER);
//		}
//		StackPane pane = new StackPane();
//		pane.getChildren().addAll(buttons);
//		return pane;
//	}
//
//	/**
//	 * Creates a BorderPane and adds 5 buttons at the 5 predefined positions.
//	 */
//	public static BorderPane createBorderPaneExample() {
//		Button[] buttons = createButtons("TOP", "LEFT", "CENTER", "RIGHT", "BOTTOM");
//		BorderPane pane = new BorderPane();
//		pane.setTop(buttons[0]);
//		pane.setLeft(buttons[1]);
//		pane.setCenter(buttons[2]);
//		pane.setRight(buttons[3]);
//		pane.setBottom(buttons[4]);
//		return pane;
//	}
//
//	/**
//	 * Creates GridPane and adds six buttons at special grid positions.
//	 */
//	public static GridPane createGridPaneExample() {
//		GridPane pane = new GridPane();
//		Button[] buttons = createButtons("Button 0", "Button 1", "Button 2", "Very Long Button 3", "Button 4",
//				"Button 5");
//		pane.setAlignment(Pos.CENTER);
//		pane.setHgap(10);
//		pane.setVgap(10);
//		pane.setPadding(new Insets(15, 15, 15, 15));
//		// pane.setGridLinesVisible(true);
//
//		pane.add(buttons[0], 0, 0);
//		pane.add(buttons[1], 1, 0);
//		pane.add(buttons[2], 0, 1);
//		pane.add(buttons[3], 1, 1);
//		pane.add(buttons[4], 0, 2, 2, 1);
//		pane.add(buttons[5], 2, 0, 1, 3);
//		return pane;
//	}
//
//	/**
//	 * Creates GridPane and adds six buttons at special grid positions. In this version, columns and rows use the whole space available.
//	 */
//	public static GridPane createGridPaneExample2() {
//		GridPane pane = new GridPane();
//		Button[] buttons = createButtons("Button 0", "Button 1", "Button 2", "Very Long Button 3", "Button 4",
//				"Button 5");
//		pane.setHgap(10);
//		pane.setVgap(10);
//		pane.setPadding(new Insets(15, 15, 15, 15));
//		// pane.setGridLinesVisible(true);
//
//		pane.add(buttons[0], 0, 0);
//		pane.add(buttons[1], 1, 0);
//		pane.add(buttons[2], 0, 1);
//		pane.add(buttons[3], 1, 1);
//		pane.add(buttons[4], 0, 2, 2, 1);
//		pane.add(buttons[5], 2, 0, 1, 3);
//
//		RowConstraints c1 = new RowConstraints();
//		c1.setPercentHeight(33.3);
//		pane.getRowConstraints().addAll(c1, c1, c1);
//		ColumnConstraints c2 = new ColumnConstraints();
//		c2.setPercentWidth(33.3);
//		pane.getColumnConstraints().addAll(c2, c2, c2);
//
//		return pane;
//	}
//
//	/**
//	 * Creates a Pane and adds six buttons at
//	 * arbitrary positions. It is not recommended to use this pattern!
//	 */
//	public static Pane createAbsolutePositioningExample() {
//
//		Button[] buttons = createButtons("Button 0", "Button 1", "Button 2", "Very Long Button 3", "Button 4",
//				"Button 5");
//
//		buttons[0].setPrefSize(100, 50);
//		buttons[2].relocate(250, 30);
//		buttons[2].setPrefSize(100, 200);
//		buttons[3].relocate(150, 150);
//		buttons[3].setPrefSize(150, 100);
//		buttons[4].relocate(100, 180);
//		buttons[5].relocate(50, 200);
//
//		Pane pane = new Pane();
//		pane.getChildren().addAll(buttons);
//		return pane;
//	}
//
//
//	/** Creates Buttons (for each specified name one). */
//	private static Button[] createButtons(String... names) {
//		Button[] result = new Button[names.length];
//		String[] colors = new String[] { "red", "orange", "yellow", "green", "blue", "magenta" };
//		for (int i = 0; i < names.length; i++) {
//			result[i] = new Button(names[i]);
//			if (MAKE_BUTTONS_RESIZABLE)
//				result[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//			result[i].setStyle("-fx-text-fill: " + colors[i % colors.length]);
//		}
//		return result;
//	}
//
//	/** Creates a stage and a scene and shows the provided pane in it. */
//	private static void showInStage(String title, Pane pane) {
//		Stage stage = new Stage();
//		stage.setTitle(title);
//		stage.setScene(new Scene(pane));
//		stage.show();
//	}
//
//}
