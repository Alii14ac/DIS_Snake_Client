package SDK;

/**
 * Created by alexanderlindkjaer on 02/12/2015.
 */
public class UserStats extends User {


    private int score;
    private int totalScore;
    private boolean winner;
    private int kills;
    private String controls;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isWinner() {
        return winner;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public String getControls(){
        return controls;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }
}
