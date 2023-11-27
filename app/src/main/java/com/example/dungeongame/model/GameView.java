
package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

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

    private Enemy enemy1;
    private Enemy enemy2;
    private EnemyFactory enemyFactory1;
    private EnemyFactory enemyFactory2;
    private TileMapData t;
    private Potion potion;
    private Weapon weapon;
    private Bitmap weaponSprite;
    private Bitmap potion1;
    private int potionWidth;
    private int potionHeight;
    private int userWidth;
    private int userHeight;
    private boolean powerup;
    private boolean weaponDisplay;

    private static boolean enemy1display = true;
    private static boolean enemy2display = true;

    public static void setEnemy1display(boolean enemy1display) {
        GameView.enemy1display = enemy1display;
    }
    public static void setEnemy2display(boolean enemy2display) {
        GameView.enemy2display = enemy2display;
    }

    public GameView(Context context, String map) {
        super(context);
        setFocusable(true);
        this.endTile = false;
        this.mapName = map;
        this.userWidth = User.getInstance().getSprite1().getWidth() - 20;
        this.userHeight = User.getInstance().getSprite1().getHeight() - 20;
        this.powerup = true;
        this.weaponDisplay = true;
        User.getInstance().setWeapon(false);

        t = TMXLoader.readTMX(map, context);
        tilemapBitmap = TMXLoader.createBitmap(t, context, 0, t.getLayers().size());
        userSprite = User.getSprite1();

        switch (mapName) {
            case "Map1.tmx":
                setEnemy1display(true);
                setEnemy2display(true);
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


                weapon = new Weapon1(context);
                weaponSprite = weapon.getSprite();
                weapon.setX(200);
                weapon.setY(300);
                break;


            case "Map2.tmx":
                setEnemy1display(true);
                setEnemy2display(true);

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

                weapon = new Weapon2(context);
                weaponSprite = weapon.getSprite();
                weapon.setX(1100);
                weapon.setY(700);
                break;

            case "Map3.tmx":
                setEnemy1display(true);
                setEnemy2display(true);
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

                weapon = new Weapon3(context);
                weaponSprite = weapon.getSprite();
                weapon.setX(1200);
                weapon.setY(100);
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
            case KeyEvent.KEYCODE_SPACE:
                if (User.getInstance().getWeapon()) {
                    attack(x, y);
                }
                break;
            default:
                break;
        }
        // Trigger a redraw
        invalidate();
        return true;
    }


    private void attack(float x, float y) {
        int enemy1X = (int) enemy1.getX();
        int enemy1Y = (int) enemy1.getY();
        int enemy2X = (int) enemy2.getX();
        int enemy2Y = (int) enemy2.getY();

        if (x <= (enemy1X+enemy1Width) && y <= (enemy1Y + enemy1Height) && (x+userWidth) > (enemy1X) && (y) > (enemy1Y - userHeight)) {
            enemy1display = false;
        } else if (x <= (enemy2X+enemy2Width) && y <= (enemy2Y + enemy2Height) && (x+userWidth) > (enemy2X) && (y) > (enemy2Y - userHeight)) {
            enemy2display = false;
        }

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
        if ((powerup) && x <= (potion.getX() + potionWidth) && y <= (potion.getY() + potionHeight)
                && (x + userWidth) > (potion.getX()) && (y) > (potion.getY() - userHeight)) {
            System.out.println("Potion collect!");
            potion.powerUp();
            //delete potion
            powerup = false;
        }

        if (x <= (weapon.getX() + 20) && y <= (weapon.getY() + 20)
                && (x + userWidth) > (weapon.getX()) && (y + userHeight) > (weapon.getY())) {
            //delete potion here
//            potion.getSprite1().recycle();
            User.getInstance().setWeapon(true);
            weaponDisplay = false;
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
        if (enemy1display) {
            canvas.drawBitmap(enemySprite1, enemy1.getX(), enemy1.getY(), null);
        }
        if (enemy2display) {
            canvas.drawBitmap(enemySprite2, enemy2.getX(), enemy2.getY(), null);

        }


        //weapon
        if (weaponDisplay) {
            canvas.drawBitmap(weaponSprite, weapon.getX(), weapon.getY(), null);
        } else {
            canvas.drawBitmap(weaponSprite, User.getInstance().getX() + 50, User.getInstance().getY() + 45, null);
        }

        if (powerup) {
            canvas.drawBitmap(potion1, potion.getX(), potion.getY(), null);
        }
        // Draw user information (replace with your actual values)
        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(25);

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
        if (enemy1display) {
            enemy1.update();
        }
        if (enemy2display) {
            enemy2.update();
        }


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

        if (enemy1display && x <= (enemy1X+enemy1Width) && y <= (enemy1Y + enemy1Height) && (x+userWidth) > (enemy1X) && (y) > (enemy1Y - userHeight)) {
            if (!enemy1.getCollision()) {
                enemy1.setCollision();
            }
            User.setHealth(User.getHealth() - enemy1.getAttack());
            User.decreaseScore(enemy1.getAttack() * 4);
        } else if (enemy2display && x <= (enemy2X+enemy2Width) && y <= (enemy2Y + enemy2Height) && (x+userWidth) > (enemy2X) && (y) > (enemy2Y - userHeight)) {
            if (!enemy2.getCollision()) {
                enemy2.setCollision();
            }
            User.setHealth(User.getHealth() - enemy2.getAttack());
            User.decreaseScore(enemy2.getAttack() * 4);
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
        //trigger redraw
        invalidate();
    }

}

