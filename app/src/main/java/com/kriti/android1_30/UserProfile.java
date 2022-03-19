package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        TextView textUsername = findViewById(R.id.textViewUsername);
        TextView textEmail = findViewById(R.id.textViewEmail);
        Button addInfo = findViewById(R.id.addInfoButton);

        SharedPreferences sp = getSharedPreferences("user info", MODE_PRIVATE);
        String username = sp.getString("username", "No username found");
        String email = sp.getString("email", "No email found");

        textUsername.setText(username);
        textEmail.setText(email);

        addInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserProfile.this, AddInfo.class);
                startActivity(in);
            }
        });

    }
}