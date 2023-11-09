package com.example.dungeongame.model;

import android.graphics.Bitmap;

import java.util.List;

public abstract class Enemy {
    abstract int getSprite();
    abstract Bitmap getSprite1();
//    int getSpeed();
//    int getSize();
    abstract int getHealth();
    abstract float getX();
    abstract float getY();
    abstract void update(float x, float y);
    List<Enemy> enemies;
//    private MovementStrategy movementStrategy;
//    private int x;
//    private int y;
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
    private int currentFrame;
//    private int damage;
//    private int path;
//
    List<Bitmap> sprites;

//    public Enemy(List<Bitmap> sprites) {
//        this.sprites = sprites;
//        this.currentFrame = 0;
//    }
    public Enemy() {
        currentFrame = 0;
    }
    public Bitmap getCurrentSprite() {
        return sprites.get(currentFrame);
    }

    public void update() {
        currentFrame = (currentFrame + 1) % sprites.size();
    }
}
