package com.jorgeserna.soccerquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class QuizActivity extends AppCompatActivity {

    private Button mFirstLevelButton;
    private Button mSecondLevelButton;
    private Button mThirdLevelButton;
    public static final String LEVEL = "level";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mFirstLevelButton = (Button) findViewById(R.id.first_level);
        mFirstLevelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, LevelActivity.class);
                intent.putExtra(LEVEL, 1);
                startActivity(intent);
            }
        });

        mSecondLevelButton = (Button) findViewById(R.id.second_level);
        mSecondLevelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, LevelActivity.class);
                intent.putExtra(LEVEL, 2);
                startActivity(intent);
            }
        });

        mThirdLevelButton = (Button) findViewById(R.id.third_level);
        mThirdLevelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, LevelActivity.class);
                intent.putExtra(LEVEL, 3);
                startActivity(intent);
            }
        });
    }
}
