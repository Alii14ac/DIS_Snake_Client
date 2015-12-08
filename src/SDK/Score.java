package SDK;

/**
 * Created by alexanderlindkjaer on 07/12/2015.
 */
public class Score {

    // Declare highScore
    private int id;
    private UserStats user;
    private UserStats opponent;
    private Game game;
    private int score;



    public Score(){}

    // Creates get method which returns the highScore

    public UserStats getOpponent() { return opponent; }

    public void setOpponent(UserStats opponent) { this.opponent = opponent;  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserStats getUser() {
        return user;
    }

    public void setUser(UserStats user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
