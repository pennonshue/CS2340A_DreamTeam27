package com.example.dungeongame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        FrameLayout.LayoutParams spriteLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );

        // Center the sprite in the middle of the screen
        spriteLayoutParams.gravity = Gravity.CENTER;
        gameViewSprite.setLayoutParams(spriteLayoutParams);

        // Create a LinearLayout to hold the player information
        LinearLayout infoLayout = new LinearLayout(this);
        infoLayout.setOrientation(LinearLayout.HORIZONTAL);
        infoLayout.setGravity(Gravity.CENTER);

        // Create TextViews for player name, difficulty, and health
        TextView playerNameTextView = new TextView(this);
        playerNameTextView.setText("Name: " + User.getUsername());
        playerNameTextView.setTextSize(20);
        playerNameTextView.setTextColor(Color.BLACK);

        TextView difficultyTextView = new TextView(this);
        difficultyTextView.setText("Difficulty: " + User.getDifficulty());
        difficultyTextView.setTextSize(20);
        difficultyTextView.setTextColor(Color.BLACK);

        TextView healthTextView = new TextView(this);
        healthTextView.setText("HP: " + User.getHealth());
        healthTextView.setTextSize(20);
        healthTextView.setTextColor(Color.BLACK);

        // Add TextViews to the LinearLayout
        infoLayout.addView(playerNameTextView);
        infoLayout.addView(difficultyTextView);
        infoLayout.addView(healthTextView);

        // Add the LinearLayout to the top of the screen
        FrameLayout.LayoutParams infoLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        infoLayoutParams.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        characterSprite.addView(infoLayout, infoLayoutParams);

        // Set an OnClickListener for the End Button
        Button endButton = findViewById(R.id.EndBut);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
                startActivity(intent);
            }
        });
    }
}
