package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StudentsNames extends AppCompatActivity {

    ListView listView; ArrayAdapter<String> adapter;
    String[] names = {"ABC", "XYZ", "PQR", "JKL", "MNO", "GHI"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_names);

        listView = findViewById(R.id.studentListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nameClicked = names[i];
                Toast.makeText(StudentsNames.this, "Item clicked: " + nameClicked,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}