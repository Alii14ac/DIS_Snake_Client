package Logic;/**
 * Created by alexanderlindkjaer on 26/10/15.
 */



import SDK.ServerConnection;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HelloWorldClient {

  public static void main(String[] args) {

    ServerConnection sc = new ServerConnection();





      sc.get("user");





  }
}
