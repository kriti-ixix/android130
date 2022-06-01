package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PositionSensor extends AppCompatActivity {

    TextView textView;
    Button button;
    SensorManager sensorManager;
    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_sensor);

        textView = findViewById(R.id.coordinatesTextView);
        button = findViewById(R.id.openButton);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        list = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (list.size() > 0)
            sensorManager.registerListener(eventListener, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        else
            Toast.makeText(this, "Unable to connect to sensor", Toast.LENGTH_LONG).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(PositionSensor.this, Movies.class);
                startActivity(in);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity", "onPause");

        if (list.size() > 0)
            sensorManager.unregisterListener(eventListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity", "onPause");

        if (list.size() > 0)
            sensorManager.registerListener(eventListener, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        else
            Toast.makeText(this, "Unable to connect to sensor", Toast.LENGTH_LONG).show();

    }

    SensorEventListener eventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            Log.d("Sensor Event Listener", "Triggered");
            textView.setText("X: " + values[0] + "\n" + "Y: " + values[1] + "\n" + "Z: " + values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {}
    };
}