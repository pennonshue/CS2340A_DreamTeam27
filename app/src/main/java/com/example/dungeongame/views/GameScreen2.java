package com.example.dungeongame.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;
import com.example.dungeongame.model.GameView;
import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.User;

public class GameScreen2 extends AppCompatActivity {
    private GameView gameView;
    private Handler handler = new Handler();
    private boolean running = true;
    private Runnable scoreUpdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeGame();
//        while (running) {
//            updateGame();
//        }
        startGameLoop();
        startScoreUpdater();
    }

    private void initializeGame() {
        gameView = new GameView(this, "Map2.tmx");
        User.getInstance().updatePosition(100, 100);
        setContentView(gameView);
        User.setScore(30);
    }

    private void startGameLoop() {
        Thread gameLoopThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    updateAndRender();
                    try {
                        Thread.sleep(45); // Aim for approximately 60 FPS
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        gameLoopThread.start();
    }

    private void updateAndRender() {
        updateGame();
    }

    private void updateGame() {
        gameView.updateEnemy();
    }

//    private void renderGame() {
//    }

    private void startScoreUpdater() {
        scoreUpdater = new Runnable() {
            @Override
            public void run() {
                updateScore();
            }
        };
        handler.post(scoreUpdater);
    }

    private void updateScore() {
        User.setScore(User.getScore() - 1);
        handler.postDelayed(scoreUpdater, 1000);

        if (User.getHealth() == 0) {
            stopGame();
            showEndScreen();
        }
    }

    private void stopGame() {
        running = false;
        stopScoreUpdater();
    }

    private void stopScoreUpdater() {
        handler.removeCallbacks(scoreUpdater);
    }

    private void showEndScreen() {
        Intent intent = new Intent(GameScreen2.this, EndScreen.class);
        LeaderboardEntry entry = new LeaderboardEntry(User.getUsername(), User.getScore());
        Leaderboard.getInstance().addEntry(entry);
        startActivity(intent);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    return gameView.onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, event);
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if (gameView.getEndTile()) {
                        stopGame();
                        showGameScreen2();
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

    private void showGameScreen2() {
        Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
        startActivity(intent);
    }
}
