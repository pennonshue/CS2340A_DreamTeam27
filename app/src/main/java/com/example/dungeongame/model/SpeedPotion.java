package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;


import com.example.dungeongame.R;


public class SpeedPotion extends View implements Potion {

    private int sprite;
    private float x;
    private float y;
    private String difficulty;
    private Bitmap sprite1;
    public SpeedPotion(Context context) {
        super(context);
        x = 500;
        y = 200;
        this.sprite = R.drawable.potions;
        float scaleX = 1.5f;
        float scaleY = 1.5f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 80, 130, 50, 46, matrix, true);
    }
    public void powerUp() {
        MovementStrategy ms = new SprintStrategy();
        User.getInstance().setMovementStrategy(ms);
        System.out.println("speeding");
    }
    public Bitmap getSprite1() {
        return sprite1;
    }

    @Override
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
