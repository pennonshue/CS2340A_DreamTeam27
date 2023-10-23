package com.example.dungeongame.views;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.model.GameView;
import com.example.dungeongame.model.GameViewSprite;
import com.example.dungeongame.model.User;

public class GameScreen2 extends AppCompatActivity {

    private GameViewSprite gameViewSprite;
    private Runnable scoreUpdater;
    private ImageView mapView;
    private Handler handler = new Handler();

    private GameView gameView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User.getInstance().updatePosition(100, 100);
        gameView = new GameView(this, "Map2.tmx");
        setContentView(gameView);

        //
        //
        // Create a parent LinearLayout to hold the player information
        //        LinearLayout parentLayout = new LinearLayout(this);
        //        parentLayout.setOrientation(LinearLayout.VERTICAL);
        //
        //        // Create TextViews for player name, difficulty, and health
        //        TextView playerNameTextView = new TextView(this);
        //        playerNameTextView.setText("Name: " + User.getUsername());
        //        playerNameTextView.setTextSize(20);
        //        playerNameTextView.setTextColor(Color.GRAY);
        //
        //        TextView difficultyTextView = new TextView(this);
        //        difficultyTextView.setText("Difficulty: " + User.getDifficulty());
        //        difficultyTextView.setTextSize(20);
        //        difficultyTextView.setTextColor(Color.GRAY);
        //
        //        TextView healthTextView = new TextView(this);
        //        healthTextView.setText("HP: " + User.getHealth());
        //        healthTextView.setTextSize(20);
        //        healthTextView.setTextColor(Color.GRAY);
        //
        //        TextView scoreTextView = new TextView(this);
        //        scoreTextView.setText("Score: " + User.getScore());
        //        scoreTextView.setTextSize(20);
        //        scoreTextView.setTextColor(Color.GRAY);
        //
        //        // Set the position of the parent LinearLayout to (50, 50)
        //        FrameLayout.LayoutParams parentLayoutParams = new FrameLayout.LayoutParams(
        //                FrameLayout.LayoutParams.WRAP_CONTENT,
        //                FrameLayout.LayoutParams.WRAP_CONTENT
        //        );
        //
        //        parentLayoutParams.leftMargin = 100;
        //        parentLayoutParams.topMargin = 1000;
        //
        //        // Add TextViews to the parent LinearLayout
        //        parentLayout.addView(playerNameTextView);
        //        parentLayout.addView(difficultyTextView);
        //        parentLayout.addView(healthTextView);
        //        parentLayout.addView(scoreTextView);
        //
        //        TileMapData t = TMXLoader.readTMX("Map2.tmx", this);
        //        mapView = (ImageView) findViewById(R.id.MapImage);
        //        Bitmap mapImage = TMXLoader.createBitmap (t, this, 0, t.getLayers().size());
        //
        //        if (mapImage != null) {
        //            mapView.setImageBitmap (mapImage);
        //        } else {
        //            Toast errorMessage = Toast.makeText(getApplicationContext(),
        //                    "Map could not be loaded", Toast.LENGTH_LONG);
        //            errorMessage.show();
        //        }
        //
        //
        //        // Add the parent LinearLayout to the FrameLayout
        //        characterSprite.addView(parentLayout, parentLayoutParams);
        //        // Create a Runnable to update the score every second
        scoreUpdater = new Runnable() {
            @Override
            public void run() {
                User.setScore(User.getScore() - 1);
                //                scoreTextView.setText("Score: " + User.getScore());
                //Delay update by 1 second
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(scoreUpdater);
        //        // Set an OnClickListener for the End Button
        //        Button toScreen2Btn = findViewById(R.id.toScreen2Btn);
        //        toScreen2Btn.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                stopScoreUpdater();
        //                Intent intent = new Intent(GameScreen.this, GameScreen2.class);
        //                startActivity(intent);
        //            }
        //        });
        //    }
    }
    private void stopScoreUpdater() {
        // Remove the callbacks to stop the timer when the button is clicked
        handler.removeCallbacks(scoreUpdater);
    }
    //        }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, event);
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (gameView.getEndTile()) {
                    stopScoreUpdater();
                    Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
                    startActivity(intent);
                }
                return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, event);
            case KeyEvent.KEYCODE_DPAD_UP:
                return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_UP, event);
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (gameView.getEndTile()) {
                    stopScoreUpdater();
                    Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
                    startActivity(intent);
                }
                return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_DOWN, event);
            default:
            }
        }
        return super.dispatchKeyEvent(event);
    }

    //    @Override
    //    public void onCharacterLandedOnTile() {
    //        stopScoreUpdater();
    //        Intent intent = new Intent(GameScreen.this, GameScreen2.class);
    //        startActivity(intent);
    //
    //    }

    //        public boolean onKeyUp ( int keyCode, KeyEvent event){
    //            switch (keyCode) {
    //                case KeyEvent.KEYCODE_DPAD_LEFT:
    //                    gameViewSprite.setMoveLeft(false);
    //                    return true; // Return true to indicate that you've handled the event
    //                case KeyEvent.KEYCODE_DPAD_RIGHT:
    //                    gameViewSprite.setMoveRight(false);
    //                    return true;
    //                case KeyEvent.KEYCODE_DPAD_UP:
    //                    gameViewSprite.setMoveUp(false);
    //                    return true;
    //                case KeyEvent.KEYCODE_DPAD_DOWN:
    //                    gameViewSprite.setMoveDown(false);
    //                    return true;
    //                default:
    //            }
    //            return false;
    //        }

}
