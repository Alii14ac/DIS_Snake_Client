package SDK;

import java.util.Date;

/**
 * Created by alexanderlindkjaer on 27/10/15.
 */
public class Game {
    private int gameId;
    private User winner;
    private int newGame;
    private int endGame;
    private String name;
    private String hostControls;
    private User host;
    private User opponent;
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

    public void setResult(User winner) {
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

    public void setHost(User host) {
        this.host = host;
    }

    public User getHost() {
        return host;
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
