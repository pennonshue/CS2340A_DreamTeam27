package com.example.dungeongame.model;

import android.content.Context;

public class PurpleManFactory extends EnemyFactory{
    Context context;
    public PurpleManFactory(Context context) {
        this.context = context;
    }
    @Override
    public PurpleMan createEnemy() {
        return new PurpleMan(200, 200, "Easy", context);
    }
}
