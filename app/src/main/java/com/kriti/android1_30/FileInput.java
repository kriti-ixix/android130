package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInput extends AppCompatActivity {

    EditText editText;
    Button readButton, saveButton;
    final String FILENAME = "Example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_input);

        editText = findViewById(R.id.fileInputEditText);
        readButton = findViewById(R.id.readFileButton);
        saveButton = findViewById(R.id.saveFileButton);

        readButton.setOnClickListener(buttonListener);
        saveButton.setOnClickListener(buttonListener);
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();

            try
            {
                if (id == R.id.readFileButton)
                {
                File file = new File(FileInput.this.getFilesDir() + "/" + FILENAME);
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String x = "", y;

                    while ((y = bufferedReader.readLine()) != null)
                    {
                        x += y;
                        x += "\n";
                    }

                    editText.setText(x);
                }
                else if (id == R.id.saveFileButton)
                {
                File file = new File(FileInput.this.getFilesDir() + "/" + FILENAME);
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    String content = editText.getText().toString();
                    bufferedWriter.write(content);
                    bufferedWriter.flush();
                    Toast.makeText(FileInput.this, "File saved", Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    };

}