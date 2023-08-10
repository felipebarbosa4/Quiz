package algonquin.cst2335.quiz.Activities;
/**
 * This activity is used to display the sets of questions for the selected category.
 */

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import algonquin.cst2335.quiz.Adapters.SetAdapter;
import algonquin.cst2335.quiz.Models.SetModel;
import algonquin.cst2335.quiz.R;
import algonquin.cst2335.quiz.databinding.ActivitySetsBinding;

/**
 * This activity is used to display the sets of questions for the selected category.
 * @author Felipe Barbosa Figueira
 * @see algonquin.cst2335.quiz.Adapters.SetAdapter
 * @see algonquin.cst2335.quiz.Models.SetModel
 */
public class SetsActivity extends AppCompatActivity {

    //private static final String TAG = "SetsActivity";
    ActivitySetsBinding binding;
    ArrayList<SetModel> list;

    /**
     * This method is used to create the activity and set up the recycler view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int categoryID = getIntent().getIntExtra("CATEGORY_ID", 0);

        binding = ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String category = getIntent().getStringExtra("category");
        binding.categorySet.setText(category);

        Snackbar.make(binding.getRoot(), "CLEVER CHOICE", Snackbar.LENGTH_SHORT).show();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.imageView);

        /**
         * This method is used to return to the previous activity.
         */
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This will close the current activity and return to the previous one
            }
        });

        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.setsRecy.setLayoutManager(linearLayoutManager);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userName = preferences.getString("userName", "");
        int lastNumQuestions = preferences.getInt(userName + "_numQuestions", -1);
        //Log.d(TAG, "onCreate: lastNumQuestions: " + lastNumQuestions);
        if (lastNumQuestions != -1) {
            new AlertDialog.Builder(this)
                    .setTitle("Previous Choice Found")
                    .setMessage("You chose " + lastNumQuestions + " questions last time. Would you like to keep this choice?")
                    .setPositiveButton("Yes", (dialog, which) -> setUpQuiz(categoryID, lastNumQuestions))
                    .setNegativeButton("No", (dialog, which) -> showNumberPicker(categoryID))
                    .show();
        } else {
            showNumberPicker(categoryID);
        }
    }

    /**
     * This method is used to show the number picker dialog.
     * @param categoryID
     */

    private void showNumberPicker(int categoryID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter the number of questions");

        final NumberPicker numberPicker = new NumberPicker(this);
        numberPicker.setMaxValue(50);
        numberPicker.setMinValue(1);


        builder.setView(numberPicker);
        builder.setPositiveButton("OK", (dialog, which) -> {
            int numQuestions = numberPicker.getValue();


            // Save the number of questions with a key unique to the user
            SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            String userName = preferences.getString("userName", "");
            editor.putInt(userName + "_numQuestions", numQuestions);
            editor.apply();

            setUpQuiz(categoryID, numQuestions);


        });

        builder.show();
    }

    /**
     * This method is used to set up the quiz.
     * @param categoryID The category ID
     * @param numQuestions The number of questions
     */
    private void setUpQuiz(int categoryID, int numQuestions) {
        String url = "https://opentdb.com/api.php?amount=" + numQuestions + "&category=" + categoryID + "&type=multiple";
        SetAdapter adapter = new SetAdapter(this, list);
        binding.setsRecy.setAdapter(adapter);

        list.add(new SetModel("SET-1"));
        list.add(new SetModel("SET-2"));
        list.add(new SetModel("SET-3"));
        list.add(new SetModel("SET-4"));
        list.add(new SetModel("SET-5"));
        list.add(new SetModel("SET-6"));
        list.add(new SetModel("SET-7"));
        list.add(new SetModel("SET-8"));
        list.add(new SetModel("SET-9"));
        list.add(new SetModel("SET-10"));

        TextView totalQuestionsTextView = findViewById(R.id.textView9);
        totalQuestionsTextView.setText(String.valueOf(numQuestions));
    }
}