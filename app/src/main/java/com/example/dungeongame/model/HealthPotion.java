package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class HealthPotion extends View implements Potion {
    private int sprite;
    private float x;
    private float y;
    private String difficulty;
    private Bitmap sprite1;
    public HealthPotion(Context context) {
        super(context);
        x = 500;
        y = 500;
        this.sprite = R.drawable.potions;
        float scaleX = 1.5f;
        float scaleY = 1.5f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 180, 87, 50, 46, matrix, true);
    }
    public void powerUp() {
        User.getInstance().setHealth(User.getInstance().getHealth() + 200);
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
