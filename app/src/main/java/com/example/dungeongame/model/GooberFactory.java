package com.example.dungeongame.model;

import android.content.Context;

public class GooberFactory extends EnemyFactory {
    private Context context;
    public GooberFactory(Context context) {
        this.context = context;
    }
    @Override
    public Goober createEnemy() {
        return new Goober(200, 700, User.getInstance().getDifficulty(), context);
    }
}
