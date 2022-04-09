package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentSignUp extends AppCompatActivity {

    Button insertButton;
    EditText rollNoText, nameText;
    RadioButton radioMale, radioFemale, radioTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

        insertButton = findViewById(R.id.insertButton);
        rollNoText = findViewById(R.id.insertRollNo);
        nameText = findViewById(R.id.insertName);
        radioFemale = findViewById(R.id.radioFemale);
        radioMale = findViewById(R.id.radioMale);
        radioTrans = findViewById(R.id.radioTrans);

        DbHelper dbHelper = new DbHelper(this);
        ArrayList <StudentData> students = dbHelper.getAllData();
        Log.d("Arraylist", String.valueOf(students.size()));

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rollno = Integer.parseInt(rollNoText.getText().toString());
                String name = nameText.getText().toString();
                String gender = "";

                if (radioMale.isChecked())
                    gender = "M";
                else if (radioFemale.isChecked())
                    gender = "F";
                else
                    gender = "T";

                DbHelper dbHelper = new DbHelper(StudentSignUp.this);
                long result = dbHelper.insertData(rollno, name, gender);
                Log.d("Result", String.valueOf(result));

                if (result == -1)
                {
                    // Value not inserted
                    Toast.makeText(StudentSignUp.this, "Values not inserted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    // Value inserted
                    Toast.makeText(StudentSignUp.this, "Values inserted", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}