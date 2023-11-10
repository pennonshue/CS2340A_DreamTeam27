package com.example.dungeongame.model;

import android.content.Context;

public class KnightFactory extends EnemyFactory {
    Context context;
    public KnightFactory(Context context) {
        this.context = context;
    }
    @Override
    public Knight createEnemy() {
        return new Knight(100, 200, User.getInstance().getDifficulty(), context);
    }
}
