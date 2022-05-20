package com.kriti.android1_30;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogDemo extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_demo);
        button = findViewById(R.id.openAlertDialogButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this);
                builder.setTitle("Important message!!!");
                builder.setIcon(R.drawable.hello);
                builder.setMessage("Hi :D");

                builder.setPositiveButton("Hi?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogDemo.this, "Nice", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("No.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogDemo.this, "Jaa fir", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNeutralButton("Who are you?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogDemo.this, "Yaar...", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}