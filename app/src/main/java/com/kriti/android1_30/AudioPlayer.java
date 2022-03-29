package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AudioPlayer extends AppCompatActivity {

    Button playButton, pauseButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        playButton = findViewById(R.id.playAudioButton);
        pauseButton = findViewById(R.id.pauseAudioButton);

        mediaPlayer = MediaPlayer.create(this, R.raw.dm);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Play Button", "Clicked");
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Pause Button", "Clicked");
                mediaPlayer.pause();
            }
        });
    }
}