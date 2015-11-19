package Logic;

/**
 * Created by alexanderlindkjaer on 17/11/2015.
 */

import SDK.Logic;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class LoginController {


    public Button buttonLogin;
    public Label labelConfirm;


    Logic logic = new Logic();



    public void action(){

        logic.login("HeinHero","321");

        buttonLogin.setText("Succes");
        labelConfirm.setText("you logged in");

    }




}
