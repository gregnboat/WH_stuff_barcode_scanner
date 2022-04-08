package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scurfid6.apihelper.BaseApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeActivity extends AppCompatActivity {

    private int xId;
    private String xName, xUsername, xPassword;
    private EditText etName, etUsername, etPassword;
    private Button btnChange;
    private String yName, yUsername, yPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Intent receive = getIntent();
        xId = receive.getIntExtra("xId", -1);
        xName = receive.getStringExtra("xName");
        xUsername = receive.getStringExtra("xUsername");
        xPassword = receive.getStringExtra("xPassword");

        etName = findViewById(R.id.et_ch_name);
        etUsername = findViewById(R.id.et_ch_username);
        etPassword = findViewById(R.id.et_ch_password);
        btnChange = findViewById(R.id.btn_ch_user_data);

        etName.setText(xName);
        etUsername.setText(xUsername);
        etPassword.setText(xPassword);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yName = etName.getText().toString();
                yUsername = etUsername.getText().toString();
                yPassword = etPassword.getText().toString();

                updateData();
            }
        });

    }

    private void updateData(){
        BaseApiService ardData = RetroServer.connectRetrofit().create(BaseApiService.class);
        Call<ResponseModel> updateData = ardData.ardUpdateData(xId, yName, yUsername, yPassword);

        updateData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int code = response.body().getCode();
                String message = response.body().getMessage();

                Toast.makeText(ChangeActivity.this, "Code : "+code+" | Message : "+message, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(ChangeActivity.this, "Failed to connect to Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}