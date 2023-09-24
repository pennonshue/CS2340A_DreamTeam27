package com.example.dungeongame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class SetupActivity extends AppCompatActivity {

    private TextInputEditText nameEditText;
    private RadioGroup playerRadioGroup;
    private RadioButton selectedPlayerRadioButton;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        // Initialize views
        nameEditText = findViewById(R.id.nameBox);

        Button cont = findViewById(R.id.contBtn);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RadioGroup difficultyChoice = (RadioGroup) findViewById(R.id.diffRadioGroup);

                //Difficulty level String ("Easy", "Medium", "Hard") - need to check if null

                final String difficulty =
                        ((RadioButton)findViewById(difficultyChoice.getCheckedRadioButtonId()))
                                        .getText().toString();

                RadioGroup playerSprite = (RadioGroup) findViewById(R.id.spriteSelector);

                String spriteCharacter = ((RadioButton)findViewById(playerSprite.getCheckedRadioButtonId()))
                                        .getText().toString();

                //Sprite Integer  (1, 2, 3) - need to check if null
                final int sprite = Integer.parseInt(spriteCharacter.substring(spriteCharacter.length() - 1));

                //Player Name String - Already checked
                String playerName = nameEditText.getText().toString().trim();

                // Check if the input is null, empty, or whitespace-only
                if (playerName.isEmpty() || playerName.matches("^\\s*$")) {
                    Toast.makeText(SetupActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                } else {

                    User player = User.getInstance(playerName, sprite, difficulty, 10);

                    Intent intent = new Intent(SetupActivity.this, GameScreen.class); // Replace NextActivity with your desired destination

                    /* Im not sure if we need this exact line since we created a
                    User class and can just access name through User.getUsername()
                    */
                    //Sends info from one screen to another
                    intent.putExtra("playerName", playerName);

                    startActivity(intent);
                }


            }
        });
    }
}
