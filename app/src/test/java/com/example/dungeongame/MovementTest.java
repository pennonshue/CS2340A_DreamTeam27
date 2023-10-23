package com.example.dungeongame;

import android.content.Context;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeongame.model.GameViewSprite;
import com.example.dungeongame.model.Player;


public class MovementTest {
    private GameViewSprite gameViewSprite;
    private Context context;



    //    @Before
//    public void setUp() {
//        context = new GameScreen();
//        gameViewSprite = new GameViewSprite(context, 1);
//    }
    @Test
    public void testMoveUp() {
        float initialY = 0;
        float newY = GameViewSprite.getMoveUp(initialY);
        assertEquals(initialY - 50, newY, 0.01); // Check if the Y-coordinate has been decreased by 50
    }

    @Test
    public void testMoveDown() {
        float initialY = 0;
        float newY = GameViewSprite.getMoveDown(initialY);
        assertEquals(initialY + 30, newY, 0.01); // Check if the Y-coordinate has been increased by 30
    }

    @Test
    public void testMoveLeft() {
        float initialX = 0;
        float newX = GameViewSprite.getMoveLeft(initialX);
        assertEquals(initialX - 30, newX, 0.01); // Check if the X-coordinate has been decreased by 30
    }

    @Test
    public void testMoveRight() {
        float initialX = 0;
        float newX = GameViewSprite.getMoveRight(initialX);
        assertEquals(initialX + 30, newX, 0.01); // Check if the X-coordinate has been increased by 30
    }

    @Test
    public void easyStrategyTest() {
        Player testPlayer = Player.getInstance("Test", 1, "Easy", 5);
        assertEquals(20, testPlayer.getMovementStrategy().movementSpeed());
    }

    @Test
    public void mediumStrategyTest() {
        Player testPlayer = Player.getInstance("Test", 1, "Medium", 5);
        assertEquals(20, testPlayer.getMovementStrategy().movementSpeed());
    }


    @Test
    public void hardStrategyTest() {
        Player testPlayer = Player.getInstance("Test", 1, "Hard", 5);
        testPlayer.setDifficulty("Hard");
        assertEquals(5, testPlayer.getMovementStrategy().movementSpeed());
    }


}

