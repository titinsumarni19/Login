package com.titinsumarni202102246.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivityCuaca extends AppCompatActivity {
    private RecyclerView _recyclerView1;
    private SwipeRefreshLayout _swipeRefreshLayout1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cuaca);

        _recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        _swipeRefreshLayout1 = findViewById(R.id.swipeRefreshLayout1);

        initRecyclerView1();
        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout()
    {
        _swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initSwipeRefreshLayout();
                _swipeRefreshLayout1.setRefreshing(false);
            }
        });
    }

    private void initRecyclerView1(){
        String url = "https://api.openweathermap.org/data/2.5/forecast?id=1630789&appid=ba8c960383bb17d0b62ed0c0f78bfeaa";
        AsyncHttpClient ahc = new AsyncHttpClient();

        ahc.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //Log.d("*tw*", new String(responseBody));
                Gson gson = new Gson();
                RootModel rm = gson.fromJson(new String(responseBody), RootModel.class);
                //Log.d("*tw*", rm.getListModelList().get(0).getDt_txt());
                RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivityCuaca.this);
                CuacaAdapter ca = new CuacaAdapter(rm);

                _recyclerView1.setLayoutManager(lm);
                _recyclerView1.setAdapter(ca);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
