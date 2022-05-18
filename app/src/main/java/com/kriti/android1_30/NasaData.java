package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NasaData extends AppCompatActivity {

    final String API_KEY = "f3uD4d3sqAfhbLsC4LR1gfhhfCAo4shCdNebjBmb";
    final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=f3uD4d3sqAfhbLsC4LR1gfhhfCAo4shCdNebjBmb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa_data);
    }
}