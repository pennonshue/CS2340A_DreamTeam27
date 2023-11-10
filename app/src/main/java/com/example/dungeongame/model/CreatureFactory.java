package com.example.dungeongame.model;

import android.content.Context;

public class CreatureFactory extends EnemyFactory {
    Context context;
    public CreatureFactory(Context context) {
        this.context = context;
    }
    @Override
    public Creature createEnemy() {
        return new Creature(200, 200, "Easy", context);
    }
}