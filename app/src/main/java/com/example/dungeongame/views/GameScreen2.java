package com.example.dungeongame.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;

public class GameScreen2 extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_2);

        Button toScreen3Btn = findViewById(R.id.toScreen3Btn);
        toScreen3Btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
            startActivity(intent);
        }
    });
}
}
