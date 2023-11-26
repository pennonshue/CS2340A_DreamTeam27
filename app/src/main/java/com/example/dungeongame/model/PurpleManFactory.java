package com.example.dungeongame.model;

import android.content.Context;

public class PurpleManFactory extends EnemyFactory{
    Context context;
    public PurpleManFactory(Context context) {
        this.context = context;
    }
    @Override
    //spawns purplemen
    public PurpleMan createEnemy() {
        return new PurpleMan(200, 70, User.getInstance().getDifficulty(), context);
    }
}
