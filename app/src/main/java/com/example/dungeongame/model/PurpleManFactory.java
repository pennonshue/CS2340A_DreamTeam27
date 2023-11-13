package com.example.dungeongame.model;

import android.content.Context;

public class PurpleManFactory extends EnemyFactory {
    private Context context;
    public PurpleManFactory(Context context) {
        this.context = context;
    }
    @Override
    public PurpleMan createEnemy() {
        return new PurpleMan(200, 70, User.getInstance().getDifficulty(), context);
    }
}
