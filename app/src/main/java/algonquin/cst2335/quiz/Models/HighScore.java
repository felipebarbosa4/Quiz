//package algonquin.cst2335.quiz.Models;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//import algonquin.cst2335.quiz.R;
//
//public class HighScore extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private HighScoreAdapter adapter;
//    private ArrayList<HighScore> highScoresList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_high_scores);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        highScoresList = fetchHighScores(); // Fetch top 10 high scores from data source
//        adapter = new HighScoreAdapter(this, highScoresList);
//        recyclerView.setAdapter(adapter);
//    }
//
//    // Implement fetchHighScores method to retrieve high scores
//    private ArrayList<HighScore> fetchHighScores() {
//        // Fetch high scores from data source (e.g., SharedPreferences or database)
//        // Return a list of HighScore objects
//    }
//}
