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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;


public class LoginController {


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



    public void Login() throws IOException{

        //TODO make error messages.. search for a clearAllText kind of method in javaFX

        //if username field is empty = error message
        if(usernameText.getText().equals("")){

        }
        //if passwordfield is empty = error message
        if (passwordText.getText().equals("")){

        }

        if(logic.userAuth(usernameText.getText(),passwordText.getText())){

            //TODO: is this the best way to do it performance vice ? it has to "build" the new scene instead of having it preload/stacked like in Swing


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

    public void newUserStage() throws IOException{

        Stage stage;
        Parent root;

        //get reference to the button's stage
        stage=(Stage) newUserStage.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("/GUI/createUser.fxml"));

        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void logout (ActionEvent event) throws IOException{

        Stage stage = null;
        Parent root;

        if(event.getSource()==logout) {
            //get reference to the button's stage
            stage=(Stage) logout.getScene().getWindow();
        }

        if(event.getSource()==logoutButton) {
            //get reference to the button's stage
            stage=(Stage) logoutButton.getScene().getWindow();
        }

        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));

        //TODO fix this
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void createNewUser(){
        //TODO make error messages
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






}
