package algonquin.cst2335.quiz.Activities;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuizAPIHandler {

    public interface QuizAPIListener {
        void onSuccess(String response);
        void onError(String errorMessage);
    }

    public void fetchQuizQuestions(String category, int amount, QuizAPIListener listener) {
        String apiUrl = "https://opentdb.com/api.php?amount=" + amount + "&category=" + category + "&type=multiple";

        new FetchQuizQuestionsTask(listener).execute(apiUrl);
    }

    private static class FetchQuizQuestionsTask extends AsyncTask<String, Void, String> {
        private QuizAPIListener listener;

        public FetchQuizQuestionsTask(QuizAPIListener listener) {
            this.listener = listener;
        }

        @Override
        protected String doInBackground(String... urls) {
            String apiUrl = urls[0];
            StringBuilder response = new StringBuilder();

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                } else {
                    // Handle the error case
                    return null;
                }

                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            return response.toString();
        }

        @Override
        protected void onPostExecute(String response) {
            if (response != null) {
                listener.onSuccess(response);
            } else {
                listener.onError("Failed to fetch quiz questions");
            }
        }
    }
}
