package com.example.dungeongame;

import org.junit.Test;

import static org.junit.Assert.*;

import android.app.Instrumentation;
import android.content.Context;

import com.example.dungeongame.model.User;
import com.example.dungeongame.views.GameScreen;
import com.example.dungeongame.views.SetupActivity;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void hardDifficultyHealth() {
        User test = User.getInstance("player1", 1, "Easy", 10);

        assertTrue(test.getHealth() == 100);
        test.setDifficulty("Hard");
        assertTrue(test.getHealth() == 60);
    }

    @Test
    public void negativeScore() {
        User test = User.getInstance("player1", 1, "Easy", 10);
        test.setScore(-5);
        assertTrue(test.getScore() == 0);
    }
    @Test
    public void rightName() {
        User test = User.getInstance("", 1, "Easy", 10);
        assertTrue(test.getUsername() != null || !(test.getUsername().isEmpty()) );
    }
    @Test
    public void userSingleton() {
        User test = User.getInstance("player1", 1, "Easy", 10);
        User test2 = User.getInstance("player100", 3, "Hard", 50);
        assertTrue(test == test2);
        assertTrue(User.getUsername() == "player1");
        assertTrue(User.getDifficulty() == "Easy");
        assertTrue(User.getSprite() == 1);
        assertTrue(User.getSpeed() == 10);
    }
    @Test
    public void easyDifficultyHealth() {
        User test = User.getInstance("player1", 1, "Medium", 10);

        assertTrue(test.getHealth() == 85);
        test.setDifficulty("Easy");
        assertTrue(test.getHealth() == 100);
    }
    @Test
    public void medDifficultyHealth() {
        User test = User.getInstance("player1", 1, "Hard", 10);

        assertTrue(test.getHealth() == 60);
        test.setDifficulty("Medium");
        assertTrue(test.getHealth() == 85);
    }
}