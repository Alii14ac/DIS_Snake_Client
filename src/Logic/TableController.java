package Logic;

import SDK.Game;
import SDK.Loogic;
import SDK.Score;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by alexanderlindkjaer on 01/12/2015.
 */
public class TableController implements Initializable, GUI.ControlledScreen {
    ScreensController myController;
    Loogic logic = new Loogic();
    Main main = new Main();


    @FXML
    public TableView<Score> topScoreTable;
    public TableColumn<Score,String>  colTopUsername,colTopGameName;
    public TableColumn<Score,Number> colTopID,colTopScore;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        populateTopTable();

    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    public void menu(){
        myController.setScreen(Main.screenMenuID);
    }

    public void populateTopTable(){
        topScoreTable.setVisible(true);

        colTopID.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getGame().getGameId()));
        colTopScore.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getScore()));
        colTopUsername.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGame().getWinner().getUsername()));
        colTopGameName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGame().getName()));

        ObservableList<Score> topScores = FXCollections.observableArrayList(logic.getTopHighScores());
        topScoreTable.setItems(topScores);


    }

    public void populateTopTableByUser(){
        topScoreTable.setVisible(true);

        colTopID.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getGame().getGameId()));
        colTopScore.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().getScore()));
        colTopUsername.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGame().getWinner().getUsername()));
        colTopGameName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGame().getName()));


        ObservableList<Score> topScoresByUser = FXCollections.observableArrayList(logic.getTopHighScoresByUserID());
        topScoreTable.setItems(topScoresByUser);


    }




}
