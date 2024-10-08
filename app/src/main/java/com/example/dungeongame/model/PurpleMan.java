package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class PurpleMan extends View implements Enemy, CollisionObserver {
    private int sprite;
    private static Bitmap sprite1;
    private static Bitmap sprite2;

    private int speed;
    private int attack;
    private String enemySize;

    public void setCollision() {
        collision = !collision;
    }

    public boolean getCollision() {
        return collision;
    }

    private boolean collision = false;
    private int health;
    private float x;
    private float y;
    private static String difficulty;
    private boolean right = true;
    public PurpleMan(float x, float y, String difficulty, Context context) {
        super(context);
        User.getInstance().addObserver(this);
        speed = 8;
        enemySize = "Small";
        health = 5;
        this.x = x;
        this.y = y;
        // changes purple man settings based on difficulty selected
        switch (difficulty) {
        case "Easy":
            this.health = 5;
            this.attack = 2;
            //this.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            this.health = 10;
            this.attack = 5;
            //this.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            this.health = 15;
            this.attack = 8;
            //this.movementStrategy = new JogStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
            break;
        }
        this.sprite = R.drawable.creatures;
        float scaleX = 1.0f;
        float scaleY = 1.0f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 360, 355, 75, 80, matrix, true);
        System.out.println("Creature made");
    }
    public void update() {
        if (!collision) {
            if (x < 1900 && right) {
                x += speed;
                if (x >= 1900) {
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
    }
    //if collision, decrement user health, if creature health <= 0, remove enemy from observer list
    @Override
    public void notifyCollision() {
        if (User.getInstance().getX() == x && User.getInstance().getY() == y) {
            User.setHealth(User.getHealth() - 30);
        }
        if (health <= 0) {
            User.getInstance().removeObserver(this);
        }
    }
    public int getSpeed() {
        return speed;
    }
    @Override
    public Bitmap getSprite1() {
        return sprite1;
    }

    @Override
    public Bitmap getSprite2() {
        return sprite2;
    }

    public int getSprite() {
        return sprite;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
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

