package Logic;

import SDK.Dto;
import SDK.Game;
import SDK.Loogic;
import SDK.UserStats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.net.URL;
import java.util.ArrayList;
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


    //join game components
    @FXML
    public TableView<Game> table;
    public TextField joinGameID,joinControlls;
    public Label joinGameSuccesLbl,joinGameErrorLbl;
    //public TableColumn gameID,Host;

    //delete game components
    @FXML
    public TextField deleteGameID;
    public Label deleteGameErrorLbl,deleteGameSuccesLbl;


    @Override
    public void initialize(URL url, ResourceBundle rb) {



        //this is alreay set in fxml file
        //DCol.setCellValueFactory(new PropertyValueFactory<Game, Integer>("gameId"));

        //table.setItems(openGames);
    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    //TODO-PRIORITY GET THIS TO WORK!! posibles solutions: 1. make specific class instead of using the Game class 2. look at the cellValue 3. look at the way you set an ArrayList -> observableArrayList = observableList 4. look at what the server sends and if matches what i want to recieve

    public void populateTable(){

        //ArrayList<Game> data = logic.openGames();
        ObservableList<Game> openGames = FXCollections.observableArrayList(logic.openGames());
        table.setItems(openGames);

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

    public void joinGame(){

        int gameId = Integer.parseInt(joinGameID.getText());
        String controls = joinControlls.getText();

        joinGameSuccesLbl.setVisible(false);
        joinGameErrorLbl.setVisible(false);

        if(logic.joinGame(gameId, controls)){
            joinGameSuccesLbl.setVisible(true);
            joinGameErrorLbl.setVisible(false);
        }else{
            joinGameSuccesLbl.setVisible(false);
            joinGameErrorLbl.setVisible(true);
        }



    }

    public void deleteGame(){

        try {

            int gameID = Integer.parseInt(deleteGameID.getText());

            deleteGameErrorLbl.setVisible(false);
            deleteGameSuccesLbl.setVisible(false);


            if (logic.deleteGame(gameID)) {

                deleteGameErrorLbl.setVisible(false);
                deleteGameSuccesLbl.setVisible(true);

            } else {

                deleteGameErrorLbl.setVisible(true);
                deleteGameSuccesLbl.setVisible(false);
            }

            //checks that ID is numeric and not empty
        }catch (NumberFormatException nfe){

            deleteGameErrorLbl.setVisible(true);
            deleteGameSuccesLbl.setVisible(false);

        }

    }




}
