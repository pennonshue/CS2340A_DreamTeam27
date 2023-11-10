
package com.example.dungeongame.model;
public class Player {

    private static com.example.dungeongame.model.Player userInstance = null;

    private static String username;
    private static MovementStrategy movementStrategy;

    private static int score;
    private static int speed;
    private static int health;
    private static int sprite;
    private static String difficulty;
    private static boolean win;

    private static int room;


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
        this.room = 0;

        switch (difficulty) {
        case "Easy":
            this.health = 100;
            this.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            this.health = 85;
            this.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            this.health = 60;
            this.movementStrategy = new JogStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
            break;
        }
        this.speed = speed;
        this.sprite = sprite;
    }
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
    public static MovementStrategy getMovementStrategy() {
        return movementStrategy;
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

    public static void setRoom(int room) {
        if (room <= 3) {
            com.example.dungeongame.model.Player.score = room;
        }
    }

    public static void setDifficulty(String difficulty) {
        switch (difficulty) {
        case "Easy":
            Player.health = 100;
            Player.movementStrategy = new RunStrategy();
            break;
        case "Medium":
            Player.health = 85;
            Player.movementStrategy = new RunStrategy();
            break;
        case "Hard":
            Player.health = 60;
            Player.movementStrategy = new JogStrategy();
            break;
        default:
            System.out.println("You have entered an invalid difficulty level");
        }

    }

}

    