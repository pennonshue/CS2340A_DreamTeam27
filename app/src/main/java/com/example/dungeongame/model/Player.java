
package com.example.dungeongame.model;
public class Player {

    private static com.example.dungeongame.model.Player userInstance = null;

    private static String username;
    private static MovementStrategy movementStrategy;

    private static int score;
    private static int health;
    private static int sprite;
    private static String difficulty;
    private static boolean win;

    private static int room;
    private static int x = 100;
    private static int y = 100;


    public static com.example.dungeongame.model.Player getInstance(String username, int sprite,
                                                                   String difficulty) {
        if (userInstance == null) {
            userInstance = new com.example.dungeongame.model.Player(username, sprite,
                    difficulty);
        }
        return userInstance;
    }

    private Player(String username, int sprite, String difficulty) {
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


    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
        if (health <= 0) {
            win = false;
            setScore(0);
            Player.health = 0;
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
    public static Player getInstance() {
        return userInstance;
    }

    public static void resetPlayer() {
        userInstance = null;
    }
    public static void collisionDamage() {
        if (difficulty == "Hard") {
            Player.setHealth(Player.getHealth() - 20);
        } else if (difficulty == "Medium") {
            Player.setHealth(Player.getHealth() - 15);
        } else {
            Player.setHealth(Player.getHealth() - 10);
        }
    }
    public static boolean ifCollide(int x, int y) {
        if (Player.x == x && Player.y == y) {
            collisionDamage();
            return true;
        }
        return false;
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

    