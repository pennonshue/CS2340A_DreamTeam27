package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class Boss extends View implements Enemy, CollisionObserver  {
    private int sprite;
    private static Bitmap sprite1;
    private static Bitmap sprite2;

    private int speed;

    private boolean collision = false;
    private String enemySize;
    private int health;
    private float x;
    private float y;
    private static String difficulty;
    private boolean right = true;
    public Boss(float x, float y, String difficulty, Context context) {
        super(context);
        //super(sprites);
        speed = 9;
        enemySize = "Small";
        health = 40;
        this.x = x;
        this.y = y;

        // changes boss settings based on difficulty selected
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
        float scaleX = 2.4f;
        float scaleY = 2.4f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        //yes
        sprite1 = Bitmap.createBitmap(sprite1, 710, 260,
                75, 90, matrix, true);
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
            User.setHealth(User.getHealth() - 45);
        }
        if (health <= 0) {
            User.getInstance().removeObserver(this);
        }
    }
    public int getSpeed() {
        return speed;
    }
    //my commit>2
    @Override
    public Bitmap getSprite1() {
        return sprite1;
        //this returns sprite
    }

    @Override
    public Bitmap getSprite2() {
        return sprite2;
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
    public int getAttack() {
        return 20;
    }
    //hello2
    @Override
    public boolean getCollision() {
        return collision;
    }
    //hello
    @Override
    public void setCollision() {
        collision = !collision;

    }

    public float getY() {
        return y;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
    //me