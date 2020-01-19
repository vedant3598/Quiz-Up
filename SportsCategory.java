package com.example.quizup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizup.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SportsCategory extends AppCompatActivity {

    Button o1, o2, o3, o4;
    TextView t1_score, t2_questionNumber, t3_question, t4_timer;
    int total = 0;
    int correct = 0;
    int wrong = 0;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_category);

        o1 = findViewById(R.id.option1);
        o2 = findViewById(R.id.option2);
        o3 = findViewById(R.id.option3);
        o4 = findViewById(R.id.option4);

        t1_score = findViewById(R.id.score);
        t2_questionNumber = findViewById(R.id.questionNumber);
        t3_question = findViewById(R.id.questionsText);
        t4_timer = findViewById(R.id.timer);

        updateQuestion();
        timer(30, t4_timer);
    }

    public void updateQuestion(){
        total++;
        if(total > 2){
            Intent intent = new Intent(SportsCategory.this, ResultActivity.class);
            intent.putExtra("total", String.valueOf(total));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("wrong", String.valueOf(wrong));
            startActivity(intent);
        }
        else{
            reference = FirebaseDatabase.getInstance().getReference().child("Sports").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    t3_question.setText(question.getAnswer());
                    o1.setText(question.getOption1());
                    o2.setText(question.getOption2());
                    o3.setText(question.getOption3());
                    o4.setText(question.getOption4());

                    o1.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            if(o1.getText().toString().equals(question.getAnswer())){
                                o1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updatePoints();
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                o1.setBackgroundColor(Color.RED);

                                if (o2.getText().toString().equals(question.getAnswer())) {
                                    o2.setBackgroundColor(Color.GREEN);
                                } else if (o3.getText().toString().equals(question.getAnswer())) {
                                    o3.setBackgroundColor(Color.GREEN);
                                } else if (o4.getText().toString().equals(question.getAnswer())) {
                                    o4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            updateQuestionNum();
                        }
                    });

                    o2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            if(o2.getText().toString().equals(question.getAnswer())){
                                o2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updatePoints();
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                o2.setBackgroundColor(Color.RED);

                                if (o1.getText().toString().equals(question.getAnswer())) {
                                    o1.setBackgroundColor(Color.GREEN);
                                } else if (o3.getText().toString().equals(question.getAnswer())) {
                                    o3.setBackgroundColor(Color.GREEN);
                                } else if (o4.getText().toString().equals(question.getAnswer())) {
                                    o4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            updateQuestionNum();
                        }
                    });

                    o3.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            if(o3.getText().toString().equals(question.getAnswer())){
                                o3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updatePoints();
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                o3.setBackgroundColor(Color.RED);

                                if (o1.getText().toString().equals(question.getAnswer())) {
                                    o1.setBackgroundColor(Color.GREEN);
                                } else if (o2.getText().toString().equals(question.getAnswer())) {
                                    o2.setBackgroundColor(Color.GREEN);
                                } else if (o4.getText().toString().equals(question.getAnswer())) {
                                    o4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            updateQuestionNum();
                        }
                    });

                    o4.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            if(o4.getText().toString().equals(question.getAnswer())){
                                o4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updatePoints();
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                o4.setBackgroundColor(Color.RED);

                                if (o2.getText().toString().equals(question.getAnswer())) {
                                    o2.setBackgroundColor(Color.GREEN);
                                } else if (o3.getText().toString().equals(question.getAnswer())) {
                                    o3.setBackgroundColor(Color.GREEN);
                                } else if (o1.getText().toString().equals(question.getAnswer())) {
                                    o1.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            updateQuestionNum();
                        }
                    });




                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }

    public void timer(int seconds, final TextView tv){
        new CountDownTimer(seconds * 1000 + 1000, 1000){
            public void onTick(long millisUntilFinished){
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }
            public void onFinish(){
                tv.setText("Completed");
                Intent intent = new Intent(SportsCategory.this, ResultActivity.class);
                intent.putExtra("total", String.valueOf(total));
                intent.putExtra("correct", String.valueOf(correct));
                intent.putExtra("wrong", String.valueOf(wrong));
                startActivity(intent);
            }
        }.start();

    }

    private void updatePoints(){
        t1_score.setText("Score: " + correct);
    }

    private void updateQuestionNum(){
        t2_questionNumber.setText("Question: " + total);
    }
}
