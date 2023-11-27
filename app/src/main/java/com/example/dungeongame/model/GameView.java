
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

public class GameView extends View {

    private String mapName;
    private boolean endTile;
    private Bitmap tilemapBitmap;
    private Bitmap userSprite;
    private int enemy1Height;
    private int enemy1Width;
    private int enemy2Height;
    private int enemy2Width;
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
    private Potion potion;
    private Bitmap potion1;
    private int potionWidth;
    private int potionHeight;

    private int userWidth;
    private int userHeight;


    public GameView(Context context, String map) {
        super(context);
        setFocusable(true);
        this.endTile = false;
        this.mapName = map;
        this.userWidth = User.getInstance().getSprite1().getWidth() - 20;
        this.userHeight = User.getInstance().getSprite1().getHeight() - 20;

        t = TMXLoader.readTMX(map, context);
        tilemapBitmap = TMXLoader.createBitmap(t, context, 0, t.getLayers().size());
        userSprite = User.getSprite1();

        switch (mapName) {
            case "Map1.tmx":
                EnemyFactory enemyFactory = new CreatureFactory(context);
                enemy1 = enemyFactory.generateEnemy();
                enemySprite1 = enemy1.getSprite1();
                enemy1Height = 180;
                enemy1Width = 200;
                ///PUT UR SECOND CREATURE HERE!!!!!!!
                enemyFactory2 = new NecromancerFactory(context);
                enemy2 = enemyFactory2.generateEnemy();
                enemySprite2 = enemy2.getSprite1();
                enemy2Height = 140;
                enemy2Width = 200;
                //POTION

                potion = new HealthPotion(context);
                potion1 = potion.getSprite1();
                potionHeight = 46;
                potionWidth = 50;
                break;


            case "Map2.tmx":
                enemyFactory1 = new PurpleManFactory(context);
                enemy1 = enemyFactory1.generateEnemy();
                enemySprite1 = enemy1.getSprite1();
                enemy1Height = 80;
                enemy1Width = 75;

                enemyFactory2 = new NecromancerFactory(context);
                enemy2 = enemyFactory2.generateEnemy();
                enemySprite2 = enemy2.getSprite1();
                enemy2Height = 140;
                enemy2Width = 200;
                //POTION
                potion = new SpeedPotion(context);
                potion1 = potion.getSprite1();
                potionHeight = 46;
                potionWidth = 50;

                break;

            case "Map3.tmx":
                enemyFactory1 = new GooberFactory(context);
                enemy1 = enemyFactory1.generateEnemy();
                enemySprite1 = enemy1.getSprite1();
                enemy1Height = 126;
                enemy1Width = 112;

                enemyFactory2 = new NecromancerFactory(context);
                enemy2 = enemyFactory2.generateEnemy();
                enemySprite2 = enemy2.getSprite1();
                enemy2Height = 140;
                enemy2Width = 200;

                //POTION
                potion = new SizePotion(context);
                potion1 = potion.getSprite1();
                potionHeight = 46;
                potionWidth = 50;
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
        //check if at power up
        if (x <= (potion.getX() + potionWidth) && y <= (potion.getY() + potionHeight)
                && (x + userWidth) > (potion.getX()) && (y) > (potion.getY() - userHeight)) {
            System.out.println("Potion collect!");
            potion.powerUp();
//            User.getInstance().powerUp();
            //delete potion here
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

        //enemies
        canvas.drawBitmap(enemySprite1, enemy1.getX(), enemy1.getY(), null);
        canvas.drawBitmap(enemySprite2, enemy2.getX(), enemy2.getY(), null);

        //powerup
        canvas.drawBitmap(potion1, potion.getX(), potion.getY(), null);

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
    public void updateEnemy() {
        enemy1.update();
        enemy2.update();

        int x = (int) User.getInstance().getX();
        int y = (int) User.getInstance().getY();
        int enemy1X = (int) enemy1.getX();
        int enemy1Y = (int) enemy1.getY();
        int enemy2X = (int) enemy2.getX();
        int enemy2Y = (int) enemy2.getY();

        int tileY = (int) User.getInstance().getY() / (t.tilewidth + 7);
        int tileX = (int) User.getInstance().getX() / (t.tilewidth + 12);
        long GID = t.getGIDAt(tileX, tileY);

        if (GID == 100) {
            endTile = true;
        }

        if (x <= (enemy1X+enemy1Width) && y <= (enemy1Y + enemy1Height) && (x+userWidth) > (enemy1X) && (y) > (enemy1Y - userHeight)) {
            if (!enemy1.getCollision()) {
                enemy1.setCollision();
            }
            User.setHealth(User.getHealth() - 10);
        } else if (x <= (enemy2X+enemy2Width) && y <= (enemy2Y + enemy2Height) && (x+userWidth) > (enemy2X) && (y) > (enemy2Y - userHeight)) {
            if (!enemy2.getCollision()) {
                enemy2.setCollision();
            }
            User.setHealth(User.getHealth() - 1);
            User.setHealth(User.getHealth() - enemy1.getAttack());
            enemySprite2 = enemy2.getSprite2();
        } else {
            enemySprite2 = enemy2.getSprite1();
            if (enemy1.getCollision()) {
                enemy1.setCollision();
            }
            if (enemy2.getCollision()) {
                enemy2.setCollision();
            }
        }

        invalidate();
    }
}

