package com.example.moonmayor.imagelistviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moonmayor on 10/5/17.
 */

public class DownloadImage extends AsyncTask<Void, Void, Bitmap> {
    // have one map that relates URLs to their Bitmaps for all class instances.
    private static Map<String, Bitmap> cache = new HashMap<>();

    // settings to add enable and configure a fake network delay for downloading images.
    private final int FAKE_DELAY = 1500;
    private final boolean ENABLE_FAKE_DELAY = false;

    private Context mContext;
    private String mUrl;
    private ImageView mImageView;



    public DownloadImage(Context context, String url, ImageView view) {
        mContext = context;
        mUrl = url;
        mImageView = view;
    }

    @Override
    protected void onPreExecute() {
        //Drawable placeholder = mContext.getResources().getDrawable(R.drawable.placeholder);
        //mImageView.setImageDrawable(placeholder);
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        try {
            URL url = new URL(mUrl);
            // if the URL exists in the class-wide cache then quickly return the Bitmap.
            if (false && cache.containsKey(mUrl)) {
                return cache.get(mUrl);
            } else {
                // Otherwise, fetch the Bitmap from the internet, and add some fake delay to
                // really drive the point home.
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                if (ENABLE_FAKE_DELAY) {
                    Thread.sleep(FAKE_DELAY);
                }

                // store the bitmap in the cache.
                cache.put(mUrl, bitmap);

                return bitmap;
            }
        } catch (IOException e) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            mImageView.setImageBitmap(bitmap);
        }
    }
}
