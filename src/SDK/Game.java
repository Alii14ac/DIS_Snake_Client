package SDK;

import java.util.Date;

/**
 * Created by alexanderlindkjaer on 27/10/15.
 */
public class Game {
    private int gameId;
    private UserStats winner;
    private int newGame;
    private int endGame;
    private String name;
    private String hostControls;
    private UserStats host;
    private UserStats opponent;
    private String opponentControls;
    private String status;
   // private Date created;
    private int mapSize;

    public Game(){}


    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setResult(UserStats winner) {
        this.winner = winner;
    }

    public User getWinner() {
        return winner;
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

    public String getName() {
        return name;
    }

    public void setHostControls(String hostControls) {
        this.hostControls = hostControls;
    }

    public String getHostControls() {
        return hostControls;
    }

    public void setHost(UserStats host) {
        this.host = host;
    }

    public UserStats getHost() {
        return host;
    }

    public void setOpponent(UserStats opponent) {
        this.opponent = opponent;
    }

    public UserStats getOpponent() {
        return opponent;
    }

    public String getOpponentControls() {
        return opponentControls;
    }

    public void setOpponentControls(String opponentControls) {
        this.opponentControls = opponentControls;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    //    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public Date getCreated() {
//        return created;
//    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
}
