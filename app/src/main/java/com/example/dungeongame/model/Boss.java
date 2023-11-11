package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class Boss extends View implements Enemy  {
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
    public Boss(float x, float y, String difficulty, Context context) {
        super(context);
        //super(sprites);
        speed = 25;
        enemySize = "Small";
        health = 40;
        this.x = x;
        this.y = y;
        switch (difficulty) {
            case "Easy":
                this.health = 35;
                //this.movementStrategy = new RunStrategy();
                break;
            case "Medium":
                this.health = 40;
                //this.movementStrategy = new RunStrategy();
                break;
            case "Hard":
                this.health = 45;
                //this.movementStrategy = new JogStrategy();
                break;
            default:
                System.out.println("You have entered an invalid difficulty level");
                break;
        }
        this.sprite = R.drawable.toast;
        float scaleX = 1.4f;
        float scaleY = 1.4f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 0, 0, 80,
                90, matrix, true);
    }
        public void update() {
            boolean right = true;
            if (x < 400 && right) {
                x+=3;
                if (x >= 400) {
                    right = false;
                }
            } else {
                if (x >= 10) {
                    x-=3;
                    if (x <= 10) {
                        right = true;
                    }
                }
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