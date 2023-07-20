package algonquin.cst2335.quiz.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import algonquin.cst2335.quiz.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
        builder.setTitle("FUN ALERT")
                .setMessage("CHATGPT IS NOT ALLOWED")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle positive button click
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle negative button click
                    }
                })
                .show();
        setContentView(R.layout.activity_question);
    }
}