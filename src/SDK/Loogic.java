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
       // Logic.LoginController lgCon = new Logic.LoginController();

    ServerConnection serverConnection = new ServerConnection();
    User usr = new User();

//    String username = lgCon.usernameText.getText();
//    String password = lgCon.passwordText.getText();

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



//    public boolean userAuth()
//    {
//
//
//        String username = screen.getWelcome().getUsername();
//        String password = screen.getWelcome().getPassword();
//
//        ServerConnection serverConnection = new ServerConnection();
//        if (!username.equals("") && !password.equals("")) {
//
//            User user = new User();
//            user.setPassword(password);
//            user.setUsername(username);
//
//            String json = new Gson().toJson(user);
//
//            String message = serverConnection.stringMessageParser(serverConnection.post(json, "login/"));
//            System.out.println(message);
//
//            if (message.equals("Login successful")) {
//                screen.getWelcome().getLblAccessDenied().setVisible(false);
//                return true;
//            } else if (message.equals("Wrong username or password") || message.equals("Error in JSON")) {
//
//                screen.getWelcome().getLblAccessDenied().setVisible(true);
//            }
//        }
//
//        return false;
//    }
    public static void createUser(User user){

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
