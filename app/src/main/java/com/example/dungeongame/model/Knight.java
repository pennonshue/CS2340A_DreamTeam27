package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;
public class Knight extends View implements Enemy, CollisionObserver {
    public void attack() {
        System.out.println("implement a strong attack");
    }


    public void setCollision() {
        collision = !collision;
    }

    public boolean getCollision() {
        return collision;
    }

    private boolean collision = false;
    private int sprite;
    private String difficulty;
    private Bitmap sprite1;
    private int speed;
    private String enemySize;
    private int health;
    private float x = 70;
    private float y = 85;

    private boolean down = true;
    public Knight(float x, float y, String difficulty, Context context) {
        super(context);
        User.getInstance().addObserver(this);
        speed = 16;
        enemySize = "Large";
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
        float scaleX = 1.5f;
        float scaleY = 1.5f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite = R.drawable.knight_attack;
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 70, 85, 100,
                119, matrix, true);
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

    //if collision, decrement user health, if creature health <= 0, remove enemy from observer list
    @Override
    public void notifyCollision() {
        if (User.getInstance().getX() < (x + 20) && User.getInstance().getX() > (x - 20)
                && User.getInstance().getY() < (y + 10) && User.getInstance().getY() > (y - 10)) {
            User.setHealth(User.getHealth() - 10);
        }
        if (health <= 0) {
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
    public int getAttack() {
        return 5;
    }

}