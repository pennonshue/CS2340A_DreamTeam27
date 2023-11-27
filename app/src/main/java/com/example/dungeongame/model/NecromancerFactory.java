package com.example.dungeongame.model;

import android.content.Context;

public class NecromancerFactory extends EnemyFactory {
    private Context context;
    public NecromancerFactory(Context context) {
        this.context = context;
    }
    @Override
    //spawns necromancers
    public Necromancer createEnemy() {
        return new Necromancer(300, 240, User.getInstance().getDifficulty(), context);
    }
}
