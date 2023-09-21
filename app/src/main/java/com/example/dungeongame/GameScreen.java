package com.example.dungeongame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Button end = findViewById(R.id.EndBut);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
                startActivity(intent);
            }
        });

        Bundle extras = getIntent().getExtras();

        String userName = extras.getString("userName");
        String difficulty = extras.getString("difficulty");

        TextView textViewUserName = findViewById(R.id.userName);
        TextView textViewDifficulty = findViewById(R.id.difficulty);

        if (userName != null && difficulty != null) {
            textViewUserName.setText(userName);
            textViewDifficulty.setText("Difficulty Level: " + difficulty);
        }
    }
}