package algonquin.cst2335.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.quiz.Activities.SetsActivity;
import algonquin.cst2335.quiz.Models.SetModel;

public class MainActivity extends AppCompatActivity {

    CardView history, science, math, programming;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userNameTextView = findViewById(R.id.textViewUserName);

        // Retrieve the user name from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userName = preferences.getString("userName", "");

        // Update the UI to display the user name
        userNameTextView.setText("Welcome, " + userName);


        // assignment request
        Toast.makeText(MainActivity.this, "WELCOME TO THE ALPHA TEST", Toast.LENGTH_SHORT).show();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        history = findViewById(R.id.history);
        science = findViewById(R.id.science);
        math = findViewById(R.id.math);
        programming = findViewById(R.id.programming);

        SetModel category = new SetModel("",0);

        history.setOnClickListener(view -> {
            category.setCategoryId(23);
            Intent intent = new Intent(MainActivity.this, SetsActivity.class);
            intent.putExtra("CATEGORY_ID", category.getCategoryId());  // Pass the category ID as an extra
            startActivity(intent);
        });

        programming.setOnClickListener(view -> {
            category.setCategoryId(18);
            Intent intent = new Intent(MainActivity.this, SetsActivity.class);
            intent.putExtra("CATEGORY_ID", category.getCategoryId());
            startActivity(intent);
        });

        science.setOnClickListener(view -> {
            category.setCategoryId(17);
            Intent intent = new Intent(MainActivity.this, SetsActivity.class);
            intent.putExtra("CATEGORY_ID", category.getCategoryId());
            startActivity(intent);
        });

        math.setOnClickListener(view -> {
            category.setCategoryId(19);
            Intent intent = new Intent(MainActivity.this, SetsActivity.class);
            intent.putExtra("CATEGORY_ID", category.getCategoryId());
            startActivity(intent);
        });

    }
}