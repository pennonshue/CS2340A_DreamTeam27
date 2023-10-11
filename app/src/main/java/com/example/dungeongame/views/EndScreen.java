package com.example.dungeongame.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;
import com.example.dungeongame.model.User;

public class EndScreen extends AppCompatActivity {
    private static List<LeaderboardEntry> leaderboardEntries;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Create a parent LinearLayout to hold the player information
        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setOrientation(LinearLayout.VERTICAL);

        // Create TextViews for player name, difficulty, score and health
        TextView score1TextView = new TextView(this);
        score1TextView.setText("#1: " + getTop5PlayerNames());
        score1TextView.setTextSize(20);
        score1TextView.setTextColor(Color.GRAY);

        TextView score2TextView = new TextView(this);
        score2TextView.setText("#2: " + getTop5Scores());
        score2TextView.setTextSize(20);
        score2TextView.setTextColor(Color.GRAY);

        TextView score3TextView = new TextView(this);
        score3TextView.setText("#3: " + getTop5Timestamps());
        score3TextView.setTextSize(20);
        score3TextView.setTextColor(Color.GRAY);

//        TextView score4TextView = new TextView(this);
//        score4TextView.setText("#4: " + User.getScore());
//        score4TextView.setTextSize(20);
//        score4TextView.setTextColor(Color.GRAY);
//
//        TextView score5TextView = new TextView(this);
//        score5TextView.setText("#5: " + User.getScore());
//        score5TextView.setTextSize(20);
//        score5TextView.setTextColor(Color.GRAY);


        // Set the position of the parent LinearLayout to (50, 50)
        FrameLayout.LayoutParams parentLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );

        parentLayoutParams.leftMargin = 100;
        parentLayoutParams.topMargin = 1000;

        // Add TextViews to the parent LinearLayout
        parentLayout.addView(score1TextView);
        parentLayout.addView(score2TextView);
        parentLayout.addView(score3TextView);
//        parentLayout.addView(score4TextView);
//        parentLayout.addView(score5TextView);
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

    // Singleton for Leaderboard
    private static class Leaderboard {
        private static Leaderboard instance;

        private Leaderboard() {
        }

        public static Leaderboard getInstance() {
            if (instance == null) {
                instance = new Leaderboard();
            }
            return instance;
        }

        public void addEntry(LeaderboardEntry entry) {
            leaderboardEntries.add(entry);
            // Sort entries in descending order by score
            Collections.sort(leaderboardEntries, Collections.reverseOrder(Comparator.comparing(LeaderboardEntry::getScore)));
        }

    }

    // LeaderboardEntry class
    private static class LeaderboardEntry {
        private String playerName;
        private int score;
        private Date timestamp;

        public LeaderboardEntry(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
            this.timestamp = new Date();
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

        public void onGameEnd(String playerName, int score) {
            Leaderboard leaderboard = Leaderboard.getInstance();
            LeaderboardEntry entry = new LeaderboardEntry(playerName, score);
            leaderboard.addEntry(entry);
//            displayLeaderboard();
        }

//        private void displayLeaderboard() {
//            Leaderboard leaderboard = Leaderboard.getInstance();
//            List<LeaderboardEntry> topEntries = leaderboard.getTop5Entries();
//            // Display the topEntries in your UI as needed.
//
//        }
//        private void displayLeaderboard() {
//            Leaderboard leaderboard = Leaderboard.getInstance();
//            List<LeaderboardEntry> topEntries = leaderboard.getTop5Entries();
        // Display the topEntries in your UI as needed.
//                for (int i = 0; i < topEntries.toArray().length; i++) {
//                    topEntries.get(i)
//            }
        }
    }
