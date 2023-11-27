package com.example.dungeongame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.views.SetupActivity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JUnit3 {
    //Leaderboard add test
    @Test
    public void leaderboardAdd() {
        Leaderboard lead = Leaderboard.getInstance();
        LeaderboardEntry l1= new LeaderboardEntry("Steve", 5);
        lead.addEntry(l1);
        List<LeaderboardEntry> tester = new ArrayList<>();
        tester.add(l1);
        assertTrue(lead.getLeaderboardEntries().equals(tester));
    }
    //Invalid Name Test name
    @Test
    public void invalidName() {
        assertEquals(false, SetupActivity.validName("    "));
        assertEquals(false, SetupActivity.validName(""));

    }
    //Valid Name Test name
    @Test
    public void validName() {
        assertEquals(true, SetupActivity.validName(" a;slkdjf;asdlkf   "));
        assertEquals(true, SetupActivity.validName("kdasjf;lkadsjf: "));

    }
}
