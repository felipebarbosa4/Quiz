package algonquin.cst2335.quiz.Activities;
/**
 * This class is used to display the score of the user after the quiz is finished.
 */

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import algonquin.cst2335.quiz.databinding.ActivityScoreBinding;

/**
 * This class is used to display the score of the user after the quiz is finished.
 * @author Felipe Barbosa Figueira
 * @see AppCompatActivity
 */
public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;

    /**
     * This method is used to create the activity and set the score of the user.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hide the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Get the score from the previous activity
        int totalScore = getIntent().getIntExtra("total", 0);
        // Get the correct answers from the previous activity
        int correctAnsw = getIntent().getIntExtra("score", 0);
        // Calculate the wrong answers
        int wrong = totalScore - correctAnsw;

        // Set the score
        binding.totalQuestions.setText(String.valueOf(totalScore));
        // Set the correct answers
        binding.rightAnsw.setText(String.valueOf(correctAnsw));

        binding.wrongAnsw.setText(String.valueOf(wrong));

        /**
         * This method is used to restart the quiz.
         */
        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScoreActivity.this, SetsActivity.class);
                startActivity(intent);
                finish();
            }


        });

        /**
         * This method is used to quit the quiz.
         */
        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }


        });

    }


}