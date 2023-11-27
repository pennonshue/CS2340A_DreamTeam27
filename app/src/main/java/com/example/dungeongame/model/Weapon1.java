package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class Weapon1 extends View  implements Weapon{
    int sprite;
    private int x;
    private int y;
    private String difficulty;
    private Bitmap sprite1;

    public Weapon1(Context context) {
        super(context);
        this.sprite = R.drawable.weapon1;
        float scaleX = 0.7f;
        float scaleY = 0.7f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite1 = BitmapFactory.decodeResource(getResources(), this.sprite);
        sprite1 = Bitmap.createBitmap(sprite1, 0, 0, sprite1.getWidth(), sprite1.getHeight(), matrix, true);
    }


    @Override
    public Bitmap getSprite() {
        return sprite1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
