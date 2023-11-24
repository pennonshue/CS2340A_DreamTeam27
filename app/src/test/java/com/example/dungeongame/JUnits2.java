package com.example.dungeongame;

import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.Player;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JUnits2 {
    @Test
    public void hardDifficultyHealth() {
        Player test = Player.getInstance("player1", 1, "Easy");
        assertTrue(test.getHealth() == 100);
        test.setDifficulty("Hard");
        assertTrue(test.getHealth() == 60);
    }
    @Test
    public void easyDifficultyHealth() {
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setDifficulty("Medium");
        assertTrue(test.getHealth() == 85);
        test.setDifficulty("Easy");
        assertTrue(test.getHealth() == 100);
    }
    @Test
    public void testTop5Names() {
        Leaderboard lead = Leaderboard.getInstance();
        LeaderboardEntry l1= new LeaderboardEntry("Steve", 5);
        LeaderboardEntry l2= new LeaderboardEntry("Bob", 7);
        LeaderboardEntry l3= new LeaderboardEntry("L", 3);
        LeaderboardEntry l4= new LeaderboardEntry("N", 8);
        LeaderboardEntry l5= new LeaderboardEntry("O", 35);
        LeaderboardEntry l6= new LeaderboardEntry("J", 15);
        lead.addEntry(l1);
        lead.addEntry(l2);
        lead.addEntry(l3);
        lead.addEntry(l4);
        lead.addEntry(l5);
        lead.addEntry(l6);
        List<String> tester = new ArrayList<>();
        tester.add(0, "Steve");
        tester.add(0, "Bob");
        tester.add(0, "N");
        tester.add(0, "J");
        tester.add(0, "O");
        assertTrue(lead.getTop5PlayerNames().equals(tester));
    }

}
