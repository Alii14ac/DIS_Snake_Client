package Logic;/**
 * Created by alexanderlindkjaer on 26/10/15.
 */



import SDK.Api;
import SDK.Loogic;
import SDK.ServerConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static String screenLoginID = "login";
    public static String screenLoginFile = "/GUI/login.fxml";
    public static String screenCreateUserID = "createUser";
    public static String screenCreateUserFile = "/GUI/createUser.fxml";
    public static String screenMenuID = "menu";
    public static String screenMenuFile = "/GUI/menu.fxml";
    public static String screenCreateGameFile = "/GUI/CreateGame2.fxml";
    public static String screenCreateGameID = "createGame";
    public static String screenDeleteGameID = "deleteGame";
    public static String screenDeleteGameFile = "/GUI/DeleteGame.fxml";
    public static String screenHighscoresFile = "/GUI/Highscores.fxml";
    public static String screenHighscoresID = "highscores";
    public static String screenJoinGameFile = "/GUI/JoinGame.fxml";
    public static String screenJoinGameID = "joinGame";
    public static String screenSnakeGameFile = "/GUI/SnakeGame.fxml";
    public static String screenSnakeGameID = "snakeGame";


    @Override
    public void start(Stage primaryStage) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
//        primaryStage.setTitle("Snake");
//        primaryStage.setScene(new Scene(root, 725, 516));
//        primaryStage.setResizable(false);
//        primaryStage.show();

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Main.screenLoginID, Main.screenLoginFile);
        mainContainer.loadScreen(Main.screenCreateUserID, Main.screenCreateUserFile);
        mainContainer.loadScreen(Main.screenMenuID, Main.screenMenuFile);
        mainContainer.loadScreen(Main.screenCreateGameID, Main.screenCreateGameFile);
        mainContainer.loadScreen(Main.screenDeleteGameID, Main.screenDeleteGameFile);
        mainContainer.loadScreen(Main.screenHighscoresID, Main.screenHighscoresFile);
        mainContainer.loadScreen(Main.screenJoinGameID, Main.screenJoinGameFile);
        mainContainer.loadScreen(Main.screenSnakeGameID, Main.screenSnakeGameFile);



        mainContainer.setScreen(Main.screenLoginID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root,725,516);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

  public static void main(String[] args) {

    ServerConnection sc = new ServerConnection();
    Api api = new Api();
    Loogic lg = new Loogic();



      launch(args);


  }


}
