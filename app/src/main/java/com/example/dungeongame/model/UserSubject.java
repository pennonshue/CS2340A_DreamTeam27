package com.example.dungeongame.model;

import java.util.List;

//subject
public interface UserSubject {
    void addObserver(CollisionObserver enemy);
    void removeObserver(CollisionObserver enemy);
    void notifyObserver();
}
