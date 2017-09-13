public class Score {

    private int score;
    private String player;

    public Score(int score, String player) {
        this.score = score;
        this.player = player;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public String getPlayer() {
        return player;
    }

    public int compareTo(Score s) {
        if (score > s.getScore())
            return 1;
        else if (score == s.getScore())
            return 0;
        else
            return -1;
    }
}
