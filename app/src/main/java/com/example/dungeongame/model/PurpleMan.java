package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class PurpleMan extends View implements Enemy {
    public void attack() {
        System.out.println("implement a strong attack");
    }

    private int sprite;
    private static Bitmap sprite1;
    private int speed;
    private String enemySize;
    private int health;
    private float x;
    private float y;
    private static String difficulty;
    private static com.example.dungeongame.model.Enemy enemyInstance = null;

    public PurpleMan(float x, float y, String difficulty, Context context) {
        super(context);
        //super(sprites);
        speed = 15;
        enemySize = "Small";
        health = 5;
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = y;
        }
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
        switch (difficulty) {
            case "Easy":
                this.health = 5;
                //this.movementStrategy = new RunStrategy();
                break;
            case "Medium":
                this.health = 10;
                //this.movementStrategy = new RunStrategy();
                break;
            case "Hard":
                this.health = 15;
                //this.movementStrategy = new JogStrategy();
                break;
            default:
                System.out.println("You have entered an invalid difficulty level");
                break;
        }
        this.sprite = R.drawable.creatures;
        float scaleX = 1.4f;
        float scaleY = 1.4f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 160, 140, 90,
                80, matrix, true);
        System.out.println("Creature made");
    }

    //    public static com.example.dungeongame.model.Enemy getInstance(float x, float y, String difficulty) {
//        if (enemyInstance == null) {
//            enemyInstance = new Creature(50, 50, difficulty);
//        }
//        return enemyInstance;
//    }
    public void update(float x, float y) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public Bitmap getSprite1() {
        return sprite1;
    }

    public int getSprite() {
        return sprite;
    }

//    public int getSize() {
//        return size;
//    }

    public int getHealth() {
        return health;
    }

    @Override
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getDifficulty() {
        return difficulty;
    }
}

