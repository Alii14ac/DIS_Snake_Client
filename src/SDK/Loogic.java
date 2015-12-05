package SDK;

import Logic.GameController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexanderlindkjaer on 27/10/15.
 */
public class Loogic {


    private static User currentUser;
//    User currentUser = new User();
    ServerConnection serverConnection = new ServerConnection();



    public Loogic(){

        currentUser = new User();
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

                for (User user : SDK.Loogic.setUser() )
                {
                    if (user.getUsername().equals(username))
                    {
                       currentUser = user;

                    }
                }



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

    public static ArrayList<User> setUser(){
        ServerConnection serverConnection = new ServerConnection();

        String Data = serverConnection.get("users/");

        ArrayList<User> users = new Gson().fromJson(Data, new TypeToken<ArrayList<User>>(){}.getType());

        return users;

    }



    public ArrayList<Game> openGames(){

        ServerConnection serverConnection = new ServerConnection();

        String Data = serverConnection.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(Data, new TypeToken<ArrayList<Game>>(){}.getType());

        for(Game game : openGames){

            System.out.printf(game.getName());
        }

        return openGames;

    }

    public static void deleteUser(int userId){

    }
    public static void getUser(int userId){

    }
    public static void getGame(int gameId){

    }
    public boolean joinGame(int gameId, String controls){

        ServerConnection serverConnection = new ServerConnection();

        UserStats opponent = new UserStats();
        Game game = new Game();

        opponent.setId(currentUser.getId());
        opponent.setControls(controls);

        game.setOpponent(opponent);
        game.setGameId(gameId);

        String json = new Gson().toJson(game);

        //serverConnection.post(json, "create");

        String message = serverConnection.stringMessageParser(serverConnection.put(json, "games/join/"));
        System.out.println(message);



        if (message.equals("Game was joined")) {

            startGame(game);
            return true;
        }

        return false;


    }


    public boolean startGame(Game game){

//        Game game = new Game();
//
//        game.setGameId(gameID);

        String json = new Gson().toJson(game);

        //serverConnection.post(json, "create");

        String message = serverConnection.stringMessageParser(serverConnection.put(json, "games/start/"));
        System.out.println(message);



        if (message.equals("game started")) {

            return true;
        }

        return false;

    }
    public boolean createGame(String gameName, String hostControlls){
        //host, opponent, status, name, host_controls, map_size


        ServerConnection serverConnection = new ServerConnection();

        UserStats host = new UserStats();
        host.setId(currentUser.getId());
        host.setControls(hostControlls);

        Game game = new Game();
        game.setName(gameName);
        game.setHost(host);
        game.setMapSize(20);
        //TODO opponent bliver sat til 0 istedet for NULL,, find ud af om det gør noget,, ellers lav det om i koden eller databasen
        game.setOpponent(null);



        String json = new Gson().toJson(game);

        //serverConnection.post(json, "create");

        String message = serverConnection.stringMessageParser(serverConnection.post(json, "games/"));
        System.out.println(message);



        if (message.equals("game was created")) {

            return true;
        } else if (message.equals("something went wrong")) {

            return false;
        }

        return false;

    }
    public static void deleteGame(int gameId){



    }

}
