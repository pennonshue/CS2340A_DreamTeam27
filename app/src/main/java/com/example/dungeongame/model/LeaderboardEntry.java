package com.example.dungeongame.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaderboardEntry {
    private String playerName;
    private int score;
    private Date timestamp;

    public LeaderboardEntry(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
        this.timestamp = new Date();
        System.out.println("leaderboard is created");
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(timestamp);
    }
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        return Leaderboard.getInstance().getLastEntry().getPlayerName() + "   "
                + Leaderboard.getInstance().getLastEntry().getScore() + "      "
                + Leaderboard.getInstance().getLastEntry().getFormattedDate();
    }
}