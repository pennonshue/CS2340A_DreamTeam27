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


public class GameView extends View implements UserSubject {

    private String mapName;
    private boolean endTile;
    private Bitmap tilemapBitmap;
    private Bitmap userSprite;
    private Bitmap enemySprite1;
    private Bitmap enemySprite2;
    public Enemy getEnemy1() {
        return enemy1;
    }
    public Enemy getEnemy2() {
        return enemy2;
    }
    private Enemy enemy1;
    private Enemy enemy2;
    private EnemyFactory enemyFactory1;
    private EnemyFactory enemyFactory2;
    private TileMapData t;

    public GameView(Context context, String map) {
        super(context);
        setFocusable(true);
        this.endTile = false;
        this.mapName = map;

        t = TMXLoader.readTMX(map, context);
        tilemapBitmap = TMXLoader.createBitmap(t, context, 0, t.getLayers().size());
        userSprite = User.getSprite1();

        switch (mapName) {
        case "Map1.tmx":
            EnemyFactory enemyFactory = new CreatureFactory(context);
            enemy1 = enemyFactory.generateEnemy();
            enemySprite1 = enemy1.getSprite1();

            enemyFactory2 = new KnightFactory(context);
            enemy2 = enemyFactory2.generateEnemy();
            enemySprite2 = enemy2.getSprite1();

            ///PUT UR SECOND CREATURE HERE!!!!!!!

            break;
        case "Map2.tmx":
            enemyFactory1 = new PurpleManFactory(context);
            enemy1 = enemyFactory1.generateEnemy();
            enemySprite1 = enemy1.getSprite1();

            enemyFactory2 = new NecromancerFactory(context);
            enemy2 = enemyFactory2.generateEnemy();
            enemySprite2 = enemy2.getSprite1();

            break;
        case "Map3.tmx":
            enemyFactory1 = new GooberFactory(context);
            enemy1 = enemyFactory1.generateEnemy();
            enemySprite1 = enemy1.getSprite1();

            enemyFactory2 = new BossFactory(context);
            enemy2 = enemyFactory2.generateEnemy();
            enemySprite2 = enemy2.getSprite1();
            break;
        default:
            break;
        }
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
        long gID = t.getGIDAt(tileX, tileY);

        if (gID == 100) {
            endTile = true;
        }

        int enemy1tileY = (int) (enemy1.getY()) / (t.tileheight + 7);
        int enemy1tileX = (int) (enemy1.getX()) / (t.tilewidth + 12);
        long enemyGID = t.getGIDAt(enemy1tileX, enemy1tileY);
        System.out.println(gID + ", tileX: " + tileX + ", tileY: " + tileY);
        System.out.println(enemyGID + ", ENEMYtileX: " + enemy1tileX + ", ENEMYtileY: "
                + enemy1tileY);
        int enemy2tileY = (int) (enemy2.getY()) / (t.tileheight + 7);
        int enemy2tileX = (int) (enemy2.getX()) / (t.tilewidth + 12);
        if (gID <= 120 || gID >= 231) {
            System.out.println(gID);
            User.getInstance().updatePosition((int) x, (int) y);
        } else if (tileX <= enemy1tileX + 3 && tileY <= enemy1tileY + 3 && tileX > enemy1tileX
                && tileY > enemy1tileY) {
            User.getInstance().updatePosition((int) (x + dx/3), (int) (y + dy/3));
            if (!enemy1.getCollision()) {
                enemy1.setCollision();
            }
            User.setHealth(User.getHealth() - enemy1.getAttack());
        } else if (tileX <= enemy2tileX + 3 && tileY <= enemy2tileY + 3 && tileX
                > enemy2tileX && tileY > enemy2tileY) {
            User.getInstance().updatePosition((int) (x + dx/3), (int) (y + dy/3));
            if (!enemy2.getCollision()) {
                enemy2.setCollision();
            }
            User.setHealth(User.getHealth() - enemy2.getAttack());
        } else {
            System.out.println(gID);
            User.getInstance().updatePosition((int) (x + dx), (int) (y + dy));
            if (enemy1.getCollision()) {
                enemy1.setCollision();
            }
            if (enemy2.getCollision()) {
                enemy2.setCollision();
            }
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
        canvas.drawBitmap(enemySprite1, enemy1.getX(), enemy1.getY(), null);
        canvas.drawBitmap(enemySprite2, enemy2.getX(), enemy2.getY(), null);


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

    //    public void setGameViewListener(GameViewObserver observer) {
    //        observers.add(observer);
    //    }

    //    public void notifyCharacterLandedOnTile(int x, int y) {
    //        for (GameViewObserver observer : observers) {
    //            observer.updateOnCharacterLandedOnTile(x, y);
    //        }
    //    }

    // Implement the GameViewObserver interface method
    //    @Override
    //    public void updateOnCharacterLandedOnTile(int x, int y) {
    //        // Handle updates when the character lands on a tile here
    //        // You can add custom logic or simply call the GameViewListener if needed
    //    }


    public void updateEnemy() {
        enemy1.update();
        enemy2.update();
        invalidate();
    }

    @Override
    public void addObserver(CollisionObserver enemy) {

    }

    @Override
    public void removeObserver(CollisionObserver enemy) {

    }

    @Override
    public void notifyObserver() {

    }
}
