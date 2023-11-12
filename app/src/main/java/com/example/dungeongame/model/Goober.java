package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class Goober extends View implements Enemy, CollisionObserver  {
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

    private boolean right = true;
    public Goober(float x, float y, String difficulty, Context context) {
        super(context);
        //super(sprites);
        speed = 6;
        enemySize = "Small";
        health = 40;
        this.x = x;
        this.y = y;

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
        sprite1 = Bitmap.createBitmap(sprite1, 180, 175,
                80, 90, matrix, true);
    }
    public void update() {
        if (x < 2000 && right) {
            x += speed;
            if (x >= 2000) {
                right = false;
            }
        } else {
            if (x >= 10) {
                x -= speed;
                if (x <= 10) {
                    right = true;
                }
            }
        }
    }
    //if collision, decrement user health, if creature health <= 0, remove enemy from observer list
    @Override
    public void notifyCollision() {
        if (User.getInstance().getX() == x && User.getInstance().getY() == y) {
            User.setHealth(User.getHealth() - 45);
        }
        if (health <= 0 ) {
            User.getInstance().removeObserver(this);
        }
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