package com.kriti.android1_30;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SQLInsert extends AppCompatActivity {

    Button insertButton;
    EditText nameEdit, marksEdit;
    RadioButton gMale, gFemale, gTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlinsert);

        insertButton = findViewById(R.id.sqlInsertButton);
        nameEdit = findViewById(R.id.sqlName);
        marksEdit = findViewById(R.id.sqlMarks);
        gMale = findViewById(R.id.sqlRadioMale);
        gFemale = findViewById(R.id.sqlRadioFemale);
        gTrans = findViewById(R.id.sqlRadioTrans);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                String marks = marksEdit.getText().toString();
                String gender = "";

                if (gMale.isSelected())
                    gender = "M";
                else if (gFemale.isSelected())
                    gender = "F";
                else
                    gender = "T";

                insertValues(name, marks, gender);
            }
        });
    }

    void insertValues(final String name, final String marks, final String gender)
    {
        String url = "http://192.168.29.2/insert.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject json = new JSONObject(String.valueOf(response));
                    String result = json.getString("result");

                    if (result.equals("OK"))
                        Toast.makeText(SQLInsert.this, "Values added", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(SQLInsert.this, "Values not added", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(SQLInsert.this, "Error connecting to database", Toast.LENGTH_LONG).show();
                Log.d("Volley Error", error.toString());
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("marks", marks);
                map.put("gender", gender);
                return map;
            }
        };

        queue.add(request);
    }
}