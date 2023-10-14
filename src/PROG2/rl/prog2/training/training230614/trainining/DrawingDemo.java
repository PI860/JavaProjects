package rl.prog2.training.training230614.trainining;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 14.06.2023
 **/

public class DrawingDemo extends Application {

    private Canvas canvas;
    private double x;
    private double y;

    public void start(Stage stage) { //Klausurrelevant!!!!
        Pane root = new Pane();
        canvas = new Canvas(1000, 500);
        root.getChildren().add(canvas);

        canvas.setOnMousePressed(this::onMousePressed);
        canvas.setOnMouseDragged(this::onMouseDragged);

        stage.setScene(new Scene(root));
        stage.setTitle("Drawing App");
        stage.show();

    }
    public static void main(String[] args) {launch(args);}

    void onMousePressed(MouseEvent me) { //me = mouse event
        //System.out.println("Pressed"); // zum Testen, ob Methode funktioniert (Konsole zeigt dann beim Klicken der Maus "Pressed" an)
        x = me.getX();
        y = me.getY();
    }

    void onMouseDragged(MouseEvent me) {
        //System.out.println("Dragged"); // zum Testen, ob Methode funktioniert (Konsole zeigt dann beim Ziehen der Maus die ganze Zeit "Dragged" an)
        GraphicsContext gc = canvas.getGraphicsContext2D();

        if (me.getButton() == MouseButton.PRIMARY) { // Zeichnen
            gc.setLineWidth(4);
            gc.setStroke(Color.BLACK);
        } else { // Radiergummi
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(8); // Dicke der weißen Linie = Radiergummi
        }

        // Zeichnen:
        //gc.fillOval(me.getX(), me.getY(), 4, 4); // Test
        gc.strokeLine(x,y,me.getX(),me.getY());
        x = me.getX();
        y = me.getY();
    }

}
