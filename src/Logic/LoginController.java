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
    public Label usernameErrorLbl, passwordErrorLbl, loginErrorLbl;

    //menu components
    @FXML
    public Button logoutButton;

    //createUser components
    @FXML
    public Hyperlink logout;
    public Button createUserButton;
    public Label firstNameCreateUserLabel, lastNameCreateUserLabel, userNameCreateUserLabel, passwordCreateUserLabel,
            emailCreateUserLabel, createUserErrorLbl, emptyFieldErrorLbl, succesLbl ;
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

            passwordErrorLbl.setVisible(false);
            usernameErrorLbl.setVisible(true);

            loginErrorLbl.setVisible(false);
        }
        //if passwordfield is empty = error message
        if (passwordText.getText().equals("")){

            usernameErrorLbl.setVisible(false);
            passwordErrorLbl.setVisible(true);

            loginErrorLbl.setVisible(false);
        }

        if (passwordText.getText().equals("") && usernameText.getText().equals("")){

            usernameErrorLbl.setVisible(true);
            passwordErrorLbl.setVisible(true);

            loginErrorLbl.setVisible(false);
        }

        if(logic.userAuth(usernameText.getText(),passwordText.getText())){

            usernameErrorLbl.setVisible(false);
            passwordErrorLbl.setVisible(false);
            loginErrorLbl.setVisible(false);


            myController.setScreen(Main.screenMenuID);


        } else {

            usernameErrorLbl.setVisible(false);
            passwordErrorLbl.setVisible(false);

            loginErrorLbl.setVisible(true);

        }


    }

    public void newUserStage() throws IOException{

        myController.setScreen(Main.screenCreateUserID);

    }

    @FXML
    public void logout () throws IOException{
//
//        usernameText.setText("");
//        passwordText.setText("");
//        succesLbl.setVisible(false);

        myController.setScreen(Main.screenLoginID);


    }

    public void createNewUser(){
        //TODO make error and ok messages
        //TODO-maybe: make required password length(and double type it) and check for correct email format

        if(firstNameCreateUserText.getText().equals("") && lastNameCreateUserText.getText().equals("") && userNameCreateUserText.getText().equals("") &&
                passwordCreateUserText.getText().equals("") && emailCreateUserText.getText().equals("") ){

            emptyFieldErrorLbl.setVisible(true);
            createUserErrorLbl.setVisible(false);

            succesLbl.setVisible(false);

        }


        if(logic.createUser(firstNameCreateUserText.getText(),lastNameCreateUserText.getText(),userNameCreateUserText.getText(),
                passwordCreateUserText.getText(),emailCreateUserText.getText())){

            emptyFieldErrorLbl.setVisible(false);
            createUserErrorLbl.setVisible(false);

            succesLbl.setVisible(true);

        }else {
            emptyFieldErrorLbl.setVisible(false);
            createUserErrorLbl.setVisible(true);

            succesLbl.setVisible(false);
        }
    }

    public void joinGame() throws IOException{
        myController.setScreen(Main.screenMenuID);
    }

    public void createGame(){
        myController.setScreen(Main.screenCreateGameID);

    }

    public void highscores(){

        myController.setScreen(Main.screenHighscoresID);

    }

    public void deleteGame(){

        myController.setScreen(Main.screenDeleteGameID);


    }






}
