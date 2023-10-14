package pp.prog2.training.javaFX;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Paulina Pyczot
 * @date 17.05.2023
 **/

public class PhotoViewerApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PhotoViewer.fxml"));
        loader.load();

        Pane root = new Pane();
        stage.setTitle("Simple Photo Viewer");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
