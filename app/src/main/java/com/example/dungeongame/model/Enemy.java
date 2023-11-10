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
}
