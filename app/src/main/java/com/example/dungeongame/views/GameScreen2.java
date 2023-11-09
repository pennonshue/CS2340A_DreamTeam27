package com.example.dungeongame.views;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;



import com.example.dungeongame.model.GameView;
import com.example.dungeongame.model.GameViewSprite;
import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
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
        scoreUpdater = new Runnable() {
            @Override
            public void run() {
                User.setScore(User.getScore() - 1);
                //Delay update by 1 second
                handler.postDelayed(this, 1000);
                if (User.getHealth() == 0) {
                    stopScoreUpdater();
                    Intent intent = new Intent(GameScreen2.this, EndScreen.class);
                    LeaderboardEntry entry = new LeaderboardEntry(User.getUsername(),
                            User.getScore());
                    Leaderboard.getInstance().addEntry(entry);
                    startActivity(intent);
                }
            }
        };
        handler.post(scoreUpdater);

    }
    private void stopScoreUpdater() {
        // Remove the callbacks to stop the timer when the button is clicked
        handler.removeCallbacks(scoreUpdater);
    }


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
