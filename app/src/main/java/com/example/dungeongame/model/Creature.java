package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;
import com.google.android.material.button.MaterialButton;

public class Creature extends View implements Enemy, CollisionObserver  {
    private int sprite;
    private static Bitmap sprite1;
    private int speed;
    private String enemySize;
    private int health;
    private float x;
    private float y;
    private static String difficulty;
    private boolean down = true;
    public Creature(float x, float y, String difficulty, Context context) {
        super(context);
        //super(sprites);
        User.getInstance().addObserver(this);
        speed = 15;
        enemySize = "Small";
        health = 5;
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
        this.sprite = R.drawable.panda;
        float scaleX = 3.0f;
        float scaleY = 3.0f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 0, 0, 80,
                90, matrix, true);
    }
    public void update() {
        if (down) {
            y+=6;
            if (y >= 600) {
                down = false;
            }
        } else {
            y-=6;
            if (y <= 100) {
                down = true;
            }
        }
    }
    //if collision, decrement user health, if creature health <= 0, remove enemy from observer list
    @Override
    public void notifyCollision() {
        if (User.getInstance().getX() == x && User.getInstance().getY() == y) {
            User.setHealth(User.getHealth() - 10);
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
    public int getHealth() {
        return health;
    }
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