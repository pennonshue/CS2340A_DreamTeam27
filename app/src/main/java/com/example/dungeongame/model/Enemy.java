package com.example.dungeongame.model;

import android.graphics.Bitmap;

import java.util.List;

public abstract class Enemy {
    private MovementStrategy movementStrategy;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int currentFrame;
    private int damage;
    private int path;

    private List<Bitmap> sprites;


    public Enemy(List<Bitmap> sprites) {
        this.sprites = sprites;
        this.currentFrame = 0;
    }

    public Bitmap getCurrentSprite() {
        return sprites.get(currentFrame);
    }

    public void update() {
        currentFrame = (currentFrame + 1) % sprites.size();
    }



}
