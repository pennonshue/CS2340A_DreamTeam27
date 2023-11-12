package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

import java.util.List;

public class Necromancer extends View implements Enemy, CollisionObserver {
    private int sprite;
    private String difficulty;
    private Bitmap sprite1;
    private int speed;
    private String enemySize;
    private int health;
    private float x;
    private float y;
    private boolean right = true;
    public Necromancer(float x, float y, String difficulty, Context context) {
        super(context);
        User.getInstance().addObserver(this);
        speed = 14;
        enemySize = "Medium";
        this.x = x;
        this.y = y;
        switch (difficulty) {
            case "Easy":
                this.health = 20;
                //this.movementStrategy = new RunStrategy();
                break;
            case "Medium":
                this.health = 25;
                //this.movementStrategy = new RunStrategy();
                break;
            case "Hard":
                this.health = 30;
                //this.movementStrategy = new JogStrategy();
                break;
            default:
                System.out.println("You have entered an invalid difficulty level");
                break;
        }
        float scaleX = 0.8f;
        float scaleY = 0.8f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite = R.drawable.necromancer;
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 90, 190, 200,
                160, matrix, true);
    }
    public void update() {
        if (x < 1900 && right) {
            x+=speed;
            if (x >= 1900) {
                right = false;
            }
        } else {
            if (x >= 10) {
                x-=speed;
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
            User.setHealth(User.getHealth() - 20);
        }
        if (health <= 0 ) {
            User.getInstance().removeObserver(this);
        }
    }
    public int getSprite() {
        return sprite;
    }
    public Bitmap getSprite1() {
        return sprite1;
    }
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
}
