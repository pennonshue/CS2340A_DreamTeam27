package com.example.dungeongame.model;

import android.content.Context;

public class KnightFactory extends EnemyFactory {
    Context context;
    public KnightFactory(Context context) {
        this.context = context;
    }
    @Override
    //spawns knights
    public Knight createEnemy() {
        return new Knight(300, 100, User.getInstance().getDifficulty(), context);
    }
}
