package SDK;

import com.google.gson.Gson;

/**
 * Created by alexanderlindkjaer on 27/10/15.
 */
public class Loogic {



    ServerConnection serverConnection = new ServerConnection();


    public static void login(String username, String password){

        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

        serverConnection.post(json, "login/");




    }

    public boolean userAuth(String username,String password){


    ServerConnection serverConnection = new ServerConnection();
    User usr = new User();

    usr.setUsername(username);
    usr.setPassword(password);

        String json = new Gson().toJson(usr);

            String message = serverConnection.stringMessageParser(serverConnection.post(json, "login/"));
            System.out.println(message);

            if (message.equals("Login successful")) {

                return true;
            } else if (message.equals("Wrong username or password") || message.equals("Error in JSON")) {

                return false;
            }
        return false;


    }




    public boolean createUser(String firstName, String lastName, String userName, String password, String email ){



        ServerConnection serverConnection = new ServerConnection();
        User usr = new User();

        usr.setFirstName(firstName);
        usr.setLastName(lastName);
        usr.setUsername(userName);
        usr.setPassword(password);
        usr.setEmail(email);
        usr.setType("1");

        String json = new Gson().toJson(usr);

        String message = serverConnection.stringMessageParser(serverConnection.post(json, "users/"));
        System.out.println(message);

        if (message.equals("User was created")) {

            return true;
        } else if (message.equals("Failed. User was not created")) {

            return false;
        }
        return false;


    }
    public static void deleteUser(int userId){

    }
    public static void getUser(int userId){

    }
    public static void getGame(int gameId){

    }
    public static void joinGame(int gameId, User opponent, String controls){

    }
    public static void startGame(int gameId){

    }
    public static void createGame(String name, int status){

        ServerConnection serverConnection = new ServerConnection();

        Game game = new Game();
        game.setName(name);
        //game.setHost();
        game.setStatus(status);

        String json = new Gson().toJson(game);

        serverConnection.post(json, "create");

    }
    public static void deleteGame(int gameId){



    }

}
