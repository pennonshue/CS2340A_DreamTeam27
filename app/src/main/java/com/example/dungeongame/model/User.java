package com.example.dungeongame.model;

public class User {


    private static User userInstance = null;

    private static String username;


    private static int score;
    private static int speed;
    private static int health;

    private static int sprite;
    private static String difficulty;




    public static User getInstance(String username, int sprite, String difficulty, int speed) {
        if (userInstance == null) {
            userInstance = new User(username, sprite, difficulty, speed);
        }
        return userInstance;
    }

    private User(String username, int sprite, String difficulty, int speed) {
        this.difficulty = difficulty;
        this.username = username;
        this.score = 0;

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
        this.sprite = sprite;
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

    public static int getSprite() {
        return sprite;
    }

    public static void setSprite(int sprite) {
        User.sprite = sprite;
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

    public static String getDifficulty() {
        return difficulty;
    }

}

