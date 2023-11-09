package com.example.dungeongame.model;

public class BossEnemyFactory extends EnemyFactory {
//    public Enemy createEnemy() {
//        switch () {
//            case "Easy":
//                return new
//            case "Medium":
//                this.health = 85;
//                this.movementStrategy = new RunStrategy();
//                break;
//            case "Hard":
//                this.health = 60;
//                this.movementStrategy = new JogStrategy();
//                break;
//            default:
//                System.out.println("You have entered an invalid difficulty level");
//                break;
//        }
//
//    }
    public Enemy createEnemy(String enemy) {
        return new BossEnemy();
    }
}
