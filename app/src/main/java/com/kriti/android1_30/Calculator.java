package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    EditText firstEditText, secondEditText;
    TextView textView;
    Button addButton, subButton, mulButton, divButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Registering
        firstEditText = findViewById(R.id.firstEditText);
        secondEditText = findViewById(R.id.secondEditText);
        textView = findViewById(R.id.textViewResult);
        addButton = findViewById(R.id.buttonAdd);
        subButton = findViewById(R.id.buttonSub);
        mulButton = findViewById(R.id.buttonMul);
        divButton = findViewById(R.id.buttonDiv);

        addButton.setOnClickListener(buttonListener);
        subButton.setOnClickListener(buttonListener);
        mulButton.setOnClickListener(buttonListener);
        divButton.setOnClickListener(buttonListener);
    }

    // Listener for all the buttons
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double firstNumber = Double.parseDouble(firstEditText.getText().toString());
            double secondNumber = Double.parseDouble(secondEditText.getText().toString());
            double result = 0;
            int id = view.getId();

            if (id == R.id.buttonAdd)
                result = firstNumber + secondNumber;
            else if (id == R.id.buttonSub)
                result = firstNumber - secondNumber;
            else if (id == R.id.buttonMul)
                result = firstNumber * secondNumber;
            else if (id == R.id.buttonDiv)
                result = firstNumber / secondNumber;

            textView.setText("Result: " + String.valueOf(result));
        }
    };
}