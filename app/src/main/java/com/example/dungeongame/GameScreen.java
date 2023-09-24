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
        System.out.println(User.getSprite());

        setContentView(R.layout.activity_game_screen);

        FrameLayout characterSprite = findViewById(R.id.gameSpriteCharacter);

        GameViewSprite gameViewSprite = new GameViewSprite(this, User.getSprite());

        characterSprite.addView(gameViewSprite);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, // Width (or specify a fixed width)
                FrameLayout.LayoutParams.WRAP_CONTENT  // Height (or specify a fixed height)
        );

        layoutParams.leftMargin = 170;
        layoutParams.topMargin = 380;

        gameViewSprite.setLayoutParams(layoutParams);


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
