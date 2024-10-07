package com.example.fliptext;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private EditText inputText, outputText;
    private Button flipButton, bt1, bt2, bt3;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
        flipButton = findViewById(R.id.flipButton);
        bt1 = findViewById(R.id.copyButton);
        bt2 = findViewById(R.id.clearButton);
        bt3 = findViewById(R.id.shareButton);


        bt1.setVisibility(View.GONE);
        bt2.setVisibility(View.GONE);
        bt3.setVisibility(View.GONE);
        outputText.setVisibility(View.GONE);


        flipButton.setOnClickListener(v -> {
            String text = inputText.getText().toString();
            if (!text.isEmpty()) {
                String flippedText = flipText(text);

                outputText.setText(flippedText);
                outputText.setVisibility(View.VISIBLE);
                bt1.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.VISIBLE);
                bt3.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "Please enter text", Toast.LENGTH_SHORT).show();
            }
        });


        bt1.setOnClickListener(view -> {

            Toast.makeText(MainActivity.this, "Copied", Toast.LENGTH_SHORT).show();
        });


        bt2.setOnClickListener(view -> {

            inputText.setText("");
            outputText.setText("");
            outputText.setVisibility(View.GONE);
            bt1.setVisibility(View.GONE);
            bt2.setVisibility(View.GONE);
            bt3.setVisibility(View.GONE);
        });

        bt3.setOnClickListener(view -> {

            Toast.makeText(MainActivity.this, "Shared", Toast.LENGTH_SHORT).show();
        });
    }

    private String flipText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}