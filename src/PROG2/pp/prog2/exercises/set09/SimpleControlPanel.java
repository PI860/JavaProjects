package pp.prog2.exercises.set09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 15.05.2023
 **/

// Aufgabe 1:
public class SimpleControlPanel extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Top:
        HBox hBoxTop = new HBox(20);
        hBoxTop.setAlignment(Pos.CENTER);
        hBoxTop.setPadding(new Insets(2));
        Button f1 = new Button("F1");
        Button f2 = new Button("F2");
        Button f3 = new Button("F3");
        Button f4 = new Button("F4");
        hBoxTop.getChildren().addAll(f1,f2,f3,f4);

        //Center:
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(30));

        Button up = new Button("up");
        Button right = new Button("right");
        Button down = new Button("down");
        Button left = new Button("left");

        up.setPrefWidth(Double.MAX_VALUE);
        right.setPrefWidth(Double.MAX_VALUE);
        down.setPrefWidth(Double.MAX_VALUE);
        left.setPrefWidth(Double.MAX_VALUE);

        gridPane.add(up,1,0);
        gridPane.add(right,2,1);
        gridPane.add(down,1,2);
        gridPane.add(left,0,1);

        RowConstraints c1 = new RowConstraints();
        c1.setPercentHeight(33.3);
        gridPane.getRowConstraints().addAll(c1, c1, c1);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(33.3);
        gridPane.getColumnConstraints().addAll(c2, c2, c2);

        //Bottom:
        Button exit = new Button("Exit");
        exit.setPrefWidth(Double.MAX_VALUE);

        //Border Pane:
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBoxTop);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(exit);

        stage.setTitle("Simple Control Panel");
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
