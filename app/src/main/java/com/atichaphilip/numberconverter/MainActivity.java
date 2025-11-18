package com.atichaphilip.numberconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    Button convertButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect to XML elements
        inputNumber = findViewById(R.id.inputNumber);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        // When button is clicked
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber();
            }
        });
    }

    void convertNumber() {
        String input = inputNumber.getText().toString();

        if (input.isEmpty()) {
            showToast("Please enter a number");
            return;
        }

        try {
            // Try to convert as decimal first
            int decimal = Integer.parseInt(input);
            showResults(decimal);
        } catch (Exception e) {
            showToast("Enter a valid number");
        }
    }

    void showResults(int decimal) {
        String results = "Decimal: " + decimal +
                "\nBinary: " + Integer.toBinaryString(decimal) +
                "\nOctal: " + Integer.toOctalString(decimal) +
                "\nHex: " + Integer.toHexString(decimal).toUpperCase();

        resultText.setText(results);
    }

    void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}