package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Movies extends AppCompatActivity {

    ArrayList<String> moviesList = new ArrayList<>();
    RecyclerView recyclerView;
    Button addMovieButton;
    EditText movieEditText;

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
    }

    class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
    {
        // Registering of components
        class CustomViewHolder extends RecyclerView.ViewHolder
        {
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

        // Display your layout
        @NonNull
        @Override
        public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        // When the view is loaded
        @Override
        public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {

        }

        // Number of items to display
        @Override
        public int getItemCount() {
            return 0;
        }
    }
}