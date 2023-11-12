package com.example.dungeongame.model;

import android.content.Context;

public class BossFactory extends EnemyFactory {
    Context context;
    public BossFactory(Context context) {
        this.context = context;
    }
    @Override
    public Boss createEnemy() {
        return new Boss(200, 150, User.getInstance().getDifficulty(), context);
    }
}
