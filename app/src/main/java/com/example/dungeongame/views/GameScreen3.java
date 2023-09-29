package com.example.dungeongame.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;

public class GameScreen3 extends AppCompatActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_3);

        Button endBtn = findViewById(R.id.EndBut);
        endBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreen3.this, EndScreen.class);
                startActivity(intent);
            }
        });
    }
}
