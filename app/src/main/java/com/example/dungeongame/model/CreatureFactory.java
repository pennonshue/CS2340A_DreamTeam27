package com.example.dungeongame.model;

import android.content.Context;

public class CreatureFactory extends EnemyFactory {
    private Context context;
    public CreatureFactory(Context context) {
        this.context = context;
    }
    @Override
    public Creature createEnemy() {
        return new Creature(1201, 401, User.getInstance().getDifficulty(), context);
    }
}
