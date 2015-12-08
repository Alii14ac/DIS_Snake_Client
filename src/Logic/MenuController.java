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


public class MenuController implements Initializable, GUI.ControlledScreen {

    ScreensController myController;

    //User currentUser;


    //TODO slet de components der ikke skal bruges direkte i controlleren


    //menu components
    @FXML
    public Button logoutButton;
    public Label currentUserLbl;






    Loogic logic = new Loogic();
    Main main = new Main();
    Dto dto = new Dto();




    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }



    public void newUserStage() throws IOException{

        myController.setScreen(Main.screenCreateUserID);

    }


    public void logout () throws IOException{

        logic.setCurrentUser(null);
        myController.setScreen(Main.screenLoginID);

    }





    public void joinGame() throws IOException {
        myController.setScreen(Main.screenJoinGameID);


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
