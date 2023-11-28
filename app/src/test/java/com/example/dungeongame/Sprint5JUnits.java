package com.example.dungeongame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Player;


import org.junit.Test;

public class Sprint5JUnits {
    //Aidan Tests
    @Test
    public void checkDecreaseScore() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.decreaseScore(10);
        assertEquals(Player.getScore(), 10);
    }
    @Test
    public void checkNoNegativeScore() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.decreaseScore(30);
        assertEquals(Player.getScore(), 0);
    }
    @Test
    public void checkZeroScore() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.decreaseScore(20);
        assertEquals(Player.getScore(), 0);
    }
    @Test
    public void checkIncreaseScore() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.increaseScore(10);
        assertEquals(Player.getScore(), 30);
    }
    @Test
    public void multipleScoreChanges() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.increaseScore(10);
        Player.decreaseScore(40);
        Player.increaseScore(100);
        assertEquals(Player.getScore(), 100);
    }

    @Test
    public void defaultNoWeapon() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        assertEquals(player1.getWeapon(), false);
    }
    @Test
    public void noWeapon() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        player1.setWeapon(true);
        assertEquals(player1.getWeapon(), true);
        player1.setWeapon(false);
        assertEquals(player1.getWeapon(), false);
    }
    @Test
    public void hasWeapon() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        player1.setWeapon(true);
        assertEquals(player1.getWeapon(), true);
    }
    @Test
    public void checkAttack() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        player1.setWeapon(true);
        assertEquals(player1.getWeapon(), true);
        assertEquals(player1.canAttack(100,100), true);
    }
    @Test
    public void checkAttackNotInRange() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        player1.setWeapon(true);
        assertEquals(player1.getWeapon(), true);
        assertEquals(player1.canAttack(120,120), false);
    }
    @Test
    public void checkAttackNoWeapon() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        player1.setWeapon(false);
        assertEquals(player1.getWeapon(), false);
        assertEquals(player1.canAttack(100,100), false);
    }
    @Test
    public void checkAttackNoWeaponAndNoRange() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        player1.setWeapon(false);
        assertEquals(player1.getWeapon(), false);
        assertEquals(player1.canAttack(120,120), false);
    }

}
