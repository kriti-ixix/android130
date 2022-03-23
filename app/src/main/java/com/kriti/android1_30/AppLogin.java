package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppLogin extends AppCompatActivity {

    Button addUserButton;
    EditText usernameText, emailText, passwordText;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_login);

        addUserButton = findViewById(R.id.addUserButton);
        usernameText = findViewById(R.id.usernameLogin);
        emailText = findViewById(R.id.emailLogin);
        passwordText = findViewById(R.id.passwordLogin);

        preferences = getSharedPreferences("user", MODE_PRIVATE);
        editor = preferences.edit();

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameText.getText().toString();
                String email = emailText.getText().toString();

                // "username", user123; "email", email@xyz.com
                editor.putString("username", username);
                editor.putString("email", email);
                editor.apply();
            }
        });
    }
}