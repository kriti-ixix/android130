package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicPlaylist extends AppCompatActivity {

    ListView listView;
    ArrayList<String> albumList = new ArrayList<>();
    ArrayList<Integer> coverList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_playlist);

        listView = findViewById(R.id.playlistListView);

        albumList.add("Crazy In Love");
        albumList.add("Excuses");
        albumList.add("Midnight Guest");
        albumList.add("Thrilling");
        albumList.add("Universe");
        albumList.add("Youngblood");

        coverList.add(R.drawable.crazy_in_love);
        coverList.add(R.drawable.excuses);
        coverList.add(R.drawable.midnight_guest);
        coverList.add(R.drawable.thrilling);
        coverList.add(R.drawable.universe);
        coverList.add(R.drawable.youngblood);

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return albumList.size();
        }

        @Override
        public Object getItem(int i) {
            return albumList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
            {
                view = getLayoutInflater().inflate(R.layout.custom_layout, viewGroup, false);
            }

            ImageView imageView = view.findViewById(R.id.customInageView);
            TextView textView = view.findViewById(R.id.customTextView);

            textView.setText(albumList.get(i));
            imageView.setImageResource(coverList.get(i));

            return view;
        }
    }
}