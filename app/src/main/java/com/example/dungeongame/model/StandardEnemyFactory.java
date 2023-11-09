package com.example.dungeongame.model;

import android.text.Spannable;

public class StandardEnemyFactory extends EnemyFactory {
    public Enemy createEnemy(String enemy) {

        return new StandardEnemy();
    }
}
