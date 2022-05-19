package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavDemo extends AppCompatActivity {

    AddFragment addFragment = new AddFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_demo);
        bottomNavView = findViewById(R.id.bottomNavView);

        fragmentManager.beginTransaction().replace(R.id.frameLayout, addFragment).commit();

        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();

                if (id == R.id.bottomMenuAdd)
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, addFragment).commit();
                else if (id == R.id.bottomMenuCamera)
                    Toast.makeText(BottomNavDemo.this, "Camera", Toast.LENGTH_LONG).show();
                else if (id == R.id.bottomMenuEdit)
                    Toast.makeText(BottomNavDemo.this, "Edit", Toast.LENGTH_LONG).show();
                else if (id == R.id.bottomMenuProfile)
                    Toast.makeText(BottomNavDemo.this, "Profile", Toast.LENGTH_LONG).show();

                return true;
            }
        });

    }
}