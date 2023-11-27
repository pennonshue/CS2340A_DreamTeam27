package com.example.dungeongame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Player;


import org.junit.Test;

public class Sprint4JUnits {
    //Aidan Tests
    @Test
    public void changeHealth() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.setHealth(Player.getHealth() - 1);
        assertEquals(Player.getHealth(), 99);
    }
    @Test
    public void resetPlayer() {
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.resetPlayer();
        assertEquals(Player.getInstance(), null);
    }
    @Test
    public void PlayerHealthNoNegative() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.setHealth(Player.getHealth() - 101);
        assertEquals(Player.getHealth(), 0);
    }
    @Test
    public void checkScoreWhenDie() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.setHealth(Player.getHealth() - 101);
        assertEquals(Player.getScore(), 0);
    }
    @Test
    public void DifficultyEasyDamage() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.collisionDamage();
        assertEquals(Player.getHealth(), 90);
    }
    @Test
    public void DifficultyMedDamage() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Medium");
        Player.collisionDamage();
        assertEquals(Player.getHealth(), 70);
    }
    @Test
    public void DifficultyHardDamage() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Hard");
        Player.collisionDamage();
        assertEquals(Player.getHealth(), 40);
    }
    @Test
    public void CheckScoreNoDie() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.setHealth(Player.getHealth() - 50);
        assertEquals(Player.getScore(), 20);
    }
    @Test
    public void checkCollisionTrue() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        assertTrue(Player.ifCollide(100,100));
    }
    @Test
    public void checkCollisionFalse() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        assertEquals(Player.ifCollide(50,50),false);
    }
    @Test
    public void checkCollisionCauseDamageTrue() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.ifCollide(100, 100);
        assertEquals(Player.getHealth(), 90);
    }
    @Test
    public void checkCollisionCauseDamageFalse() {
        Player.resetPlayer();
        Player player1 = Player.getInstance("Steve", 1, "Easy");
        Player.ifCollide(99, 100);
        assertEquals(Player.getHealth(), 100);
    }

}
