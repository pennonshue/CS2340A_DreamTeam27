package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.View;

import com.example.dungeongame.TMXLoader.TMXLoader;
import com.example.dungeongame.TMXLoader.TileMapData;

import java.util.ArrayList;
import java.util.List;

public class GameView extends View implements GameViewObserver {

    private List<GameViewObserver> observers;

    private String mapName;

    private boolean endTile;
    private Bitmap tilemapBitmap;

    private Bitmap userSprite;
    private Bitmap creatureSprite;
    private Bitmap bossSprite;

    private TileMapData t;

    public GameView(Context context, String map) {
        super(context);
        setFocusable(true);
        this.endTile = false;
        this.mapName = map;
//        this.enemies = new ArrayList<>();
        //this.enemies.add(new Devil(context));
        // Load the map and user sprite
        t = TMXLoader.readTMX(map, context);
        tilemapBitmap = TMXLoader.createBitmap(t, context, 0, t.getLayers().size());
        userSprite = User.getSprite1();
        EnemyFactory enemyFactory = new CreatureFactory(context);
        Enemy booger = enemyFactory.generateEnemy();
        creatureSprite = booger.getSprite1();
        EnemyFactory enemyFactoryBoss = new BossFactory(context);
        Enemy jellySandwhich = enemyFactoryBoss.generateEnemy();
        bossSprite = jellySandwhich.getSprite1();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        float x = User.getInstance().getX();
        float y = User.getInstance().getY();
        System.out.println(t.tileheight + " , " + t.tilewidth);

        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_DOWN:
            handleMove(x, y, 0, t.tileheight
                    + User.getInstance().getMovementStrategy().movementSpeed());  // Move down
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            handleMove(x, y, 0, -t.tileheight
                    - User.getInstance().getMovementStrategy().movementSpeed());  // Move up
            break;
        case KeyEvent.KEYCODE_DPAD_LEFT:
            handleMove(x, y, -t.tilewidth
                    - User.getInstance().getMovementStrategy().movementSpeed(), 0);  // Move left
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            handleMove(x, y, t.tilewidth
                    + User.getInstance().getMovementStrategy().movementSpeed(), 0);  // Move right
            break;
        default:
            break;
        }

        // Trigger a redraw
        invalidate();

        return true;
    }

    private void handleMove(float x, float y, int dx, int dy) {
        int tileY = (int) (y + dy) / (t.tileheight + 7);
        int tileX = (int) (x + dx) / (t.tilewidth + 12);
        long GID = t.getGIDAt(tileX, tileY);

        if (GID == 100) {
            endTile = true;
        }

        System.out.println(GID + ", tileX: " + tileX + ", tileY: " + tileY);

        if (GID >= 120 && GID <= 231) {
            System.out.println(GID);
            User.getInstance().updatePosition((int) (x + dx), (int) (y + dy));
        } else {
            System.out.println(GID);
            User.getInstance().updatePosition((int) x, (int) y);
        }
    }
    public boolean getEndTile() {
        return endTile;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw the map
        canvas.drawBitmap(tilemapBitmap, 0, 0, null);

        // Draw the user sprite
        canvas.drawBitmap(userSprite, User.getInstance().getX(), User.getInstance().getY(), null);

        //test
        canvas.drawBitmap(creatureSprite, 200, 200, null);
        canvas.drawBitmap(bossSprite, 250, 250, null);

        //Draw enemy sprites
//        for (Enemy enemy : enemies) {
//            Bitmap enemySprite = enemy.getSprite1();
//            // Draw the enemySprite at the enemy's position on the canvas
//            canvas.drawBitmap(enemySprite, enemy.getX(), enemy.getY(), null);
//        }

        // Draw user information (replace with your actual values)
        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(20);

        String playerName = "Name: " + User.getUsername();
        String difficulty = "Difficulty: " + User.getDifficulty();
        String health = "HP: " + User.getHealth();
        String score = "Score: " + User.getScore();

        canvas.drawText(playerName, 100, 50, textPaint);
        canvas.drawText(difficulty, 100, 70, textPaint);
        canvas.drawText(health, 100, 90, textPaint);
        canvas.drawText(score, 100, 110, textPaint);
    }

    public void setGameViewListener(GameViewObserver observer) {
        observers.add(observer);
    }

    public void notifyCharacterLandedOnTile(int x, int y) {
        for (GameViewObserver observer : observers) {
            observer.updateOnCharacterLandedOnTile(x, y);
        }
    }

    // Implement the GameViewObserver interface method
    @Override
    public void updateOnCharacterLandedOnTile(int x, int y) {
        // Handle updates when the character lands on a tile here
        // You can add custom logic or simply call the GameViewListener if needed
    }
}
