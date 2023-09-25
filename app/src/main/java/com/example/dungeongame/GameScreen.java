package com.example.dungeongame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
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

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, // Width (or specify a fixed width)
                FrameLayout.LayoutParams.WRAP_CONTENT  // Height (or specify a fixed height)
        );

        layoutParams.leftMargin = 170;
        layoutParams.topMargin = 380;

        gameViewSprite.setLayoutParams(layoutParams);


        TextView usernameTextView = new TextView(this);
        System.out.println(User.getUsername());
        usernameTextView.setText(User.getUsername());
        usernameTextView.setTextSize(20); // Adjust text size as needed
        usernameTextView.setTextColor(Color.BLACK);

        FrameLayout.LayoutParams usernameParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );

// Calculate the position for the username TextView based on the sprite's position
        int spriteX = (int) gameViewSprite.getX();

        int spriteY = (int) gameViewSprite.getY();
        System.out.println(spriteX + "," + spriteY);

        int usernameWidth = usernameTextView.getMeasuredWidth();


        int usernameX = (int) spriteX + 350 - usernameWidth/2; // Adjust this as needed
        int usernameY = (int) (spriteY + 440); // Adjust this as needed to position it above the sprite
        System.out.println(usernameX +"," + usernameY);

// Set the position of the username TextView
        usernameParams.leftMargin = usernameX;
        usernameParams.topMargin = usernameY;

// Add the username TextView to the FrameLayout
        characterSprite.addView(usernameTextView, usernameParams);



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
