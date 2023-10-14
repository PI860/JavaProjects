//package rl.prog2.demos.gui.fx.dice;
//
//import javafx.beans.binding.Bindings;
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.geometry.HPos;
//import javafx.geometry.VPos;
//import javafx.scene.Node;
//import javafx.scene.control.ToggleButton;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.RowConstraints;
//import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//
///**
// * Implements a die control as toggle button. The face value is displayed with
// * dots. A property is used to represent the current face value. Property
// * bindings make sure that the dot size always fits to button size.
// *
// * @author Ruediger Lunde
// *
// */
//public class DieButton extends ToggleButton {
//	/**
//	 * Property encapsulating the face value state.
//	 */
//	private IntegerProperty faceValue;
//	private GridPane grid;
//	/**
//	 * Stores at index face value minus one the indices of the dot position. Position coding: first
//	 * row 0, 1, 2; second row 3, 4, 5; third row 6, 7, 8.
//	 */
//	private static int[][] dotPositions = new int[][] { { 4 }, { 2, 6 }, { 2, 4, 6 }, { 0, 2, 6, 8 }, { 0, 2, 4, 6, 8 },
//			{ 0, 2, 3, 5, 6, 8 } };
//	/**
//	 * Controls whether face values are displayed as dots or as text. For face
//	 * values greater than 6 dots will not work correctly.
//	 */
//	private final boolean dotsEnabled;
//
//	public DieButton() {
//		this(true);
//	}
//
//	public DieButton(boolean dotsEnabled) {
//		faceValue = new SimpleIntegerProperty();
//		this.dotsEnabled = dotsEnabled;
//
//		if (dotsEnabled) {
//			grid = new GridPane();
//			ColumnConstraints cc = new ColumnConstraints();
//			cc.setPercentWidth(100.0 / 3);
//			RowConstraints rc = new RowConstraints();
//			rc.setPercentHeight(100.0 / 3);
//			grid.getColumnConstraints().setAll(cc, cc, cc);
//			grid.getRowConstraints().setAll(rc, rc, rc);
//			this.setGraphic(grid);
//
//			for (int pos = 0; pos < 9; pos++) {
//				Circle circle = new Circle();
//				// Bind the circle radius, so that it adapts to component size
//				// changes automatically.
//				circle.radiusProperty().bind(Bindings.divide(Bindings.min(widthProperty(), heightProperty()), 10.0));
//				GridPane.setHalignment(circle, HPos.CENTER);
//				GridPane.setValignment(circle, VPos.CENTER);
//				grid.add(circle, pos % 3, pos / 3);
//			}
//		} else {
//			setFont(Font.font("Arial", FontWeight.BOLD, 30));
//		}
//		// Make sure that a changed face value is displayed immediately.
//		faceValue.addListener(new ChangeListener<Number>() {
//			@Override
//			public void changed(ObservableValue<? extends Number> obs, Number oldValue, Number newValue) {
//				updateFaceValue();
//			}
//		});
//		// faceValue.addListener((obs, oldValue, newValue) -> updateFaceValue());
//		setFaceValue(1);
//		setPrefSize(80, 80);
//		setMinSize(10, 10);
//	}
//
//	/**
//	 * Returns the current face value.
//	 */
//	public int getFaceValue() {
//		return faceValue.get();
//	}
//
//	/**
//	 * Modifies the current face value.
//	 */
//	public void setFaceValue(int value) {
//		faceValue.set(value);
//	}
//
//	/**
//	 * Returns the current face value as property. Change listeners can be
//	 * registered this way and bindings can be defined if that makes sense.
//	 */
//	public IntegerProperty faceValueProperty() {
//		return faceValue;
//	}
//
//	/**
//	 * Modifies texts and dots to make the appearance of the component
//	 * consistent with the current face value.
//	 */
//	private void updateFaceValue() {
//		if (dotsEnabled) {
//			for (Node child : grid.getChildren())
//				child.setVisible(false);
//			for (int pos : dotPositions[faceValue.get() - 1])
//				grid.getChildren().get(pos).setVisible(true);
//		} else {
//			setText(Integer.toString(faceValue.get()));
//		}
//	}
//}
