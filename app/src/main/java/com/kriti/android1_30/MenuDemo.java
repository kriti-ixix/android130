package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuDemo extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);
        button = findViewById(R.id.contextMenuButton);
        registerForContextMenu(button);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                openContextMenu(view);
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuItem1)
        {
            Toast.makeText(MenuDemo.this, "First option clicked", Toast.LENGTH_LONG).show();
            Log.d("Menu", "First option clicked");
        }
        else if (id == R.id.menuItem2)
        {
            Toast.makeText(MenuDemo.this, "Second option clicked", Toast.LENGTH_LONG).show();
            Log.d("Menu", "Second option clicked");
        }

        return true;
    }
}