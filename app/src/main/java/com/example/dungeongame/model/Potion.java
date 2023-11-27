package com.example.dungeongame.model;

import android.graphics.Bitmap;

//Adding Potion
public interface Potion {
    float getX();
    float getY();
    Bitmap getSprite1();

    void powerUp();
}
