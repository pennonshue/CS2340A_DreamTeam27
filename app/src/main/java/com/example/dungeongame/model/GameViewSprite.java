package com.example.dungeongame.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;

import com.example.dungeongame.R;

public class GameViewSprite extends View {

    private Bitmap sprite;
    private static int spriteNumber;
    private int x = 100;

    private int y = 100;


    public GameViewSprite(Context context, int num) {
        super(context);

        switch (num) {
        case (1):
            this.spriteNumber = R.drawable.sprite_1;
            sprite = BitmapFactory.decodeResource(getResources(), this.spriteNumber);

            break;
        case (2):
            this.spriteNumber = R.drawable.sprite_2;
            sprite = BitmapFactory.decodeResource(getResources(), this.spriteNumber);

            break;
        case (3):
            this.spriteNumber = R.drawable.sprite_3;
            sprite = BitmapFactory.decodeResource(getResources(), this.spriteNumber);
            break;
        default:
            break;
        }
        float scaleX = 0.15f;
        float scaleY = 0.15f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        sprite = Bitmap.createBitmap(sprite, 0, 0, sprite.getWidth(),
                sprite.getHeight(), matrix, true);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    //getting coordinates

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(sprite, x, y, null);
    }

    public static float getMoveUp(float y) {
        y -= 50;
        return y;
    }

    public static float getMoveDown(float y) {
        y += 30;
        return y;
    }

    public static float getMoveRight(float x) {
        x += 30;
        return x;
    }
    //move right

    public static float getMoveLeft(float x) {
        x -= 30;
        return x;
    }
}

