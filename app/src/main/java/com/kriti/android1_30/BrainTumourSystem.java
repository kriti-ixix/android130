package com.kriti.android1_30;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.kriti.android1_30.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.nio.ByteBuffer;

public class BrainTumourSystem extends AppCompatActivity {

    ImageView imageView;
    Button button;
    TextView textView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_tumour_system);

        imageView = findViewById(R.id.mriImageView);
        button = findViewById(R.id.getPredictionButton);
        textView = findViewById(R.id.tfPredictionText);

        imageView.setOnClickListener(getImageListener);
        button.setOnClickListener(getPredictionListener);
    }

    View.OnClickListener getImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ImagePicker.with(BrainTumourSystem.this)
                    .cropSquare()
                    .galleryOnly()
                    .compress(1024)
                    .start();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        imageView.setImageURI(uri);

        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    View.OnClickListener getPredictionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                // Normalising the image
                bitmap = Bitmap.createScaledBitmap(bitmap, 128, 128, true);
                Model model = Model.newInstance(getApplicationContext());

                // Converting image to array
                TensorBuffer inputFeatures = TensorBuffer.createFixedSize(new int[]{1, 128, 128, 3}, DataType.FLOAT32);
                TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                tensorImage.load(bitmap);
                ByteBuffer byteBuffer = tensorImage.getBuffer();
                inputFeatures.loadBuffer(byteBuffer);

                // Send the array/tensor to the model and get the output
                Model.Outputs outputs = model.process(inputFeatures);
                TensorBuffer outputFeatures = outputs.getOutputFeature0AsTensorBuffer();

                // Finish the model
                model.close();

                // Finding the final output with the highest probability
                int maxIndex = 0;
                String predictionOutput = "Prediction: ";

                for (int i = 0; i < outputFeatures.getFloatArray().length; i++)
                {
                    if (outputFeatures.getFloatArray()[i] > outputFeatures.getFloatArray()[maxIndex])
                        maxIndex = i;
                }

                switch (maxIndex)
                {
                    case 0:
                        predictionOutput += "No Tumour";
                        break;

                    case 1:
                        predictionOutput += "Glioma Tumour";
                        break;

                    case 2:
                        predictionOutput += "Meningioma Tumour";
                        break;

                    case 3:
                        predictionOutput += "Pituatiary Tumour";
                }

                textView.setText(predictionOutput);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    };
}