package com.example.dungeongame.model;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.dungeongame.R;

import java.util.ArrayList;
import java.util.List;

public class Devil extends Enemy {


    public Devil(Context context) {
        super(loadDevilSprites(context));

    }



    private static List<Bitmap> loadDevilSprites(Context context) {
        List<Bitmap> walkingSprites = new ArrayList<Bitmap>();
        Rect spriteRect = new Rect(0, 374, 112, 490);
        Bitmap spriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy_sprite);
        Bitmap walking1 = Bitmap.createBitmap(spriteSheet, spriteRect.left, spriteRect.top, spriteRect.width(), spriteRect.height());
        Bitmap walking2 = Bitmap.createBitmap(spriteSheet, 195, 374, 130, spriteRect.height());
        Bitmap walking3 = Bitmap.createBitmap(spriteSheet, 300, 374, 130, 116);
        Bitmap walking4 = Bitmap.createBitmap(spriteSheet, 410, 374 , spriteRect.width(), spriteRect.height());
        walkingSprites.add(walking1);
        walkingSprites.add(walking2);
        walkingSprites.add(walking3);
        walkingSprites.add(walking4);
        return  walkingSprites;
    }



}
