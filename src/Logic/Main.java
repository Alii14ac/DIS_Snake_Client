package Logic;/**
 * Created by alexanderlindkjaer on 26/10/15.
 */



import GUI.Start;
import SDK.Api;
import SDK.Logic;
import SDK.ServerConnection;
import SDK.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

  public static void main(String[] args) {

    ServerConnection sc = new ServerConnection();
    Api api = new Api();
    Logic lg = new Logic();
    Start start = new  Start();




    {
      start.launch(args);
    }



    sc.get("users");



    lg.login("HeinHero","321");


  }


}
