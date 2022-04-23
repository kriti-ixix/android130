package com.kriti.android1_30;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImages extends AppCompatActivity {

    String imageURL = "https://i.pinimg.com/564x/1b/7d/a7/1b7da7f7aa7d36e40dda8c4c3f9b7981.jpg";
    Button button; ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_images);
        button = findViewById(R.id.downloadButton);
        imageView = findViewById(R.id.downloadImageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    ImageDownload task = new ImageDownload();
                    Bitmap bitmap = task.execute(imageURL).get();
                    imageView.setImageBitmap(bitmap);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public class ImageDownload extends AsyncTask<String, Void, Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... strings)
        {
            try
            {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
    }
}