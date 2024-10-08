package com.example.dungeongame;

import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.JogStrategy;
import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.Player;
import com.example.dungeongame.model.RunStrategy;

import org.junit.Test;
public class Sprint2JUnits {
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
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setHealth(0);
        assertTrue(Player.getWin() == false);

    }
    @Test
    public void checkWin() {
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setHealth(50);
        assertTrue(Player.getWin() == true);

    }
    @Test
    public void checkLeaderboardEntryToString() {
        Leaderboard lead = Leaderboard.getInstance();
        LeaderboardEntry l1= new LeaderboardEntry("Steve", 5);
        lead.addEntry(l1);
        assertTrue(lead.getLastEntry().toString().equals(lead.getLastEntry().getPlayerName() +  "   "
                + lead.getLastEntry().getScore() + "      "
                + lead.getLastEntry().getFormattedDate()));
    }

    @Test
    public void checkLoseScore() {
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setHealth(0);
        assertTrue(Player.getScore() == 0);

    }
    @Test
    public void checkWalkMovementEasy() {
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setDifficulty("Easy");
        assertTrue(Player.getMovementStrategy() instanceof RunStrategy);
    }
    @Test
    public void checkWalkMovementMedium() {
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setDifficulty("Medium");
        assertTrue(Player.getMovementStrategy() instanceof RunStrategy);
    }
    @Test
    public void checkWalkMovementHard() {
        Player test = Player.getInstance("player1", 1, "Medium");
        test.setDifficulty("Hard");
        assertTrue(Player.getMovementStrategy() instanceof JogStrategy);
    }

}
