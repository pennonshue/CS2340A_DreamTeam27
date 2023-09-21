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
        continueButton = findViewById(R.id.contBtn);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user input from the EditText
                String playerName = nameEditText.getText().toString().trim();

                // Check if the input is null, empty, or whitespace-only
                if (playerName.isEmpty() || playerName.matches("^\\s*$")) {
                    Toast.makeText(SetupActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                } else {
                    // Name and player selection are valid, proceed to the next activity
                    Intent intent = new Intent(SetupActivity.this, GameScreen.class); // Replace NextActivity with your desired destination
                    intent.putExtra("playerName", playerName);
                    startActivity(intent);
                }
            }
        });
    }
}
