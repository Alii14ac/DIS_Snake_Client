package Logic;

import SDK.Dto;
import SDK.Loogic;
import SDK.UserStats;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by alexanderlindkjaer on 01/12/2015.
 */
public class GameController implements Initializable, GUI.ControlledScreen {

    ScreensController myController;
    Loogic logic = new Loogic();
    Main main = new Main();
    private Dto dto;




    //create game components

    @FXML
    public Label gamNameErrorLbl, movesErrorLbl , newGameConfirmationLbl;
    public TextField gameNameTxt,movesTxt;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }


    public void menu(){

        myController.setScreen(Main.screenMenuID);
    }

    //TODO skal der laves et snakkespil? ellers skal der laves en controll der kun tillader wasd taster
    public void createGame(){

        String name = gameNameTxt.getText();
        String moves = movesTxt.getText();

        if(name.equals("")){

            gamNameErrorLbl.setVisible(true);
            movesErrorLbl.setVisible(false);
            newGameConfirmationLbl.setVisible(false);
        }

        else if(moves.equals("")){

            gamNameErrorLbl.setVisible(false);
            movesErrorLbl.setVisible(true);
            newGameConfirmationLbl.setVisible(false);
        }

        else if(logic.createGame(name,moves)){

            gamNameErrorLbl.setVisible(false);
            movesErrorLbl.setVisible(false);

            //TODO display the game ID
            newGameConfirmationLbl.setText("Game was created! ID: ");
            newGameConfirmationLbl.setTextFill(Color.WHITE);
            newGameConfirmationLbl.setVisible(true);

        }else {
            newGameConfirmationLbl.setText("Somthing went wrong");
            newGameConfirmationLbl.setTextFill(Color.RED);
            newGameConfirmationLbl.setVisible(true);
        }





    }


}
