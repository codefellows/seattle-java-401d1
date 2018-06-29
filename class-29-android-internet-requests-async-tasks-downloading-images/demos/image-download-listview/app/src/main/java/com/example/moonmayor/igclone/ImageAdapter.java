package com.example.moonmayor.igclone;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by moonmayor on 10/5/17.
 */

public class ImageAdapter extends ArrayAdapter<String> {
    Context mContext;
    List<String> mUrls;
    int mLayoutId;

    public ImageAdapter(Context context, int resource, List<String> urls) {
        super(context, resource, urls);
        mContext = context;
        mLayoutId = resource;
        mUrls = urls;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.downloadedImage);
        String url = mUrls.get(position);

        (new DownloadImageTask(mContext, url, image)).execute();

        return convertView;
    }
}
