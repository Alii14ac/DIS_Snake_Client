package Logic;/**
 * Created by alexanderlindkjaer on 26/10/15.
 */



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

        mainContainer.setScreen(Main.screenLoginID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root,725,516);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

  public static void main(String[] args) {

//    ServerConnection sc = new ServerConnection();
//    Api api = new Api();
//    Loogic lg = new Loogic();


      launch(args);

  }


}
