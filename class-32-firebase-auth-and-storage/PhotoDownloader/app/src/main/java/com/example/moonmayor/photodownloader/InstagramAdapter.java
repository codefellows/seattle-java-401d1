package com.example.moonmayor.photodownloader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstagramAdapter extends RecyclerView.Adapter<InstagramAdapter.MyViewHolder> {
    private List<InstagramPost> mFeed;

    public InstagramAdapter() {
        mFeed = new ArrayList<>();
    }

    public InstagramAdapter(List<InstagramPost> feed) {
        mFeed = feed;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.instagram_feed_post, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InstagramPost post = mFeed.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return mFeed.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public ImageView mImage;
        public TextView mAuthor;
        public TextView mDescription;

        private InstagramPost mPost;

        public MyViewHolder(View view) {
            super(view);
            mView = view;

            mImage = view.findViewById(R.id.image);
            mAuthor = view.findViewById(R.id.author);
            mDescription = view.findViewById(R.id.description);
        }

        public void bind(InstagramPost post) {
            mPost = post;
            mAuthor.setText(post.author);
            mDescription.setText(post.description);

            Ion.with(mImage)
                    .placeholder(R.drawable.loading)
                    .load(mPost.imageUrl);
        }
    }
}
