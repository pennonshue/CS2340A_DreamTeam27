package com.example.dungeongame.model;

import com.example.dungeongame.R;

public class Creature implements Enemy {
    public void attack() {
        System.out.println("implement a strong attack");
    }
    private int sprite;
    private int speed;
    private String enemySize;
    private int health;
    private float x;
    private float y;
    private static String difficulty;
    private static com.example.dungeongame.model.Enemy enemyInstance = null;
    public Creature(float x, float y, String difficulty) {
        sprite = R.drawable.creatures;
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
    }

    public static com.example.dungeongame.model.Enemy getInstance(float x, float y, String difficulty) {
        if (enemyInstance == null) {
            enemyInstance = new Creature(50, 50, difficulty);
        }
        return enemyInstance;
    }

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