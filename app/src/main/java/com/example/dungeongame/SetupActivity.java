package com.example.dungeongame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);



        Button cont = findViewById(R.id.contBtn);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup difficultyChoice = (RadioGroup) findViewById(R.id.diffRadioGroup);

                final String difficulty =
                        ((RadioButton)findViewById(difficultyChoice.getCheckedRadioButtonId()))
                                        .getText().toString();

                RadioGroup playerSprite = (RadioGroup) findViewById(R.id.spriteSelector);

                final String sprite = ((RadioButton)findViewById(playerSprite.getCheckedRadioButtonId()))
                                        .getText().toString();

                User player = new User("Nik",  sprite, difficulty, 10);

                Intent intent = new Intent(SetupActivity.this, GameScreen.class);
                startActivity(intent);
            }
        });
    }
}