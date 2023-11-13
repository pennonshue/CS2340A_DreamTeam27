package com.example.dungeongame.model;

import android.graphics.Bitmap;

import java.util.List;

public interface Enemy {
    int getSprite();
    Bitmap getSprite1();
//    abstract static Bitmap getSprite1();
//    int getSpeed();
//    int getSize();
    int getHealth();
    float getX();
    float getY();
    void update();
    public int getAttack();
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
//    private int currentFrame;
//    private int damage;
//    private int path;
//
//    public Bitmap getCurrentSprite() {
//        return sprites.get(currentFrame);
//    }
//
//    public void update() {
//        currentFrame = (currentFrame + 1) % sprites.size();
//    }
}
