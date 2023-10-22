package com.example.dungeongame.model;

public interface MovementStrategy {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class WalkStrategy implements MovementStrategy {

    @Override
    public void moveUp() {
        User.getInstance().updatePosition((int) User.getInstance().getX(), (int) User.getInstance().getY() - 20);
    }

    @Override
    public void moveDown() {
        User.getInstance().updatePosition((int) User.getInstance().getX(), (int) User.getInstance().getY() + 20);
    }

    @Override
    public void moveLeft() {
        User.getInstance().updatePosition((int) User.getInstance().getX() - 10, (int) User.getInstance().getY());
    }

    @Override
    public void moveRight() {
        User.getInstance().updatePosition((int) User.getInstance().getX() + 10, (int) User.getInstance().getY());
    }
}
