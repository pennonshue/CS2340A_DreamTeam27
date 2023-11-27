package com.example.dungeongame.model;

//subject
public interface UserSubject {
    void addObserver(CollisionObserver enemy);
    void removeObserver(CollisionObserver enemy);
    void notifyObserver();
}
