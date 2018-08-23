package com.example.moonmayor.myinstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedActivity extends AppCompatActivity {

    @BindView(R.id.feed) public RecyclerView recyclerView;
    public LinearLayoutManager linearLayoutManager;
    public PostAdater postAdapter;

    private List<Post> mPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        ButterKnife.bind(this);

        mPosts = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(this);
        postAdapter = new PostAdater();
        postAdapter.setPosts(mPosts);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(postAdapter);
    }

    @OnClick(R.id.post)
    public void post() {
        Log.d("POST", "posting");

        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }
}
