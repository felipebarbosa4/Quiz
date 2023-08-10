package algonquin.cst2335.quiz.Models;

/**
 * This class is used to store the question and its options and correct answer
 * It is used to store the data in the database
 * It is used to retrieve the data from the database
 * It is used to display the data in the recycler view
 * It is used to display the data in the quiz activity
 * It is used to display the data in the quiz result activity
 * @author Felipe Barbosa Figueira
 */
public class QuestionModel {

    private String question,optionA,optionB,optionC,optionD,correctAnswer;


    /**
     * This constructor is used to create the question model object
     * @param question the question
     * @param optionA the option A
     * @param optionB the option B
     * @param optionC the option C
     * @param optionD the option D
     * @param correctAnswer the correct answer
     */

    public QuestionModel(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public QuestionModel() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
