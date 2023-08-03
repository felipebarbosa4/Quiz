package algonquin.cst2335.quiz.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionModel {

    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public QuestionModel(String question, String correctAnswer, List<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public QuestionModel() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public List<String> getAllOptions() {
        List<String> options = new ArrayList<>(incorrectAnswers);
        options.add(correctAnswer);
        Collections.shuffle(options);  // This line shuffles the options.
        return options;
    }
}


