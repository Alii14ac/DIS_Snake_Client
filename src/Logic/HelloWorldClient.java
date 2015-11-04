package Logic;/**
 * Created by alexanderlindkjaer on 26/10/15.
 */



import SDK.Api;
import SDK.Logic;
import SDK.ServerConnection;
import SDK.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HelloWorldClient {

  public static void main(String[] args) {

    ServerConnection sc = new ServerConnection();
    Api api = new Api();
    Logic lg = new Logic();




//    User currentUser;
//
//    String password ="321";
//    String username ="HeinHero";
//
//    currentUser = new User(username,password);
//





//      sc.get("users");

//      api.loginAuth(currentUser);

    lg.login("HeinHero","321");


  }
}
