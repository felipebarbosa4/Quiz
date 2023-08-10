package algonquin.cst2335.quiz.Activities;

/**
 * This class is used to store the top 10 scores of the quiz game.
 * It has two attributes: userName and score.
 * userName is the name of the user who played the game.
 * score is the score of the user.
 *
 * @author  Felipe Barbosa Figueira
 */
public class Top10Activity {

    private String userName;
    private long score;

    public Top10Activity() {

    }

    public Top10Activity(String userName, long score) {
        this.userName = userName;
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

}
