package com.example.dungeongame;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.views.SetupActivity;

import com.example.dungeongame.model.Player;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JUnits1 {

    @Test
    public void negativeScore() {
        Player test = Player.getInstance("player1", 1, "Easy");
        test.setScore(-5);
        assertTrue(test.getScore() == 0);
    }

    @Test
    public void medDifficultyHealth() {
        Player test = Player.getInstance("player1", 1, "Hard");
        test.setDifficulty("Hard");
        assertTrue(test.getHealth() == 60);
        test.setDifficulty("Medium");
        assertTrue(test.getHealth() == 85);
    }

    @Test
    public void leaderboardTop5() {
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
        List<LeaderboardEntry> tester = new ArrayList<>();
        tester.add(0, l3);
        tester.add(0, l1);
        tester.add(0, l2);
        tester.add(0, l4);
        tester.add(0, l6);
        tester.add(0, l5);
        assertTrue(lead.getLeaderboardEntries().equals(tester));
    }
    @Test
    public void testFormattedTimeStamp() {
        LeaderboardEntry l1= new LeaderboardEntry("Steve", 5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date l1Date = l1.getTimestamp();
        assertTrue(dateFormat.format(l1Date).equals(l1.getFormattedDate()));
    }


    @Test
    public void validSprite() {
        Player test = Player.getInstance("player1", 1, "Hard");
        assertEquals(true, SetupActivity.validSprite(Player.getSprite()));
    }
}