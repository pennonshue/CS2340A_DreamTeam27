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
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;
import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.LeaderboardEntry;
import com.example.dungeongame.model.User;

public class EndScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        LeaderboardEntry entry = new LeaderboardEntry(User.getUsername(), User.getScore());
        System.out.println(entry.getPlayerName());
        Leaderboard.getInstance().addEntry(entry);

        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this, SetupActivity.class);
                User.setScore(1000);
                startActivity(intent);
            }
        });
        // Create a parent LinearLayout to hold the player information
        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setOrientation(LinearLayout.VERTICAL);

        // Create TextViews for player name, difficulty, score and health

        for (int i = 0; i < Leaderboard.getInstance().getTop5Entries().size(); i++) {
            number1.setText(Leaderboard.getInstance().getTop5PlayerNames().get(i) + "   " +
                    Leaderboard.getInstance().getTop5Scores().get(i));
        }

        TextView number1 = findViewById(R.id.number1);
        number1.setText(Leaderboard.getInstance().getTop5PlayerNames().get(0) + "   " +
                        Leaderboard.getInstance().getTop5Scores().get(0));



        TextView number2 = findViewById(R.id.number2);
        if (Leaderboard.getInstance().getLeaderboardEntries().size() >= 2 ) {
            System.out.println(Leaderboard.getInstance().getTop5PlayerNames().get(1));
            number2.setText(Leaderboard.getInstance().getTop5PlayerNames().get(1) + "   " +
                    Leaderboard.getInstance().getTop5Scores().get(1));
        }
        System.out.println("Number 3");

////
        TextView number3 = findViewById(R.id.number3);
//        if (Leaderboard.getInstance().getLeaderboardEntries().get(2) != null) {
//            number3.setText(Leaderboard.getInstance().getTop5PlayerNames().get(2) + "   " +
//                    Leaderboard.getInstance().getTop5Scores().get(2));
//        }
        TextView number4 = findViewById(R.id.number4);
//        if (Leaderboard.getInstance().getLeaderboardEntries().get(3) != null) {
//            number4.setText(Leaderboard.getInstance().getTop5PlayerNames().get(3) + "   " +
//                    Leaderboard.getInstance().getTop5Scores().get(3));
//        }
        TextView number5 = findViewById(R.id.number5);
//        if (Leaderboard.getInstance().getLeaderboardEntries().get(4) != null) {
//            number5.setText(Leaderboard.getInstance().getTop5PlayerNames().get(4) + "   " +
//                    Leaderboard.getInstance().getTop5Scores().get(4));
//        }




//        TextView score1TextView = new TextView(this);
//        score1TextView.setText("#1: " + Leaderboard.getInstance().getTop5PlayerNames().get(0));
//        score1TextView.setTextSize(20);
//        score1TextView.setTextColor(Color.GRAY);
//
//        TextView score2TextView = new TextView(this);
//        score2TextView.setText("#2: " + Leaderboard.getInstance().getTop5Scores().get(0));
//        score2TextView.setTextSize(20);
//        score2TextView.setTextColor(Color.GRAY);
//
//        TextView score3TextView = new TextView(this);
//        score3TextView.setText("#3: " + Leaderboard.getInstance().getTop5Timestamps().get(0));
//        score3TextView.setTextSize(20);
//        score3TextView.setTextColor(Color.GRAY);

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

        parentLayoutParams.leftMargin = 200;
        parentLayoutParams.topMargin = 900;

        // Add TextViews to the parent LinearLayout
//        parentLayout.addView(score1TextView);
//        parentLayout.addView(score2TextView);
//        parentLayout.addView(score3TextView);
//        parentLayout.addView(score4TextView);
//        parentLayout.addView(score5TextView);
    }
//    public List<LeaderboardEntry> getTop5Entries() {
//        if (mainLeaderboard.getLeaderboardEntries().size() >= 5) {
//            return mainLeaderboard.getLeaderboar.subList(0, 5);
//        } else {
//            return leaderboardEntries;
//        }
//    }
//
//    public List<String> getTop5PlayerNames() {
//        List<LeaderboardEntry> top5Entries = getTop5Entries();
//        List<String> top5PlayerNames = new ArrayList<>();
//        for (LeaderboardEntry entry : top5Entries) {
//            top5PlayerNames.add(entry.getPlayerName());
//        }
//        return top5PlayerNames;
//    }
//
//    public List<Integer> getTop5Scores() {
//        List<LeaderboardEntry> top5Entries = getTop5Entries();
//        List<Integer> top5Scores = new ArrayList<>();
//        for (LeaderboardEntry entry : top5Entries) {
//            top5Scores.add(entry.getScore());
//        }
//        return top5Scores;
//    }
//
//    public List<String> getTop5Timestamps() {
//        List<LeaderboardEntry> top5Entries = getTop5Entries();
//        List<String> top5Timestamps = new ArrayList<>();
//        for (LeaderboardEntry entry : top5Entries) {
//            top5Timestamps.add(entry.getFormattedDate());
//        }
//        return top5Timestamps;
//    }

    // LeaderboardEntry class

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
