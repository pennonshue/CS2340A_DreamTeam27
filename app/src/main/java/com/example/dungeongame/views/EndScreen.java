package com.example.dungeongame.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;
import com.example.dungeongame.model.Leaderboard;
import com.example.dungeongame.model.User;

public class EndScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);


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

        TextView number1 = findViewById(R.id.number1);
        number1.setTextColor(Color.WHITE);
        number1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        TextView number2 = findViewById(R.id.number2);
        number2.setTextColor(Color.WHITE);
        number2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        TextView number3 = findViewById(R.id.number3);
        number3.setTextColor(Color.WHITE);
        number3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        TextView number4 = findViewById(R.id.number4);
        number4.setTextColor(Color.WHITE);
        number4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        TextView number5 = findViewById(R.id.number5);
        number5.setTextColor(Color.WHITE);
        number5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        TextView number6 = findViewById(R.id.number6);
        number6.setTextColor(Color.WHITE);


        number6.setText("Latest Attempt: " + Leaderboard.getInstance().getLastEntry());
        TextView leaderboardResult = findViewById(R.id.leaderboardResult);
        if (User.getInstance().getHealth() > 0) {
            leaderboardResult.setText("WINNER");
        } else {
            leaderboardResult.setText("LOSER");
        }



        ArrayList<TextView> numbers = new ArrayList<>();
        numbers.add(number1);
        numbers.add(number2);
        numbers.add(number3);
        numbers.add(number4);
        numbers.add(number5);


        for (int i = 0; i < Leaderboard.getInstance().getTop5Entries().size(); i++) {
            System.out.println(Leaderboard.getInstance().getLeaderboardEntries().get(i));
            numbers.get(i).setText(Leaderboard.getInstance().getTop5PlayerNames().get(i) + "   "
                    + Leaderboard.getInstance().getTop5Scores().get(i) + "      "
                    + Leaderboard.getInstance().getTop5Timestamps().get(i));
        }

        // Set the position of the parent LinearLayout to (50, 50)
        FrameLayout.LayoutParams parentLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );

        parentLayoutParams.leftMargin = 200;
        parentLayoutParams.topMargin = 900;


    }
}

