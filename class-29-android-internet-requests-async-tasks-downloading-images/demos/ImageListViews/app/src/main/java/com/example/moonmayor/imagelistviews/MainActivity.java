package com.example.moonmayor.imagelistviews;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moonmayor.imagelistviews.adapters.ImageListAdapter;
import com.example.moonmayor.imagelistviews.mockdata.UnsplashImages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // our own code to recognize the intent when it returns.
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private final int REQUEST_PICK_IMAGE = 2;

    private TextView mInfo;
    private ImageView mImageResult;
    private Button mTakePicture;
    private Button mPickPicture;
    private Button mDownloadPicture;

    private List<String> mImageUrls;
    private ListView mImageList;
    private ListAdapter mImageListAdapter;

    // filepath to the most recently taken photo.
    private String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfo = (TextView) findViewById(R.id.info);
        mTakePicture = (Button) findViewById(R.id.takePicture);
        mPickPicture = (Button) findViewById(R.id.pickPicture);
        mDownloadPicture = (Button) findViewById(R.id.downloadPicture);
        mImageResult = (ImageView) findViewById(R.id.imageResult);

        mImageUrls = UnsplashImages.allUrls;

        mImageList = (ListView) findViewById(R.id.imageList);
        mImageListAdapter = new ImageListAdapter(getApplicationContext(), R.layout.image_list_item, mImageUrls);
        mImageList.setAdapter(mImageListAdapter);

        attachClickListeners();
    }

    private void attachClickListeners() {
        mTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        mPickPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchPickPictureIntent();
            }
        });

        mDownloadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadPicture();
            }
        });
    }

    private void takePicture() {
        try {
            File file = createImageFile();
            Uri imageUri = FileProvider.getUriForFile(this, "com.example.moonmayor.imagelistviews", file);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } catch (IOException e) {
           mInfo.setText("Error: " + e.getMessage());
        }
    }

    private void dispatchPickPictureIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_PICK_IMAGE);
    }

    private void downloadPicture() {
        String imageUrl = UnsplashImages.randomUrl();
        (new DownloadImage(this.getApplicationContext(), imageUrl, mImageResult)).execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE) {
            // add the picture to the ImageView
            setPic();
            // notify the gallery that there's a new picture to add to the gallery.
            galleryAddPic();
        }
    }

    private File createImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFilename = "JPEG_" + timestamp + "_";
        // Unfortunately this doesn't work on the emulator
        // File storageDir = Environment.getExternalFilesDirectory(Environment.DIRECTORY_PICTURES);
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFilename, ".jpg", storageDir);

        // save a reference to where we're storing the photo.
        mCurrentPhotoPath = image.getAbsolutePath();

        return image;
    }

    private void setPic() {
        mImageUrls.add(mCurrentPhotoPath);
       //Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
       //mImageResult.setImageBitmap(bitmap);
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }
}
