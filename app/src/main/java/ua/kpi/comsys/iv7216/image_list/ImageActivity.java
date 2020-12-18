package ua.kpi.comsys.iv7216.image_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import ua.kpi.comsys.iv7216.R;

public class ImageActivity extends AppCompatActivity {
    private final ImageView[] imageViews = new ImageView[20];
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        findViewByID();

        Button PickImage = findViewById(R.id.buttonPicture);
        PickImage.setOnClickListener(view -> {
            counter += 1;
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, counter);
        });
    }

    private void findViewByID() {
        for (int i = 0; i < imageViews.length; i++) {
            String imageID = "imageView" + (i + 1);
            int resID = getResources().getIdentifier(imageID, "id", getPackageName());
            imageViews[i] = findViewById(resID);
        }
    }

    private void setImage(ImageView imView, int resultCode, Intent imageReturnedIntent) {
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = imageReturnedIntent.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imView.setImageBitmap(selectedImage);
                imView.setBackgroundColor(Color.rgb(105, 105, 105));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        setImage(imageViews[requestCode - 1], resultCode, imageReturnedIntent);
    }
}
