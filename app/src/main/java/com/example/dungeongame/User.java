package com.example.dungeongame;

public class User {

    public static String username;

    public static int speed;
    public static int health;
    public User(String username, int health, int speed) {

        this.username = username;
        this.health = health;
        this.speed = speed;
    }


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
