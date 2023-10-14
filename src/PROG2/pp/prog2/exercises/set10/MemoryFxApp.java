package pp.prog2.exercises.set10;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 22.05.2023
 **/


// Aufgabe 2 + 3:
public class MemoryFxApp extends Application {
    MemoryGame game = new MemoryGame();
    Button[] buttons;

    @Override
    public void start(Stage stage) throws Exception {

        //menuBar
        MenuItem newGame = new MenuItem("New Game");
        MenuItem exitItem = new MenuItem("Exit Game");
        exitItem.setOnAction(ev -> Platform.exit());
        newGame.setOnAction(ev -> newGame());
        Menu file = new Menu("File");
        file.getItems().addAll(exitItem, newGame);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file);

        //Center
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        buttons = new Button[12];
        String back = getClass().getResource("graphics/back.jpg").toExternalForm();
        for(int i = 0; i< buttons.length;i++){
            buttons[i] = new Button();
            buttons[i].setStyle("-fx-background-image: url('" + back + "'); "
                    + "-fx-background-size: cover;");
            gridPane.add(buttons[i],i%4,(int)Math.floor(i / 4.0));
            int finalIndex = i;
            buttons[i].setOnAction(ev -> game.turnCard(finalIndex));
            buttons[i].setPrefSize(200,200);
            game.getCard(i).stateProperty().addListener((observableValue, oldValue, newValue) -> {
                if (newValue) {
                    buttons[finalIndex].setStyle("-fx-background-image: url('" + game.getCard(finalIndex).getImageName()+ "'); "
                            + "-fx-background-size: cover;");
                    buttons[finalIndex].setDisable(true);
                } else {
                    buttons[finalIndex].setStyle("-fx-background-image: url('" + back + "'); "
                            + "-fx-background-size: cover;");
                    buttons[finalIndex].setDisable(false);
                }
            });
            game.getCard(i).ownerProperty().addListener((observable , oldValue, newValue) -> {
                if(newValue.intValue()== 1){
                    buttons[finalIndex].setDisable(true);
                    buttons[finalIndex].setStyle("-fx-background-color: #ce4a4a;");
                }
                else if (newValue.intValue()== 2){
                    buttons[finalIndex].setDisable(true);
                    buttons[finalIndex].setStyle("-fx-background-color: #228ad5 ;");
                }

            });
        }

        //Bottom
        Label statusLabel = new Label("Next Player: Red");

        game.getCurrPlayerProperty().addListener((v, oldValue, newValue) -> {
            if(newValue.intValue() == 1){
                statusLabel.setText("Next Player: Red");
            }else {
                statusLabel.setText("Next Player: Blue");
            }});

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(statusLabel);

        //Border Pane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox);

        //Stage & Scene
        Scene scene = new Scene(borderPane,1000,1000);
        scene.getStylesheets().add(getClass().getResource("MemoryApp.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Memory Game");
        stage.show();
    }

    private void newGame() {
        game.newGame();
        }
}
