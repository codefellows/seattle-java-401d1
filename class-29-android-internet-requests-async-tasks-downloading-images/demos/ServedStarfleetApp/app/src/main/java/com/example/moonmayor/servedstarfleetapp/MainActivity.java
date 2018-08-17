package com.example.moonmayor.servedstarfleetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private StarfleetAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.list);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new StarfleetAdapter();
        mRecyclerView.setAdapter(mAdapter);

        fetchData();
    }

    private void fetchData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://secret-depths-71697.herokuapp.com/api/starfleet";

        StringRequest req = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("starfleet", "success!");

                Gson gson = new Gson();
                StarfleetPersonnel[] persons =
                        gson.fromJson(response, StarfleetPersonnel[].class);

                List<StarfleetPersonnel> borg = new ArrayList<>();
                borg.add(persons[0]);
                borg.add(persons[1]);
                borg.add(persons[2]);

                for (int i = 0; i < 400; i++) {
                    int num1 = (int) Math.floor(12 * Math.random());
                    int num2 = (int) Math.floor(12 * Math.random());
                    String name = num1 + " of " + num2;
                    borg.add(new StarfleetPersonnel(name, "Drone", ""));
                }

                StarfleetPersonnel[] longList = new StarfleetPersonnel[borg.size()];
                borg.toArray(longList);

                mAdapter = new StarfleetAdapter(longList);
                mRecyclerView.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("starfleet", "error!");
            }
        });

        queue.add(req);
    }
}
