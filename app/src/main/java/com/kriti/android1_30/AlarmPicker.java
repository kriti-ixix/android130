package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class AlarmPicker extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button openClockButton;
    TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_picker);

        openClockButton = findViewById(R.id.openClockButton);
        timeTextView = findViewById(R.id.timePickerTextView);

        openClockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFrag();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute)
    {
        String hourString = String.valueOf(hour);
        String minString = "";

        if (minute < 10)
            minString = "0" + String.valueOf(minute);
        else
            minString = String.valueOf(minute);

        String displayTime = hourString + ":" + minString;
        timeTextView.setText(displayTime);
    }
}