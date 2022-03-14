package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.userTextView);
        Intent in = getIntent();
        String username = in.getStringExtra("name");
        textView.setText("Hi " + username + "!");
    }
}