package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppStart extends AppCompatActivity {

    SharedPreferences preferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        preferences = getSharedPreferences("user", MODE_PRIVATE);
        button = findViewById(R.id.checkUserButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // key, default value
                String username = preferences.getString("username", "default");

                if (username.equals("default"))
                {
                    Intent in = new Intent(AppStart.this, AppLogin.class);
                    startActivity(in);
                }
                else
                {
                    Intent in = new Intent(AppStart.this, AppHome.class);
                    startActivity(in);
                }

            }
        });
    }
}