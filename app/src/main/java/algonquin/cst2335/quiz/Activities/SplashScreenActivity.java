package algonquin.cst2335.quiz.Activities;

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

public class SplashScreenActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private TextView lastLoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        userNameEditText = findViewById(R.id.usernameEditText);
        Button continueButton = findViewById(R.id.startButton);
        lastLoginTextView = findViewById(R.id.lastLoginTextView);

        // Get the last login username from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String lastLoginUsername = preferences.getString("userName", "");
        lastLoginTextView.setText("Last login was as: " + lastLoginUsername);

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
