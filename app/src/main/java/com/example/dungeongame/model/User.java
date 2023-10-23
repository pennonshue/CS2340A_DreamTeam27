package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class User extends View {

    private static MovementStrategy movementStrategy;
    private int x = 1600;
    @Override
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    private int y = 300;


    public static Bitmap getSprite1() {
        return sprite1;
    }

    private static Bitmap sprite1;

    private static User userInstance = null;
    private static String username;

    private static int score;
    private static int speed;
    private static int health;

    private static int sprite;
    private static String difficulty;
    private static boolean win;




    public static User getInstance(Context context, String username, int sprite, String difficulty,
                                   int speed) {

        if (userInstance == null) {
            userInstance = new User(context, username, sprite, difficulty, speed);
        }
        return userInstance;
    }

    public static User getInstance() {
        return userInstance;
    }


    private User(Context context, String username, int sprite, String difficulty, int speed) {
        super(context);
        this.difficulty = difficulty;
        this.username = username;
        this.score = 20;

        this.win = true;

        switch (difficulty) {
        case "Easy":
            this.health = 100;
            this.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            this.health = 85;
            this.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            this.health = 60;
            //this.movementStrategy = new WalkStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
        }
        this.speed = speed;

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
    }

    public void updatePosition(int newX, int newY) {
        x = newX;
        y = newY;
        // Call invalidate to trigger redraw
        invalidate();
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

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        User.speed = speed;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        User.health = health;
        if (health <= 0) {
            win = false;
            setScore(0);
        } else {
            win = true;
        }
    }
    public static boolean getWin() {
        return win;
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
            //User.movementStrategy = new WalkStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
        }
    }

}

