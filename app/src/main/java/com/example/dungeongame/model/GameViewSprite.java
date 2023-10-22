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

    private static boolean moveUp;
    private static boolean moveDown;
    private static boolean moveRight;
    private static boolean moveLeft;


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

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(sprite, x, y, null);

    }

    public void moveLeft() {
        if (moveLeft) {
            x -= 30;
        }
    }

    public void moveDown() {
        if (moveDown) {
            y += 30;
            /* System.out.println(x + "," + y);
              if (y > 325) {
                  y = 325;
              }*/
            invalidate();
        }
    }

    public void moveRight() {
        if (moveRight) {
            x += 30;
            /* System.out.println(x + "," + y);
            if (y < 166 && x > 612) {
                x = 612;
            } else if (y > 166 && x > 492) {
                x = 492;
            } */
            invalidate();
        }
    }

    public void moveUp() {
        // if (moveUp) {
        y -= 50;
        /* System.out.println(x + "," + y);
            if (y < 90) {
                y = 90;
            } */
        invalidate();

    }

    // Setters for the movement flags
    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
        System.out.println("UPPPPPPP");
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }
}

