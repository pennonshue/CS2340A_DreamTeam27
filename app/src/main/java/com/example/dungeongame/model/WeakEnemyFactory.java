package com.example.dungeongame.model;

public class WeakEnemyFactory extends EnemyFactory {
    public Enemy createEnemy(String enemy) {
        return new WeakEnemy();
    }
}
