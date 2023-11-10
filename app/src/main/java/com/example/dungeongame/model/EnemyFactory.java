package com.example.dungeongame.model;

public abstract class EnemyFactory {

    public Enemy generateEnemy() {
        Enemy enemy = createEnemy();
        return enemy;
    }
    public abstract Enemy createEnemy();
}
