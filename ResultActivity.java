package com.example.quizup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4 ,t5, t6, gameOver;
    Button categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t5);
        gameOver = findViewById(R.id.gameOver);
        categories = findViewById(R.id.categories);

        categories.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });

        Intent intent = getIntent();

        String questions = intent.getStringExtra("total");
        int totalQuestions = Integer.parseInt(questions) - 1;
        String correct = intent.getStringExtra("correct");
        String wrong = intent.getStringExtra("wrong");

        t1.setText(totalQuestions);
        t2.setText(correct);
        t3.setText(wrong);
    }

    public void openMainActivity(){
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
