package Logic;/**
 * Created by alexanderlindkjaer on 26/10/15.
 */



import SDK.Api;
import SDK.Logic;
import SDK.ServerConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
        primaryStage.setTitle("Snake");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


    }

  public static void main(String[] args) {

//    ServerConnection sc = new ServerConnection();
//    Api api = new Api();
//    Logic lg = new Logic();


      launch(args);




    //sc.get("users");



    //lg.login("HeinHero","321");


  }


}
