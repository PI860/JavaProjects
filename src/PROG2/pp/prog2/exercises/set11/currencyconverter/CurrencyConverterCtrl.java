package pp.prog2.exercises.set11.currencyconverter;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @author Paulina Pyczot
 * @date 11.06.2023
 **/

public class CurrencyConverterCtrl implements Initializable {

    private Random random;
    @FXML
    private Button convertBtn;
    @FXML
    private ChoiceBox to;
    public double amount;
    public double result;

    @FXML
    ChoiceBox from = new ChoiceBox(FXCollections.observableArrayList(
            "Euro","US-Dollar","Japanischer Yen","Britisches Pfund","Australischer Dollar","Kanadischer Dollar","Schweizer Franken","Chinesischer Renminbi","Schwedische Krone","Neuseeländischer Dollar")
    );
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        random = new Random();

    }
}
