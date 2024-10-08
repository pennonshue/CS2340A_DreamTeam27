package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class Creature extends View implements Enemy, CollisionObserver  {
    private int sprite;
    private static Bitmap sprite1;
    private static Bitmap sprite2;

    private int speed;
    private String enemySize;
    private int health;
    private float x;
    private float y;
    private static String difficulty;
    private boolean down = true;
    private int attack;


    private boolean collision = false;
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
            this.attack = 5;
            //this.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            this.health = 10;
            this.attack = 10;
            //this.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            this.health = 15;
            this.attack = 10;
            //this.movementStrategy = new JogStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
            break;
        }
        this.sprite = R.drawable.panda;
        float scaleX = 2.5f;
        float scaleY = 2.5f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 5, 0, 80,
                90, matrix, true);
    }
    public void update() {
        if (!collision) {
            if (down) {
                y += speed;
                if (y >= 600) {
                    down = false;
                }
            } else {
                y -= speed;
                if (y <= 100) {
                    down = true;
                }
            }

        }
    }

    public boolean getCollision() {
        return collision;
    }

    @Override
    public void setCollision() {
        collision = !collision;

    }
    //if collision, decrement user health, if creature health <= 0, remove enemy from observer list
    @Override
    public void notifyCollision() {
        if (User.getInstance().getX() == x && User.getInstance().getY() == y) {
            User.setHealth(User.getHealth() - 10);
        }
        if (health <= 0) {
            User.getInstance().removeObserver(this);
        }
    }


    //All getters
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
    public float getX() {
        return x;
    }
    public int getAttack() {
        return attack;
    }
    public float getY() {
        return y;
    }
    public String getDifficulty() {
        return difficulty;
    }
}