package Logic;

/**
 * Created by alexanderlindkjaer on 17/11/2015.
 */

import SDK.Logic;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;



public class LoginController {


    public Button loginButton;
    public Label makeNewUserLabel;
    public TextField usernameText;
    public PasswordField passwordText;


    Logic logic = new Logic();



    public void Login(){

        //if username field is empty = error message
        if(usernameText.getText().equals("")){

        }
        //if passwordfield is empty = error message
        if (passwordText.getText().equals("")){

        }

        if(!usernameText.getText().equals("") && !passwordText.getText().equals("")){

            logic.login(usernameText.getText(),passwordText.getText());


        }


    }




}
