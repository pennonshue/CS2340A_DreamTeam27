package com.example.dungeongame.model;

public class StrongEnemyFactory extends EnemyFactory {
    public Enemy createEnemy(String enemy) {
        return new StrongEnemy();
    }
}
