package com.example.dungeongame;

import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.User;

import org.junit.Test;

public class JUnitsSprint2 {
    @Test
    public void trackLastEntry() {
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
        assertTrue(lead.getLastEntry().equals(l6));
    }
    @Test
    public void checkLose() {
        User test = User.getInstance("player1", 1, "Medium", 10);
        test.setHealth(0);
        assertTrue(User.getWin() == false);

    }
    @Test
    public void checkWin() {
        User test = User.getInstance("player1", 1, "Medium", 10);
        test.setHealth(50);
        assertTrue(User.getWin() == true);

    }
    @Test
    public void checkLeaderboardEntryToString() {
        Leaderboard lead = Leaderboard.getInstance();
        LeaderboardEntry l1= new LeaderboardEntry("Steve", 5);
        lead.addEntry(l1);
        assertTrue(lead.getLastEntry().toString().equals(l1.getPlayerName() +  "   "
                + lead.getLastEntry().getScore() + "      "
                + lead.getLastEntry().getTimestamp()));
    }



}
