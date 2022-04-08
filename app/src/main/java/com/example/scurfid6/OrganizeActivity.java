package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.scurfid6.apihelper.BaseApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganizeActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData = new ArrayList<>();
    private SwipeRefreshLayout srlData;
    private ProgressBar progressBar;
    private FloatingActionButton fabAdd;

    //ImageView scu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organize);

        rvData = findViewById(R.id.rv_data);
        srlData = findViewById(R.id.srl_data);
        progressBar = findViewById(R.id.pb_data);
        fabAdd = findViewById(R.id.fab_add);

        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        //retrieveData();

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                retrieveData();
                srlData.setRefreshing(false);
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrganizeActivity.this, AddActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData(){
        progressBar.setVisibility(View.VISIBLE);

        BaseApiService ardData = RetroServer.connectRetrofit().create(BaseApiService.class);
        Call<ResponseModel> showData = ardData.ardRetrieveData();

        showData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int code = response.body().getCode();
                String message = response.body().getMessage();

                //Toast.makeText(MainActivity.this, "Code : "+code+" | Message : "+message, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();

                adData = new AdapterData(OrganizeActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(OrganizeActivity.this, "Failed to Connect: "+t.getMessage(), Toast.LENGTH_SHORT).show();

                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }





//        scu = findViewById(R.id.imgOrgSCU);
//
//        Glide.with(this).load("http://www.scu.co.id/image/logoscu.png").into(scu);
}