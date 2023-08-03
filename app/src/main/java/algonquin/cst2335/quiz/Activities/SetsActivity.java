package algonquin.cst2335.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;

import algonquin.cst2335.quiz.Adapters.SetAdapter;
import algonquin.cst2335.quiz.Models.SetModel;
import algonquin.cst2335.quiz.R;
import algonquin.cst2335.quiz.databinding.ActivitySetsBinding;

public class SetsActivity extends AppCompatActivity {

    ActivitySetsBinding binding;
    ArrayList<SetModel>list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int categoryID = getIntent().getIntExtra("CATEGORY_ID", 0);

        binding = ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Snackbar.make(binding.getRoot(), "CLEVER CHOICE", Snackbar.LENGTH_SHORT).show();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.setsRecy.setLayoutManager(linearLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter the number of questions");

        final NumberPicker numberPicker = new NumberPicker(this);
        numberPicker.setMaxValue(50);
        numberPicker.setMinValue(1);

        builder.setView(numberPicker);
        builder.setPositiveButton("OK", (dialog, which) -> {
            int numQuestions = numberPicker.getValue();

            String url = "https://opentdb.com/api.php?amount=" + numQuestions + "&category=" + categoryID + "&type=multiple";

            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
                // Here, "response" is the JSON string.
                Gson gson = new Gson();

                // You'd need to define your QuizResponse class based on the JSON structure.
                QuestionActivity quizResponse = gson.fromJson(response, QuestionActivity.class);

                // Do something with quizResponse here.
                // For example, you could populate "list" and update your adapter.
                list.clear();
//                list.addAll(quizResponse.getResults());
                SetAdapter adapter = new SetAdapter(this, list);
                binding.setsRecy.setAdapter(adapter);

            }, error -> {
                // Error handling here.
                Log.e("Network error", error.toString());
            });

            queue.add(stringRequest);
        });

        builder.show();

    }
}
