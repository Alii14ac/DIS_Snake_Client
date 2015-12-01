package Logic;

import SDK.Loogic;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by alexanderlindkjaer on 01/12/2015.
 */
public class TableController implements Initializable, GUI.ControlledScreen {
    ScreensController myController;
    Loogic logic = new Loogic();
    Main main = new Main();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
}
