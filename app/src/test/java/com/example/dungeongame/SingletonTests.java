package com.example.dungeongame;

import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.User;

import org.junit.Test;

public class SingletonTests {
    @Test
    public void leaderboardSingleton() {
        Leaderboard lead = Leaderboard.getInstance();
        LeaderboardEntry l1 = new LeaderboardEntry("Bob", 5);
        lead.addEntry(l1);
        Leaderboard lead2 = Leaderboard.getInstance();
        LeaderboardEntry l2 = new LeaderboardEntry("Pfasdf", 5);
        lead2.addEntry(l2);
        assertTrue(lead == lead2);
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
}
