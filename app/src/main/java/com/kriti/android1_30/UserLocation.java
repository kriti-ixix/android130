package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class UserLocation extends AppCompatActivity {

    TextView latitudeTextView, longitudeTextView, cityTextView;
    Button button;
    LocationRequest locationRequest;
    final int LOCATION_REQ_CODE = 100;
    double latitude = 0, longitude = 0;
    String city = "City";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);

        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);
        cityTextView = findViewById(R.id.cityTextView);
        button = findViewById(R.id.getLocationButton);

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getLocation();
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
        if (ActivityCompat.checkSelfPermission(UserLocation.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            // Have the permission to access the location
            LocationServices.getFusedLocationProviderClient(this)
                    .requestLocationUpdates(locationRequest, new LocationCallback() {
                        @Override
                        public void onLocationResult(@NonNull LocationResult locationResult) {
                            super.onLocationResult(locationResult);
                            LocationServices.getFusedLocationProviderClient(UserLocation.this)
                                    .removeLocationUpdates(this);

                            int locationSize = locationResult.getLocations().size();

                            if (locationSize > 0)
                            {
                                int index = locationSize - 1;
                                Location location = locationResult.getLocations().get(index);
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();

                                latitudeTextView.setText("Latitude: " + String.valueOf(latitude));
                                longitudeTextView.setText("Longitude: " + String.valueOf(longitude));

                                try
                                {
                                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                                    List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);

                                    if (addressList.size() > 0)
                                        city = "City: " + addressList.get(0).getLocality();
                                    cityTextView.setText(city);

                                }

                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }

                            }

                        }
                    }, Looper.getMainLooper());
        }
        else
        {
            // Ask for the permission
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQ_CODE);
        }
    }
}