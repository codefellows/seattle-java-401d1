package com.example.moonmayor.photodownloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstagramActivity extends AppCompatActivity {
    @BindView(R.id.recycler) public RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private InstagramAdapter mInstagramAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_feed);

        ButterKnife.bind(this);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mInstagramAdapter = new InstagramAdapter(InstagramData.slothprovider);
        mRecyclerView.setAdapter(mInstagramAdapter);
    }
}
