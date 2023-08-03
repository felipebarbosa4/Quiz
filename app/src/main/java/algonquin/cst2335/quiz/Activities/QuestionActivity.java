package algonquin.cst2335.quiz.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import algonquin.cst2335.quiz.Models.QuestionModel;
import algonquin.cst2335.quiz.R;
import algonquin.cst2335.quiz.databinding.ActivityQuestionBinding;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<QuestionModel> list = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int score = 0;
    CountDownTimer timer;
    ActivityQuestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        resetTimer();

        timer.start();

        String setName = getIntent().getStringExtra("set");

        if (setName.equals("SET-1")) {

            setOne();

        } else if (setName.equals("SET-2")) {

            setTwo();
        }

        for (int i = 0; i < 4; i++) {

            binding.optionContainer.getChildAt(i).setOnClickListener(view ->

                    checkAnswer((Button) view));

        }

        playAnimation(binding.question,0,list.get(position).getQuestion());

        binding.btnNext.setOnClickListener(view -> {

            if (timer !=null) {

                timer.cancel();

            }

            timer.start();
            binding.btnNext.setEnabled(false);
            binding.btnNext.setAlpha((float) 0.3);
            enableOption(true);
            position++;

            if (position == list.size()) {

                Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                intent.putExtra("score",score);
                intent.putExtra("total",list.size());
                startActivity(intent);
                finish();
                return;

            }

            count = 0;

            playAnimation(binding.question,0,list.get(position).getQuestion());

        });


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
    }

    private void resetTimer() {

        timer = new CountDownTimer(30500,1000) {
            @Override
            public void onTick(long l) {

                binding.timer.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {

                Dialog dialog = new Dialog(QuestionActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.timeout_dialog);
                dialog.findViewById(R.id.tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick( View view) {

                        Intent intent = new Intent(QuestionActivity.this,SetsActivity.class);
                        startActivity(intent);
                        finish();


                    }


                });

                dialog.show();

            }
        };
    }

    private void playAnimation(View view, int value, String data) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {




                        if (value == 0 && count <4) {

                            String option = "";

                            if (count == 0) {
                                option = list.get(position).getOptionA();
                            } else if (count == 1) {
                                option = list.get(position).getOptionB();
                            } else if (count == 2) {
                                option = list.get(position).getOptionC();
                            } else if (count == 3) {
                                option = list.get(position).getOptionD();
                            }

                            playAnimation(binding.optionContainer.getChildAt(count),0,option);
                            count ++;

                        }
                    }


                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {

                        if (value == 0){


                            try {

                                ((TextView)view).setText(data);
                                binding.totalQuestion.setText(position+1+"/"+list.size());
                            } catch (Exception e) {

                                ((Button)view).setText(data);
                            }

                            view.setTag(data);
                            playAnimation(view,1,data);

                        }

                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });

    }

    private void enableOption(boolean enable) {

        for (int i = 0; i < 4; i++) {

            binding.optionContainer.getChildAt(i).setEnabled(enable);

            if (enable) {
                binding.optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt);

            }
        }

    }

    private void checkAnswer(Button selectedOption) {

        if (timer !=null) {

            timer.cancel();
        }

        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        if (selectedOption.getText().toString().equals(list.get(position).getCorrectAnswer())) {

            score++;
            selectedOption.setBackgroundResource(R.drawable.right_answ);
        } else {

            selectedOption.setBackgroundResource(R.drawable.wrong_answ);

            Button correctOption = (Button) binding.optionContainer.findViewWithTag(list.get(position).getCorrectAnswer());

            correctOption.setBackgroundResource(R.drawable.right_answ);
        }
    }


    private void setTwo() {

        list.add(new QuestionModel("What year Brazil was Discovered? "
                , "1400", "1500", "1598", "1600", "1500"));

        list.add(new QuestionModel("How Many heritage properties are listed in the World " +
                "heritage List?", "25", "30", "26", "80", "25"));


        list.add(new QuestionModel("How Many heritage properties are listed in the World " +
                "heritage List?", "25", "30", "26", "80", "25"));

        list.add(new QuestionModel("What year Brazil was Discovered? "
                , "1400", "1500", "1598", "1600", "1500"));
    }

    private void setOne() {

        list.add(new QuestionModel("How Many heritage properties are listed in the World " +
                "heritage List?", "25", "30", "26", "80", "25"));

        list.add(new QuestionModel("What year Brazil was Discovered? "
                , "1400", "1500", "1598", "1600", "1500"));

        list.add(new QuestionModel("How Many heritage properties are listed in the World " +
                "heritage List?", "25", "30", "26", "80", "25"));

        list.add(new QuestionModel("What year Brazil was Discovered? "
                , "1400", "1500", "1598", "1600", "1500"));

    }


}
