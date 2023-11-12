package com.example.dungeongame.model;
//subject
public interface UserObserver {
    void addObserver(CollisionObserver enemy);
    void removeObserver(CollisionObserver enemy);
    void notifyObserver();
}
