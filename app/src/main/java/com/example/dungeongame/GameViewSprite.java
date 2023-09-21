package com.example.dungeongame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class GameViewSprite extends View {

    private Bitmap sprite;


    public GameViewSprite(Context context) {
        super(context);

        sprite = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_1);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the sprite on the canvas
        canvas.drawBitmap(sprite, 20, 20, null);
    }
}

