package com.example.dungeongame.model;

import android.content.Context;

public class BossFactory extends EnemyFactory {
    private Context context;
    public BossFactory(Context context) {
        this.context = context;
    }
    @Override
    //spawns bosses
    public Boss createEnemy() {
        return new Boss(200, 85, User.getInstance().getDifficulty(), context);
    }
}
