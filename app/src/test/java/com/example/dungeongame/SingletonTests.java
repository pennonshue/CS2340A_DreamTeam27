package com.example.dungeongame;

import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.Player;

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
    public void PlayerSingleton() {
        Player test = Player.getInstance("player1", 1, "Easy");
        Player test2 = Player.getInstance("player100", 3, "Hard");
        assertTrue(test == test2);
        assertTrue(Player.getUsername() == "player1");
        assertTrue(Player.getDifficulty() == "Easy");
        assertTrue(Player.getSprite() == 1);
    }
}
