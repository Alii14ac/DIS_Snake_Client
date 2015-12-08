package Logic;

/**
 * Created by alexanderlindkjaer on 17/11/2015.
 */

import SDK.Dto;
import SDK.Loogic;
import SDK.User;
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

    //User currentUser;


    //TODO slet de components der ikke skal bruges direkte i controlleren

    //login components
    @FXML
    public Button loginButton;
    @FXML public TextField usernameText;
    @FXML public PasswordField passwordText;
    public Hyperlink newUserStage;
    public Label usernameErrorLbl, passwordErrorLbl, loginErrorLbl;

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
    Dto dto = new Dto();




    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    public void Login() throws IOException{

        //TODO set username og password til en string istedet for at hent dem på den måde

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

            usernameText.clear();
            passwordText.clear();

            //TODO get menu to display currentuser


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


    public void logout () throws IOException{

        logic.setCurrentUser(null);
        myController.setScreen(Main.screenLoginID);

    }

//    public void showUser(){
//
//
//        currentUserLbl.setText(logic.getCurrentUser().getUsername());
//
//        myController.
//
//    }

    public void createNewUser(){
        //TODO make error and ok messages.. make local strings
        //TODO-maybe: make required password length(and double type it) and check for correct email format

        if(firstNameCreateUserText.getText().equals("") && lastNameCreateUserText.getText().equals("") && userNameCreateUserText.getText().equals("") &&
                passwordCreateUserText.getText().equals("") && emailCreateUserText.getText().equals("") ){

            emptyFieldErrorLbl.setVisible(true);
            createUserErrorLbl.setVisible(false);

            succesLbl.setVisible(false);

        }


        if(logic.createUser(firstNameCreateUserText.getText(),lastNameCreateUserText.getText(),userNameCreateUserText.getText(),
                passwordCreateUserText.getText(),emailCreateUserText.getText())) {

            logic.createGame("alexGameTest","wwwdddssss");

            emptyFieldErrorLbl.setVisible(false);
            createUserErrorLbl.setVisible(false);

            succesLbl.setVisible(true);



        }else {
            emptyFieldErrorLbl.setVisible(false);
            createUserErrorLbl.setVisible(true);

            succesLbl.setVisible(false);
        }
    }








}
