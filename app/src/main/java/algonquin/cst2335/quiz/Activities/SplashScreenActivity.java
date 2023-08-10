package algonquin.cst2335.quiz.Activities;

/**
 * SplashScreenActivity.java
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import algonquin.cst2335.quiz.MainActivity;
import algonquin.cst2335.quiz.R;

/**
 * This activity is the first activity that the user sees when they open the app.
 * It asks the user to enter a username and then stores that username in SharedPreferences.
 * The username is then displayed in the next activity (MainActivity).
 * If the user has already logged in before, the last username is displayed in the TextView.
 * If the user has not logged in before, the TextView is empty.
 * The user cannot continue to the next activity (MainActivity) unless they enter a username.
 * @author Felipe Barbosa Figueira
 *
 * @see AppCompatActivity
 *
 *
 */
public class SplashScreenActivity extends AppCompatActivity {

    private EditText userNameEditText;

    /**
     * This method is called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        userNameEditText = findViewById(R.id.usernameEditText);
        Button continueButton = findViewById(R.id.startButton);
        TextView lastLoginTextView = findViewById(R.id.lastLoginTextView);

        // Get the last login username from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String lastLoginUsername = preferences.getString("userName", "");
        lastLoginTextView.setText("Last login was as: " + lastLoginUsername);

        /**
         * This method is called when the user clicks the "Continue" button.
         * It gets the username from the EditText and stores it in SharedPreferences.
         * It then starts the next activity (MainActivity).
         * @param v The view that was clicked.
         */
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString().trim();

                if (!userName.isEmpty()) {
                    // Store the user name in SharedPreferences
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("userName", userName);
                    editor.apply();

                    // Start the next activity (MainActivity)
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close this activity so the user cannot go back to it
                } else {
                    Toast.makeText(SplashScreenActivity.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
