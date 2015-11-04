package SDK;


import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by alexanderlindkjaer on 02/11/2015.
 */
public class Api {

ServerConnection serverConnection = new ServerConnection();






    public void loginAuth(User user) {

        try {


            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost" + ":" + "9998" + "/api/" + "login");
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, new Gson().toJson(user));

            System.out.println(new Gson().toJson(user));

//            if (response.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + response.getStatus());
//            }

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);


        } catch (Exception e) {

            e.printStackTrace();


        }

    }

}




