package com.example.dungeongame.model;

import androidx.lifecycle.Observer;

import java.util.List;

//subject
public interface UserObserver {
    List<CollisionObserver> enemies;
    void addObserver(CollisionObserver enemy);
    void removeObserver(CollisionObserver enemy);
    void notifyObserver();
}
