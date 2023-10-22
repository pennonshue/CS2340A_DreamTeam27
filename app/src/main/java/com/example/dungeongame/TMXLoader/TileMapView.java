package com.example.dungeongame.TMXLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.dungeongame.model.GameViewSprite;
import com.example.dungeongame.model.User;
import com.example.dungeongame.views.GameScreen;

public class TileMapView extends View {

    private TileMapData tileMap;
    private Paint paint;
    Bitmap tilemapBitmap;
    private Bitmap userSprite;

    public TileMapView(Context context) {
        super(context);
        userSprite = User.getSprite1();
        TileMapData t = TMXLoader.readTMX("Map1.tmx", context);
        tilemapBitmap = TMXLoader.createBitmap(t, context, 0, t.getLayers().size());
//        Bitmap unscaledBitMap = TMXLoader.createBitmap(t, context, 0, t.getLayers().size());
//        int newWidth = (tilemapBitmap.getWidth() * 1); // Replace '2' with the scaling factor you want
//        int newHeight = (tilemapBitmap.getHeight() * 1); // Replace '2' with the scaling factor you want
//        tilemapBitmap = Bitmap.createScaledBitmap(unscaledBitMap,  newWidth, newHeight, true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(tilemapBitmap, 0, 0, null);
        canvas.drawBitmap(userSprite, 20, 20, null);
    }
}



