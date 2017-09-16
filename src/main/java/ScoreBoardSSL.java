import java.util.Random;

public class ScoreBoardSSL {

    public static void main (String[] args) {

        Random random = new Random();

        // Create 20 scores and store them in an array
        Score unsortedScores[] = new Score[20];
        for (int count = 0; count < 20; count++) {
            unsortedScores[count] = new Score(random.nextInt(100) + 1);
        }
    }
}
