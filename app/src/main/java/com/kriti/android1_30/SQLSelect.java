package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SQLSelect extends AppCompatActivity {

    ArrayList<SQLData> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlselect);

        String url = "http://192.168.29.3/getting_info.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    JSONObject json = new JSONObject(String.valueOf(response));
                    String result = json.getString("result");

                    if (result.equals("EMPTY"))
                    {
                        Toast.makeText(SQLSelect.this, "No rows found", Toast.LENGTH_LONG).show();
                        Log.d("Error", "Result empty");
                    }
                    else
                    {
                        JSONArray rollNoArray = json.getJSONArray("roll no");
                        JSONArray nameArray = json.getJSONArray("name");
                        JSONArray genderArray = json.getJSONArray("gender");
                        JSONArray marksArray = json.getJSONArray("marks");

                        for (int i = 0; i < rollNoArray.length(); i++)
                        {
                            int rollno = rollNoArray.getInt(i);
                            String name = nameArray.getString(i);
                            String gender = genderArray.getString(i);
                            double marks = marksArray.getDouble(i);

                            SQLData data = new SQLData(rollno, name, gender, marks);
                            students.add(data);

                            Log.d("Students Data", students.toString());
                        }
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SQLSelect.this, "Error connecting", Toast.LENGTH_LONG).show();
                Log.d("Volley Error", error.toString());
            }
        });

        queue.add(request);
    }
}