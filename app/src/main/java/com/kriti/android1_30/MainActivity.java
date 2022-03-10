package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registering all the components
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);

        // Code that will run whenever you click on the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                textView.setText("Hi " + name + "!");
            }
        });
    }
}