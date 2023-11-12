package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

import java.util.List;

public class Necromancer extends View implements Enemy {
    public void attack() {
        System.out.println("implement a strong attack");
    }
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
        speed = 3;
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
        float scaleX = 1.1f;
        float scaleY = 1.1f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite = R.drawable.necromancer;
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 90, 70, 200,
                400, matrix, true);
    }

    //    public static com.example.dungeongame.model.Enemy getInstance(float x, float y, String difficulty) {
//        if (enemyInstance == null) {
//            enemyInstance = new Knight(50, 50, difficulty);
//        }
//        return enemyInstance;
//    }
//    public List<Bitmap> enemies(List<Bitmap> enemies) {
//        enemies.add(sprite1);
//        return enemies;
//    }
//    public List<Enemy> enemies(List<Enemy> enemies) {
//        enemies.add(Creature.getInstance(x, y, difficulty));
//        return enemies;
//    }
    public void update() {
        if (x < 2500 && right) {
            x+=speed;
            if (x >= 2500) {
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
//    public int getSpeed() {
//        return speed;
//    }

    public int getSprite() {
        return sprite;
    }

    //    public int getSize() {
//        return size;
//    }
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
