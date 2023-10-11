package com.example.dungeongame.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.dungeongame.R;
import com.example.dungeongame.model.GameViewSprite;
import com.example.dungeongame.model.User;

public class GameScreen2 extends AppCompatActivity {

    private GameViewSprite gameViewSprite;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_2);

        ConstraintLayout characterSprite = findViewById(R.id.gameSpriteCharacter2);

        gameViewSprite = new GameViewSprite(this, User.getSprite());

        characterSprite.addView(gameViewSprite);


        // Create a parent LinearLayout to hold the player information
        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setOrientation(LinearLayout.VERTICAL);

        // Create TextViews for player name, difficulty, and health
        TextView playerNameTextView = new TextView(this);
        playerNameTextView.setText("Name: " + User.getUsername());
        playerNameTextView.setTextSize(20);
        playerNameTextView.setTextColor(Color.GRAY);

        TextView difficultyTextView = new TextView(this);
        difficultyTextView.setText("Difficulty: " + User.getDifficulty());
        difficultyTextView.setTextSize(20);
        difficultyTextView.setTextColor(Color.GRAY);

        TextView healthTextView = new TextView(this);
        healthTextView.setText("HP: " + User.getHealth());
        healthTextView.setTextSize(20);
        healthTextView.setTextColor(Color.GRAY);

        // Set the position of the parent LinearLayout to (50, 50)
        FrameLayout.LayoutParams parentLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );

        parentLayoutParams.leftMargin = 100;
        parentLayoutParams.topMargin = 1000;

        // Add TextViews to the parent LinearLayout
        parentLayout.addView(playerNameTextView);
        parentLayout.addView(difficultyTextView);
        parentLayout.addView(healthTextView);

        // Add the parent LinearLayout to the FrameLayout
        characterSprite.addView(parentLayout, parentLayoutParams);


        Button toScreen3Btn = findViewById(R.id.toScreen3Btn);
        toScreen3Btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
            startActivity(intent);
        }
    });


}

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                gameViewSprite.setMoveLeft(true);
                gameViewSprite.moveLeft();
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                gameViewSprite.setMoveRight(true);
                gameViewSprite.moveRight();
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                gameViewSprite.setMoveUp(true);
                gameViewSprite.moveUp();
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                gameViewSprite.setMoveDown(true);
                gameViewSprite.moveDown();
                return true;
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                gameViewSprite.setMoveLeft(false);
                return true; // Return true to indicate that you've handled the event
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                gameViewSprite.setMoveRight(false);
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                gameViewSprite.setMoveUp(false);
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                gameViewSprite.setMoveDown(false);
                return true;
        }
        return false;
    }
}


