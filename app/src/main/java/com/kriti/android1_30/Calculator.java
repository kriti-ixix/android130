package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Registering
        EditText firstEditText = findViewById(R.id.firstEditText);
        EditText secondEditText = findViewById(R.id.secondEditText);
        TextView textView = findViewById(R.id.textViewResult);
        Button addButton = findViewById(R.id.buttonAdd);
        Button subButton = findViewById(R.id.buttonSub);
        Button mulButton = findViewById(R.id.buttonMul);
        Button divButton = findViewById(R.id.buttonDiv);

        // Listeners
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double firstNumber = Double.parseDouble(firstEditText.getText().toString());
                double secondNumber = Double.parseDouble(secondEditText.getText().toString());
                double result = firstNumber + secondNumber;
                textView.setText("Result: " + String.valueOf(result));
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double firstNumber = Double.parseDouble(firstEditText.getText().toString());
                double secondNumber = Double.parseDouble(secondEditText.getText().toString());
                double result = firstNumber - secondNumber;
                textView.setText("Result: " + String.valueOf(result));
            }
        });
    }
}