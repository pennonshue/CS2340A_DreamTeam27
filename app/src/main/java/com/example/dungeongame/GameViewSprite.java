package com.example.dungeongame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;

public class GameViewSprite extends View {

    private Bitmap sprite;
    private static int spriteNumber;


    public GameViewSprite(Context context, int num) {
        super(context);

        switch (num) {
        case (1):
            this.spriteNumber = R.drawable.sprite_1;
            break;
        case (2):
            this.spriteNumber = R.drawable.sprite_2;
            break;
        case (3):
            this.spriteNumber = R.drawable.sprite_3;
            break;
        default:
            break;

        }

        sprite = BitmapFactory.decodeResource(getResources(), this.spriteNumber);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float scaleX = 0.4f; // Adjust this value as needed
        float scaleY = 0.4f; // Adjust this value as needed

        // Create a Matrix to apply scaling
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);

        // Create a scaled version of your sprite bitmap
        Bitmap scaledSprite = Bitmap.createBitmap(sprite, 0, 0, sprite.getWidth(),
                sprite.getHeight(), matrix, true);


        // Draw the sprite on the canvas
        canvas.drawBitmap(scaledSprite, 200, 200, null);
    }
}

