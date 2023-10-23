package com.example.dungeongame.views;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.model.GameView;


import com.example.dungeongame.model.User;


public class GameScreen extends AppCompatActivity  {
    private double difficulty;

    private User user;
    private Runnable scoreUpdater;
    private ImageView mapView;
    private Handler handler = new Handler();

    private GameView gameView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(User.getSprite());

        gameView = new GameView(this, "Map1.tmx");
        User.getInstance().updatePosition(100, 100);
        setContentView(gameView);

        User.setScore(1000);


        // Create a Runnable to update the score every second
        scoreUpdater = new Runnable() {
            @Override
            public void run() {
                User.setScore(User.getScore() - 1);

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
                    Intent intent = new Intent(GameScreen.this, GameScreen2.class);
                    startActivity(intent);
                }
                return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, event);
            case KeyEvent.KEYCODE_DPAD_UP:
                return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_UP, event);
            case KeyEvent.KEYCODE_DPAD_DOWN:
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


