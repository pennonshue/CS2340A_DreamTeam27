package com.example.dungeongame.model;

public abstract class EnemyFactory {
    String difficulty;
    public Enemy manufactorEnemy(String type) {
        Enemy enemy;

        enemy = createEnemy(type);
        //add enemy methods here
        return enemy;
    }

    abstract Enemy createEnemy(String type);
}
