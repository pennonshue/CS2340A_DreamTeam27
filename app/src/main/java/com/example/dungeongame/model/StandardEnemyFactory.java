package com.example.dungeongame.model;

import android.text.Spannable;

public class StandardEnemyFactory extends Spannable.Factory {
    public Enemy createEnemy(String enemy) {

        return new StandardEnemy();
    }
}
