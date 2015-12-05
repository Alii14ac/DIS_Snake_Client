package SDK;

import java.util.Date;

/**
 * Created by alexanderlindkjaer on 27/10/15.
 */
public class Game {
    private int gameIde
    private int result;
    private int newGame;
    private int endGame;
    private String namee
    private String hostControls;
    private User host;
    private User opponent;
    private String opponentControls;
    private String status;
    private Date created;
    private int mapSize;

    public Game(){}


    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setNewGame(int newGame) {
        this.newGame = newGame;
    }

    public void setEndGame(int endGame) {
        this.endGame = endGame;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHostControls(String hostControls) {
        this.hostControls = hostControls;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setOpponent(User opponent) {
        this.opponent = opponent;
    }

    public void setOpponentControls(String opponentControls) {
        this.opponentControls = opponentControls;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
}
