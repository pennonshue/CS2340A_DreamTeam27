package com.example.dungeongame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {
    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create an instance of your custom GameViewSprite
        GameViewSprite gameView = new GameViewSprite(this);
        setContentView(R.layout.activity_game_screen);

        FrameLayout characterSprite = findViewById(R.id.gameSpriteCharacter);

        GameViewSprite gameViewSprite = new GameViewSprite(this);

        characterSprite.addView(gameViewSprite);


        Button end = findViewById(R.id.EndBut);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
                startActivity(intent);
            }
        });
    }
}
