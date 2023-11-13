package com.example.dungeongame.model;

import android.content.Context;

public class NecromancerFactory extends EnemyFactory {
    private Context context;
    public NecromancerFactory(Context context) {
        this.context = context;
    }
    @Override
    public Necromancer createEnemy() {
        return new Necromancer(300, 300, User.getInstance().getDifficulty(), context);
    }
}
