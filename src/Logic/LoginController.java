package Logic;

/**
 * Created by alexanderlindkjaer on 17/11/2015.
 */

import SDK.Loogic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable, GUI.ControlledScreen {

    ScreensController myController;

    //login components
    @FXML
    public Button loginButton;
    public TextField usernameText;
    public PasswordField passwordText;
    public Hyperlink newUserStage;

    //menu components
    @FXML
    public Button logoutButton;

    //createUser components
    @FXML
    public Hyperlink logout;
    public Button createUserButton;
    public Label firstNameCreateUserLabel, lastNameCreateUserLabel, userNameCreateUserLabel, passwordCreateUserLabel,
            emailCreateUserLabel;
    public TextField firstNameCreateUserText, lastNameCreateUserText, userNameCreateUserText,passwordCreateUserText,
            emailCreateUserText;




    Loogic logic = new Loogic();
    Main main = new Main();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    public void Login() throws IOException{

        //TODO make error messages.. search for a clearAllText kind of method in javaFX

        //if username field is empty = error message
        if(usernameText.getText().equals("")){

        }
        //if passwordfield is empty = error message
        if (passwordText.getText().equals("")){

        }

        if(logic.userAuth(usernameText.getText(),passwordText.getText())){



            myController.setScreen(Main.screenMenuID);


        }


    }

    public void newUserStage() throws IOException{

        myController.setScreen(Main.screenCreateUserID);

    }

    @FXML
    public void logout () throws IOException{

        myController.setScreen(Main.screenLoginID);

    }

    public void createNewUser(){
        //TODO make error and ok messages
        //TODO-maybe: make required password length(and double type it) and check for correct email format

        if(firstNameCreateUserText.getText().equals("")){

        }
        if(lastNameCreateUserText.getText().equals("")){

        }
        if(userNameCreateUserText.getText().equals("")){

        }
        if(passwordCreateUserText.getText().equals("")){

        }
        if(emailCreateUserText.getText().equals("")){

        }

        if(logic.createUser(firstNameCreateUserText.getText(),lastNameCreateUserText.getText(),userNameCreateUserText.getText(),
                passwordCreateUserText.getText(),emailCreateUserText.getText())){

        }
    }

    public void play(){

    }

    public void highscores(){

    }

    public void deleteGame(){

    }






}
