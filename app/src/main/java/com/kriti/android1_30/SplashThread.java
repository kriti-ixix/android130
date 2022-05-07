package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashThread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_thread);
        getSupportActionBar().hide();

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(2000);
                    Intent in = new Intent(SplashThread.this, SQLSelect.class);
                    startActivity(in);
                    finish();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        thread.start();

    }
}