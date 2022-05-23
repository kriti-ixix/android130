package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIDemo extends AppCompatActivity {

    EditText bmiEditText, ageEditText, glucoseEditText;
    Button button;
    TextView predictionText, probaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apidemo);

        bmiEditText = findViewById(R.id.bmiEditText);
        ageEditText = findViewById(R.id.ageEditText);
        glucoseEditText = findViewById(R.id.glucoseEditText);
        button = findViewById(R.id.button);
        predictionText = findViewById(R.id.predictionTextView);
        probaText = findViewById(R.id.probaTextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String glucose = glucoseEditText.getText().toString();
                String bmi = bmiEditText.getText().toString();
                String age = ageEditText.getText().toString();

                try
                {
                    String url = "https://diabetes-api.herokuapp.com/predict/glucose=" +glucose+ "&bmi=" +bmi+ "&age=" +age;
                    DiabetesAPI api = new DiabetesAPI();
                    String response = api.execute(url).get();
                    Log.d("Response", response);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    class DiabetesAPI extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                String result = ""; URL url;
                HttpURLConnection connection = null;

                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                int data = streamReader.read();

                while (data != -1)
                {
                    char current = (char) data;
                    result += current;
                    data = streamReader.read();
                }

                return result;

            }
            catch (Exception e)
            {
                return null;
            }
        }
    }
}