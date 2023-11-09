package com.example.dungeongame.model;

public class BossEnemy extends Enemy {
    public void attack() {
        System.out.println("implementing boss attack");
    }

    BossEnemy() {
        health = 20;
    }
}