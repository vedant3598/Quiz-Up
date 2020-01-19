package com.example.quizup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1_title;
    Button buttonAnimals, buttonGames, buttonSports, buttonHistory, buttonMath, buttonScience, buttonTechnology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1_title = findViewById(R.id.title);
        buttonAnimals = findViewById(R.id.animals);
        buttonAnimals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                animalsActivity();
            }
        });
        buttonGames = findViewById(R.id.games);
        buttonGames.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gamesActivity();
            }
        });
        buttonHistory = findViewById(R.id.history);
        buttonHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                historyActivity();
            }
        });
        buttonSports = findViewById(R.id.sports);
        buttonSports.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sportsActivity();
            }
        });

        buttonMath = findViewById(R.id.math);
        buttonMath.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mathActivity();
            }
        });
        buttonScience = findViewById(R.id.science);
        buttonScience.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                scienceActivity();
            }
        });
        buttonTechnology = findViewById(R.id.technology);
        buttonTechnology.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                technologyActivity();
            }
        });
    }

    public void animalsActivity(){
        Intent intent = new Intent(MainActivity.this, AnimalsCategory.class);
        startActivity(intent);
    }

    public void gamesActivity(){
        Intent intent = new Intent(MainActivity.this, GamesCategory.class);
        startActivity(intent);
    }

    public void sportsActivity(){
        Intent intent = new Intent(MainActivity.this, SportsCategory.class);
        startActivity(intent);
    }

    public void mathActivity(){
        Intent intent = new Intent(MainActivity.this, MathCategory.class);
        startActivity(intent);
    }

    public void technologyActivity(){
        Intent intent = new Intent(MainActivity.this, TechnologyCategory.class);
        startActivity(intent);
    }

    public void scienceActivity(){
        Intent intent = new Intent(MainActivity.this, ScienceCategory.class);
        startActivity(intent);
    }

    public void historyActivity(){
        Intent intent = new Intent(MainActivity.this, HistoryCategory.class);
        startActivity(intent);
    }
}
