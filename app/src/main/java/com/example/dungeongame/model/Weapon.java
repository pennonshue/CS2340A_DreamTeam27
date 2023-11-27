package com.example.dungeongame.model;

import android.graphics.Bitmap;

public interface Weapon {
    Bitmap getSprite();
    void setX(int x);
    void setY(int y);
    float getX();
    float getY();

}
