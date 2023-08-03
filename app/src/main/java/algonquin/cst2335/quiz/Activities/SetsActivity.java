package algonquin.cst2335.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.NumberPicker;

import com.google.android.material.snackbar.Snackbar;

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

        int categoryID = getIntent().getIntExtra("CATEGORY_ID", 0); // Use a default value that makes sense for your app.

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


            SetAdapter adapter = new SetAdapter(this, list);
            binding.setsRecy.setAdapter(adapter);
        });

        builder.show();

    }
}
