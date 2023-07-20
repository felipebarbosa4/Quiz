package algonquin.cst2335.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

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


        SetAdapter adapter = new SetAdapter(this,list);
        binding.setsRecy.setAdapter(adapter);
    }
}