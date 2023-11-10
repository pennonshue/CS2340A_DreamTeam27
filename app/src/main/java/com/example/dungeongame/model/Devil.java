//package com.example.dungeongame.model;
//
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Matrix;
//import android.graphics.Rect;
//
//import com.example.dungeongame.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Devil implements Enemy {
//
//
////    public Devil(Context context) {
////        super(loadDevilSprites(context));
////    }
////
////
////
//    private static List<Bitmap> loadDevilSprites(Context context) {
//        List<Bitmap> walkingSprites = new ArrayList<Bitmap>();
//        Rect spriteRect = new Rect(0, 374, 112, 490);
//        Bitmap spriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy_sprite);
//        Bitmap walking1 = Bitmap.createBitmap(spriteSheet, spriteRect.left, spriteRect.top, spriteRect.width(), spriteRect.height());
//        Bitmap walking2 = Bitmap.createBitmap(spriteSheet, 195, 374, 130, spriteRect.height());
//        Bitmap walking3 = Bitmap.createBitmap(spriteSheet, 300, 374, 130, 116);
//        Bitmap walking4 = Bitmap.createBitmap(spriteSheet, 410, 374 , spriteRect.width(), spriteRect.height());
//        walkingSprites.add(walking1);
//        walkingSprites.add(walking2);
//        walkingSprites.add(walking3);
//        walkingSprites.add(walking4);
//        return  walkingSprites;
//    }
////    public List<Bitmap> enemies(List<Bitmap> enemies) {
////        enemies.add(loadDevilSprites(context));
////        return enemies;
////    }
//public void attack() {
//    System.out.println("implement a strong attack");
//}
//    private int sprite;
//    private Bitmap sprite1;
//    private int movementSpeed;
//    private String enemySize;
//    private int health;
//    private float x;
//    private float y;
//    private String difficulty;
//    public Devil(float x, float y, String difficulty) {
//        sprite = R.drawable.creatures;
//        movementSpeed = 25;
//        enemySize = "Medium";
//        if (x < 0) {
//            this.x = 0;
//        } else {
//            this.x = x;
//        }
//        if (y < 0) {
//            this.y = 0;
//        } else {
//            this.y = y;
//        }
//        switch (difficulty) {
//            case "Easy":
//                this.health = 15;
//                //this.movementStrategy = new RunStrategy();
//                break;
//            case "Medium":
//                this.health = 20;
//                //this.movementStrategy = new RunStrategy();
//                break;
//            case "Hard":
//                this.health = 25;
//                //this.movementStrategy = new JogStrategy();
//                break;
//            default:
//                System.out.println("You have entered an invalid difficulty level");
//                break;
//        }
//        float scaleX = 0.15f;
//        float scaleY = 0.15f;
//        Matrix matrix = new Matrix();
//        matrix.postScale(scaleX, scaleY);
//        sprite1 = Bitmap.createBitmap(sprite1, 0, 0, sprite1.getWidth(),
//                sprite1.getHeight(), matrix, true);
//    }
//
////    public static Enemy getInstance(float x, float y, String difficulty) {
////        if (enemyInstance == null) {
////            enemyInstance = new Devil(50, 50, difficulty);
////        }
////        return enemyInstance;
////    }
////    public List<Bitmap> enemies(List<Bitmap> enemies) {
////        enemies.add(sprite1);
////        return enemies;
////    }
//    public void update(float x, float y) {
//        if (x < 0) {
//            this.x = 0;
//        } else {
//            this.x = x;
//        }
//        if (y < 0) {
//            this.y = 0;
//        } else {
//            this.y = y;
//        }
//    }
////    public int getSpeed() {
////        return speed;
////    }
//    public int getSprite() {
//        return sprite;
//    }
////    public int getSize() {
////        return size;
////    }
//    public Bitmap getSprite1() {
//    return sprite1;
//}
//    @Override
//    public float getX() {
//        return x;
//    }
//    public float getY() {
//        return y;
//    }
//    public int getHealth() {
//        return health;
//    }
//}
