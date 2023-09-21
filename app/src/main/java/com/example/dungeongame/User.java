package com.example.dungeongame;

import android.graphics.Canvas;
import android.view.Display;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

public class User {

    private static String username;
    private static int speed;
    private static int health;

    private float x,y;

    //    private Sprite sprite;
    public User(String username, String sprite, String difficulty, int speed) {

        this.username = username;
        this.x = 30;
        this.y = 100;

        switch (difficulty) {
            case "Easy":
                this.health = 100;
                break;
            case "Medium":
                this.health = 85;
                break;
            case "Hard":
                this.health = 60;
                break;
            default:
                System.out.println("You have entered an invalid difficulty level");
        }
        this.speed = speed;
    }

//    public void draw(Canvas canvas) {
//        sprite.draw
//
//
//    }


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        User.speed = speed;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        User.health = health;
    }

}

