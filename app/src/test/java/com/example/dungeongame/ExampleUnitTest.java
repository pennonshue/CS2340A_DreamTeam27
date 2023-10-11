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
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void difficultyTest() {
        User test = User.getInstance("player1", 1, "Easy", 10);

        assertTrue(test.getHealth() == 100);
        test.setDifficulty("Hard");
        assertTrue(test.getHealth() == 60);
    }

    @Test
    public void negativeScore() {
        User test = User.getInstance("player1", 1, "Easy", 10);
        GameScreen testScreen = new GameScreen();

        test.setScore(-5);
        assertTrue(test.getScore() >= 0);
    }





}