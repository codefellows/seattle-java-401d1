package com.example.moonmayor.imagelistviews.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.moonmayor.imagelistviews.DownloadImage;
import com.example.moonmayor.imagelistviews.R;

import java.util.List;

/**
 * Created by moonmayor on 10/5/17.
 */
public class ImageListAdapter extends BaseAdapter {
    private int layoutId;
    private Context mContext;
    private List<String> mUrls;

    public ImageListAdapter(Context context, int resource, List<String> bitmaps) {
        layoutId = resource;
        mContext = context;
        mUrls = bitmaps;
    }

    public void add(String url) {
        mUrls.add(url);
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return mUrls.get(position);
    }

    @Override
    public long getItemId(int i) {
        return this.getItem(i).hashCode();
    }

    @Override
    public boolean isEmpty() {
        return mUrls.isEmpty();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }

        ImageView image = convertView.findViewById(R.id.image);

        String url = this.getItem(position);
        Log.d("URL", url);
        if (url.contains("http")) {
            (new DownloadImage(mContext, url, image)).execute();
        } else {
            // rename url to photoPath, just to make more sense.
            String photoPath = url;
            Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
            image.setImageBitmap(bitmap);
        }

        return convertView;
    }

    public class ViewHolder {
        ImageView mImageView;

        public ViewHolder(View view) {
            mImageView = (ImageView) view.findViewById(R.id.image);
        }
    }
}
