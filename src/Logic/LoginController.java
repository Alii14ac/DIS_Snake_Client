package Logic;

/**
 * Created by alexanderlindkjaer on 17/11/2015.
 */

import SDK.Loogic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {


    //login components
    @FXML
    public Button loginButton;
    public Label makeNewUserLabel;
    public TextField usernameText;
    public PasswordField passwordText;

    //menu components
    @FXML
    public Button logoutButton;

    Loogic logic = new Loogic();
    Main main = new Main();



    public void Login() throws IOException{


        //if username field is empty = error message
        if(usernameText.getText().equals("")){

        }
        //if passwordfield is empty = error message
        if (passwordText.getText().equals("")){

        }


        if(logic.userAuth(usernameText.getText(),passwordText.getText())){

            //TODO: is this the best way to do it performance vice ? it has to "build" the new scene insted having it preload/stacked like in Swing
            //

            Stage stage;
            Parent root;

            //get reference to the button's stage
            stage=(Stage) loginButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("/GUI/menu.fxml"));

            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


    }




}
