//package rl.prog2.demos.gui.fx;
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Demonstrates how to access properties of JavaFX components and how to define
// * own objects with properties.
// *
// * @author Ruediger Lunde
// *
// */
//public class PropertyDemo extends Application {
//
//	/** Creates a window and starts the application. */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	/** Starts the application. */
//	@Override
//	public void start(Stage primaryStage) {
//		final StackPane pane = new StackPane();
//		final Rectangle rectangle = new Rectangle();
//
//		rectangle.widthProperty().bind(pane.widthProperty());
//		rectangle.heightProperty().bind(pane.heightProperty());
//
//		rectangle.widthProperty().addListener(new ChangeListener<Number>() {
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				System.out.println(observable + " oldValue:" + oldValue + " newValue: " + newValue);
//				// get width value from pane
//				System.out.println(pane.widthProperty().getValue());
//				System.out.println(pane.getWidth()); // short version
//
//				System.out.println(rectangle.getWidth());
//			}
//		});
//
//		primaryStage.setTitle("Property Demo - resize!");
//		primaryStage.setScene(new Scene(pane, 300, 200));
//		primaryStage.show();
//	}
//
//	static class Rectangle {
//		private DoubleProperty width = new SimpleDoubleProperty();
//		private DoubleProperty height = new SimpleDoubleProperty();
//
//		public final double getWidth() {
//			return width.get();
//		}
//
//		public void setWidth(double width) {
//			this.width.set(width);
//		}
//
//		public DoubleProperty widthProperty() {
//			return width;
//		}
//
//		public double getHeight() {
//			return height.get();
//		}
//
//		public void setHeight(double height) {
//			this.height.set(height);
//		}
//
//		public DoubleProperty heightProperty() {
//			return height;
//		}
//	}
//}
