package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button button = findViewById(R.id.checkLoginButton);
        SharedPreferences sp = getSharedPreferences("user info", MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentUser = sp.getString("username", "");

                if (currentUser.equals(""))
                {
                    Intent in = new Intent(Start.this, AddInfo.class);
                    startActivity(in);
                }
                else
                {
                    Intent in = new Intent(Start.this, UserProfile.class);
                    startActivity(in);
                }
            }
        });
    }
}