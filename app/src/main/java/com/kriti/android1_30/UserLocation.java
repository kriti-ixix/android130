package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserLocation extends AppCompatActivity {

    TextView latitudeTextView, longitudeTextView;
    Button button;
    final int LOCATION_REQ_CODE = 100;
    double latitude = 0, longitude = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);

        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);
        button = findViewById(R.id.getLocationButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(UserLocation.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                {
                    // Have the permission to access the location
                    getLocation();
                }
                else
                {
                    // Ask for the permission
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQ_CODE);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            getLocation();
        else
            Toast.makeText(UserLocation.this, "Please allow location access", Toast.LENGTH_LONG).show();
    }

    void getLocation()
    {
        Toast.makeText(UserLocation.this, "Location access granted", Toast.LENGTH_LONG).show();
    }
}