package com.example.dungeongame.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeongame.R;
import com.example.dungeongame.model.User;
import com.google.android.material.textfield.TextInputEditText;

public class SetupActivity extends AppCompatActivity {

    public RadioGroup getPlayerRadioGroup() {
        return playerRadioGroup;
    }

    public RadioButton getSelectedPlayerRadioButton() {
        return selectedPlayerRadioButton;
    }

    public Button getContinueButton() {
        return continueButton;
    }

    private TextInputEditText nameEditText;
    private RadioGroup playerRadioGroup;
    private RadioButton selectedPlayerRadioButton;
    private Button continueButton;

    public void setNameEditText(TextInputEditText nameEditText) {
        this.nameEditText = nameEditText;
    }
    public static boolean validName(String val) {
        // Check if the name is empty or consists of only whitespace characters.
        if (val.isEmpty() || val.matches("^\\s*$")) {
            return false; // Name is not valid
        } else {
            return true; // Name is valid
        }
    }

    public static boolean validSprite(Integer spriteNumber) {
        if (spriteNumber != 1 && spriteNumber != 2 && spriteNumber != 3) {
            return false;
        } else {
            return true;
        }
    }

    public void setPlayerRadioGroup(RadioGroup playerRadioGroup) {
        this.playerRadioGroup = playerRadioGroup;
    }

    public void setSelectedPlayerRadioButton(RadioButton selectedPlayerRadioButton) {
        this.selectedPlayerRadioButton = selectedPlayerRadioButton;
    }

    public void setContinueButton(Button continueButton) {
        this.continueButton = continueButton;
    }

    public TextInputEditText getNameEditText() {
        return nameEditText;
    }
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
                if (difficultyChoice.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(SetupActivity.this, "Please select "
                            + "a difficulty level", Toast.LENGTH_SHORT).show();
                } else {
                    final String difficulty =
                            ((RadioButton) findViewById(difficultyChoice.getCheckedRadioButtonId()))
                                    .getText().toString();
                    RadioGroup playerSprite = (RadioGroup) findViewById(R.id.spriteSelector);


                    //Sprite Integer  (1, 2, 3) - need to check if null
                    if (playerSprite.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(SetupActivity.this, "Please select a Character",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        String spriteCharacter = ((RadioButton) findViewById(
                                playerSprite.getCheckedRadioButtonId()))
                                .getText().toString();
                        final int sprite = Integer.parseInt(spriteCharacter.substring(
                                spriteCharacter.length() - 1));

                        //Player Name String - Already checked
                        String playerName = nameEditText.getText().toString().trim();


                        // Check if the input is null, empty, or whitespace-only
                        if (playerName.isEmpty() || playerName.matches("^\\s*$")) {
                            Toast.makeText(SetupActivity.this, "Please enter a "
                                   + "valid name", Toast.LENGTH_SHORT).show();
                        } else {


                            User player = User.getInstance(playerName, sprite, difficulty, 10);
                            User.setUsername(playerName);
                            User.setSprite(sprite);


                            Intent intent = new Intent(SetupActivity.this,
                                    GameScreen.class); // Replace NextActivity with your desired
                            // destination


                            /* Im not sure if we need this exact line since we created a
                            User class and can just access name through User.getUsername()
                            */
                            //Sends info from one screen to another
                            intent.putExtra("playerName", playerName);

                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
