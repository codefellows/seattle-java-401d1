package com.example.moonmayor.sessionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.clicker)
    Button clicker;

    private String mCookie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.clicker)
    public void request() {
        RequestQueue qq = Volley.newRequestQueue(this);

        String url = "http://10.0.2.2:8080/session";
        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                if (mCookie != null) {
                    map.put("Cookie", mCookie);
                }
                return map;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                for (Map.Entry<String, String> entry : response.headers.entrySet()) {
                    System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
                    if (entry.getKey().equals("Set-Cookie")) {
                        mCookie = entry.getValue();
                    }
                }
                return super.parseNetworkResponse(response);
            }
        };

        qq.add(req);
    }
}
