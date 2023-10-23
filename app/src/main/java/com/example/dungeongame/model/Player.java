
package com.example.dungeongame.model;
public class Player {

    private static com.example.dungeongame.model.Player userInstance = null;

    private static String username;


    private static int score;
    private static int speed;
    private static int health;
    private static int sprite;
    private static String difficulty;
    private static boolean win;




    public static com.example.dungeongame.model.Player getInstance(String username, int sprite,
                                                                   String difficulty, int speed) {
        if (userInstance == null) {
            userInstance = new com.example.dungeongame.model.Player(username, sprite,
                    difficulty, speed);
        }
        return userInstance;
    }

    private Player(String username, int sprite, String difficulty, int speed) {
        this.difficulty = difficulty;
        this.username = username;
        this.score = 20;
        this.win = true;

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
        com.example.dungeongame.model.Player.username = username;
    }

    public static int getSprite() {
        return sprite;
    }
    public static void setSprite(int sprite) {
        com.example.dungeongame.model.Player.sprite = sprite;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        com.example.dungeongame.model.Player.speed = speed;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
        if (health <= 0) {
            win = false;
            setScore(0);
        } else {
            win = true;
        }
    }
    public static boolean getWin() {
        return win;
    }

    public static String getDifficulty() {
        return difficulty;
    }
    public static int getScore() {
        return score;
    }
    public static void setScore(int score) {
        if (score < 0) {
            com.example.dungeongame.model.Player.score = 0;
        } else {
            com.example.dungeongame.model.Player.score = score;
        }
    }


    public static void setDifficulty(String difficulty) {
        switch (difficulty) {
        case "Easy":
            com.example.dungeongame.model.Player.health = 100;
            break;
        case "Medium":
            com.example.dungeongame.model.Player.health = 85;
            break;
        case "Hard":
            com.example.dungeongame.model.Player.health = 60;
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
        }

    }

}

    