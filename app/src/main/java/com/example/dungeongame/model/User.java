package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.example.dungeongame.R;

public class User extends View implements UserSubject {
    private List<CollisionObserver> enemies;
    private static MovementStrategy movementStrategy;
    private int x = 1600;
    private int y = 300;
    private static Bitmap sprite1;
    private static User userInstance = null;
    private static String username;
    private static int score;
    private static int health;
    private static int sprite;
    private static String difficulty;
    private static boolean win;

    public static User getInstance(Context context, String username, int sprite,
                                   String difficulty) {

        if (userInstance == null) {
            userInstance = new User(context, username, sprite, difficulty);
        }
        return userInstance;
    }

    public static User getInstance() {
        return userInstance;
    }


    private User(Context context, String username, int sprite, String difficulty) {
        super(context);
        enemies = new ArrayList<>();
        this.difficulty = difficulty;
        this.username = username;
        this.score = 600;
        this.win = true;
        switch (difficulty) {
        case "Easy":
            this.health = 1000;
            this.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            this.health = 900;
            this.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            this.health = 800;
            this.movementStrategy =  new JogStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
        }

        this.sprite = sprite;

        switch (sprite) {
        case (1):
            this.sprite = R.drawable.sprite_1;
            sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
            break;
        case (2):
            this.sprite = R.drawable.sprite_2;
            sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
            break;
        case (3):
            this.sprite = R.drawable.sprite_3;
            sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
            break;
        default:
            break;
        }
        float scaleX = 0.15f;
        float scaleY = 0.15f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = Bitmap.createBitmap(sprite1, 0, 0, sprite1.getWidth(),
                sprite1.getHeight(), matrix, true);
        System.out.println("size" + sprite1.getWidth() + "x" + sprite1.getHeight());
    }

    public void updatePosition(int newX, int newY) {
        x = newX;
        y = newY;
        notifyObserver();
        // Call invalidate to trigger redraw
        invalidate();
    }
    @Override
    public void notifyObserver() {
        for (CollisionObserver enemy : enemies) {
            enemy.notifyCollision();
        }
    }
    @Override
    public void addObserver(CollisionObserver enemy) {
        enemies.add(enemy);
    }
    @Override
    public void removeObserver(CollisionObserver enemy) {
        enemies.remove(enemy);
    }

    public static MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        User.username = username;
    }
    public static int getSprite() {
        return sprite;
    }
    public static void setSprite(int sprite) {
        User.sprite = sprite;
    }
    @Override
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public static Bitmap getSprite1() {
        return sprite1;
    }
    public static int getHealth() {
        return health;
    }
    public static void setHealth(int health) {
        User.health = health;
        if (health <= 0) {
            win = false;
            setScore(0);
            User.health = 0;
        } else {
            win = true;
        }
    }
    public static boolean getWin() {
        return score > 0;
    }
    public static String getDifficulty() {
        return difficulty;
    }
    public static int getScore() {
        return score;
    }
    public static void setScore(int score) {
        if (score < 0) {
            User.score = 0;
        } else {
            User.score = score;
        }
    }
    public static void resetPlayer() {
        userInstance = null;
    }


    public static void resetHealth() {
        switch (difficulty) {
        case "Easy":
            User.health = 100;
            break;
        case "Medium":
            User.health = 85;
            break;
        case "Hard":
            User.health = 60;
            break;
        default:
            break;
        }

    }
    public static void setDifficulty(String difficulty) {
        switch (difficulty) {
        case "Easy":
            User.health = 100;
            User.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            User.health = 85;
            User.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            User.health = 60;
            User.movementStrategy = new JogStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
        }
    }
}

