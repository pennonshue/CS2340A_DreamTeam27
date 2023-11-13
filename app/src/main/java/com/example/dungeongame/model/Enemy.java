package com.example.dungeongame.model;

import android.graphics.Bitmap;


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

    boolean getCollision();

    void setCollision();

}
