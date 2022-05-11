package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Movies extends AppCompatActivity {

    ArrayList<String> moviesList = new ArrayList<>();
    RecyclerView recyclerView;
    Button addMovieButton;
    EditText movieEditText;
    CustomAdapter adapter;
    String tag = "Recycler View";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        movieEditText = findViewById(R.id.movieEditText);
        addMovieButton = findViewById(R.id.addMovieButton);
        recyclerView = findViewById(R.id.movieRecyclerView);

        moviesList.add("Harry Potter");
        moviesList.add("Doctor Strange");
        moviesList.add("Spiderman");
        moviesList.add("Lekh");
        moviesList.add("Qismat");
        moviesList.add("Gangubai");

        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movie = movieEditText.getText().toString();
                moviesList.add(movie);
                adapter.notifyDataSetChanged();
            }
        });
    }

    class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
    {
        // Registering of components
        class CustomViewHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView;
            TextView textView;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                Log.d(tag, "View Holder");
                imageView = itemView.findViewById(R.id.customRecyclerImage);
                textView = itemView.findViewById(R.id.customRecyclerText);
            }
        }

        // Display your layout
        @NonNull
        @Override
        public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d(tag, "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(Movies.this);
            View view = inflater.inflate(R.layout.custom_recycler_adapter, parent, false);
            return new CustomAdapter.CustomViewHolder(view);
        }

        // When the view is loaded
        @Override
        public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
            Log.d(tag, "onBindViewHolder");
            String movie = moviesList.get(position);
            holder.textView.setText(movie);
        }

        // Number of items to display
        @Override
        public int getItemCount() {
            Log.d(tag, "getItemCount");
            return moviesList.size();
        }
    }
}