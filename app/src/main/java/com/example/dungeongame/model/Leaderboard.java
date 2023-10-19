package com.example.dungeongame.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leaderboard {
    private static List<LeaderboardEntry> leaderboardEntries;

    public List<LeaderboardEntry> getLeaderboardEntries() {
        return leaderboardEntries;
    }
    private static Leaderboard instance;

    private Leaderboard() {
        leaderboardEntries = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    public void addEntry(LeaderboardEntry entry) {
        leaderboardEntries.add(entry);
        System.out.println("YO" + leaderboardEntries);
        // Sort entries in descending order by score
        Collections.sort(leaderboardEntries,
                Collections.reverseOrder(Comparator.comparing(LeaderboardEntry::getScore)));
    }

    public List<LeaderboardEntry> getTop5Entries() {
        if (leaderboardEntries.size() >= 5) {
            return leaderboardEntries.subList(0, 5);
        } else {
            return leaderboardEntries;
        }
    }

    public List<String> getTop5PlayerNames() {
        List<LeaderboardEntry> top5Entries = getTop5Entries();
        List<String> top5PlayerNames = new ArrayList<>();
        for (LeaderboardEntry entry : top5Entries) {
            top5PlayerNames.add(entry.getPlayerName());
        }
        return top5PlayerNames;
    }

    public List<Integer> getTop5Scores() {
        List<LeaderboardEntry> top5Entries = getTop5Entries();
        List<Integer> top5Scores = new ArrayList<>();
        for (LeaderboardEntry entry : top5Entries) {
            top5Scores.add(entry.getScore());
        }
        return top5Scores;
    }

    public List<String> getTop5Timestamps() {
        List<LeaderboardEntry> top5Entries = getTop5Entries();
        List<String> top5Timestamps = new ArrayList<>();
        for (LeaderboardEntry entry : top5Entries) {
            top5Timestamps.add(entry.getFormattedDate());
        }
        return top5Timestamps;
    }

}