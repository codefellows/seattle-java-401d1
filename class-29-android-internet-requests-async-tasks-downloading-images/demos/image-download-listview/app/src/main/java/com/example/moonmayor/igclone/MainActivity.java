package com.example.moonmayor.igclone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private final int REQUEST_PICK_PICTURE = 2;

    private TextView mInfo;
    private Button mTakePicture;
    private Button mPickPicture;
    private Button mDownloadPicture;
    private ImageView mImageResult;

    private ListView mImageList;
    private ImageAdapter mAdapter;
    private List<String> mImageUrls;

    // A spot to remember what file we told the camera to
    // save the last picture to.
    private String mCurrentPhotoFilepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfo = (TextView) findViewById(R.id.info);
        mTakePicture = (Button) findViewById(R.id.takePicture);
        mPickPicture = (Button) findViewById(R.id.pickPicture);
        mDownloadPicture = (Button) findViewById(R.id.downloadPicture);
        mImageResult = (ImageView) findViewById(R.id.imageResult);

        mImageUrls = MockDatabase.allImages;
        mImageList = (ListView) findViewById(R.id.imageList);
        mAdapter = new ImageAdapter(this, R.layout.image_item, mImageUrls);
        mImageList.setAdapter(mAdapter);

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
                pickPicture();
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
            File imageFile = getPictureFile();
            Uri photoUri = FileProvider.getUriForFile(this,
                    "com.example.moonmayor.igclone",
                    imageFile);

            // tell the camera to save the picture to a file
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } catch(IOException e) {
            String error = "Error: " + e.getMessage();
            Log.d("FILE ERROR", error);
            mInfo.setText(error);
        }
    }

    private void pickPicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        Intent chooser = Intent.createChooser(intent, "Select Picture");
        startActivityForResult(chooser, REQUEST_PICK_PICTURE);
    }

    private void downloadPicture() {
        String url = MockDatabase.image1;
        (new DownloadImageTask(this, url, mImageResult)).execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE) {
            // read the Bitmap from the file we saved the picture to
            // and load it in the ImageView.
            setPictureFromFile();
            galleryAddPic();
        } else if (resultCode == RESULT_OK && requestCode == REQUEST_PICK_PICTURE) {
            setPictureFromGallery(data);
        }
    }

    private File getPictureFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "JPEG_" + timestamp + "_";
        File directory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = File.createTempFile(filename, // prefix
                ".jpg",
                directory);

        // save the filename
        mCurrentPhotoFilepath = file.getAbsolutePath();

        return file;
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoFilepath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void setPictureFromFile() {
        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoFilepath);
        mImageResult.setImageBitmap(bitmap);
    }

    private void setPictureFromGallery(Intent data) {
        try {
            InputStream stream = this.getContentResolver().openInputStream(data.getData());
            Bitmap galleryPicture = BitmapFactory.decodeStream(stream);
            mImageResult.setImageBitmap(galleryPicture);
        } catch (FileNotFoundException e) {
            mInfo.setText("Error: " + e.getMessage());
        }
    }
}
