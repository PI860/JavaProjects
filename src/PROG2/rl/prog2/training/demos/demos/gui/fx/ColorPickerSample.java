package rl.prog2.demos.gui.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Locale;

// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

/**
 * Demonstrates the use of a color picker. The code is a slightly modified
 * version of: http://docs.oracle.com/javafx/2/ui_controls/color-picker.htm
 *
 * @author Ruediger Lunde
 */
public class ColorPickerSample extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Locale.setDefault(Locale.US);
		stage.setTitle("ColorPickerSample");
		Scene scene = new Scene(new HBox(20), 400, 100);
		HBox box = (HBox) scene.getRoot();
		box.setPadding(new Insets(5, 5, 5, 5));
		// box.setStyle("-fx-background-color: rgb(0, 0, 255);");
		// box.setStyle("-fx-background-color: #0000FF;");

		final ColorPicker colorPicker = new ColorPicker();
		colorPicker.setValue(Color.CORAL);

		final Label label = new Label("Try the color picker!");
		label.setFont(Font.font("Verdana", 20));
		label.setTextFill(colorPicker.getValue());
		// label.setTextFill(Color.RED);
		// label.setTextFill(Color.rgb(255, 0, 0));

		colorPicker.setOnAction(ev -> label.setTextFill(colorPicker.getValue()));

		box.getChildren().addAll(colorPicker, label);

		stage.setScene(scene);
		stage.show();
	}
}
