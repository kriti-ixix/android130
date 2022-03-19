package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        EditText editUsername = findViewById(R.id.editTextUser);
        EditText editEmail = findViewById(R.id.editTextEmail);
        Button saveInfoButton = findViewById(R.id.saveInfoButton);

        SharedPreferences sp = getSharedPreferences("user info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        saveInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String email = editEmail.getText().toString();

                // key, value
                editor.putString("username", username);
                editor.putString("email", email);
                editor.apply();

                Toast.makeText(AddInfo.this, "Information saved", Toast.LENGTH_LONG).show();
            }
        });
    }
}