package Logic;

import SDK.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.*;
import javafx.scene.paint.Color;

import javax.swing.*;

import javafx.event.ActionEvent;
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
    public Label joinGameSuccesLbl,joinGameErrorLbl, winnerLbl;
    public TableColumn<Game,String> gameIDCol,hostCol;
    public RadioButton pickBtn;
    public Button joinBtn;


    //delete game components
    @FXML
    public TextField deleteGameIDTxt;
    public Label deleteGameErrorLbl,deleteGameSuccesLbl;
    public TableView<Game> tableDelete;
    public TableColumn<Game,String> colDelID,colDelName,colDelStatus ;
    public TableColumn<Game,Number> colDelHost,colDelOpp,colDelWinner ;
    public RadioButton finishedRadio,openRadio;
    public Button deleteBtn;
    // public TableColumn<Game,Integer> ;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        gameIDCol.setCellValueFactory(new PropertyValueFactory<Game, String>("gameId"));
//        hostCol.setCellValueFactory(new PropertyValueFactory<Game, String>("name"));
//
//        ObservableList<Game> openGames = FXCollections.observableArrayList(logic.openGames());
//        table.setItems(openGames);



    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }


     public void setJoinGameID(ActionEvent e){

             Game game = table.getSelectionModel().getSelectedItem();
             String id = Integer.toString(game.getGameId());
             joinGameID.setText(id);

     }

    public void setDeleteGameID(){

        Game game = tableDelete.getSelectionModel().getSelectedItem();
        String id = Integer.toString(game.getGameId());
        deleteGameIDTxt.setText(id);

    }

    public void populateTable(){

        table.setVisible(true);

        gameIDCol.setCellValueFactory(new PropertyValueFactory<Game, String>("gameId"));
        hostCol.setCellValueFactory(new PropertyValueFactory<Game, String>("name"));



//        YHE FINAL CODE
        ObservableList<Game> openGames = FXCollections.observableArrayList(logic.openGames());
        table.setItems(openGames);


    }

    //TODO make user choose between his own open and finished games.. use actionEvent
    //TODO find out how to display only the relevant variable from an object.. start with TableColumn<Game,Object>
    public void populateDeleteTable(ActionEvent e){

        colDelID.setCellValueFactory(new PropertyValueFactory<Game, String>("gameId"));
        colDelHost.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getHost().getId()));

        colDelName.setCellValueFactory(new PropertyValueFactory<Game, String>("name"));
        colDelStatus.setCellValueFactory(new PropertyValueFactory<Game, String>("status"));


        //gets and sets the table for finished games by currentuser
        if(e.getSource()==finishedRadio) {

            colDelOpp.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getOpponent().getId()));
            colDelWinner.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getWinner().getId()));

            ObservableList<Game> games = FXCollections.observableArrayList(logic.gameByStatus("finished"));
            tableDelete.setItems(games);

            tableDelete.setVisible(true);

        }
        //gets and sets the table for open games by currentuser
        if(e.getSource()==openRadio) {

            int number=0;

            //disse er ikke sat for open games
            colDelOpp.setCellValueFactory(param -> new SimpleIntegerProperty(number));
            colDelWinner.setCellValueFactory(param -> new SimpleIntegerProperty(number));

            ObservableList<Game> games = FXCollections.observableArrayList(logic.gameByStatus("open"));
            tableDelete.setItems(games);

            tableDelete.setVisible(true);

        }


    }

    public void hideTables(){

     table.setVisible(false);

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

    //TODO make user restricted to only setting the gameID from the table
    //TODO make table display when the screen is opened
    public void joinGame(){

        int gameId = Integer.parseInt(joinGameID.getText());
        String controls = joinControlls.getText();

        joinGameSuccesLbl.setVisible(false);
        joinGameErrorLbl.setVisible(false);

        if(logic.joinGame(gameId, controls)){
            joinGameSuccesLbl.setVisible(true);
            joinGameErrorLbl.setVisible(false);

            if(pickBtn.isSelected()){
                populateTable();
            }

           winnerLbl.setText(logic.winner());
           winnerLbl.setVisible(true);

        }else{
            joinGameSuccesLbl.setVisible(false);
            joinGameErrorLbl.setVisible(true);
        }



    }

    public void deleteGame(){

        try {

            int gameID = Integer.parseInt(deleteGameIDTxt.getText());

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
