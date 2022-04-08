package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scurfid6.apihelper.BaseApiService;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    private EditText etName, etUsername, etPassword;
    private Button btnCreate;
    private String name, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etName = findViewById(R.id.et_name);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnCreate = findViewById(R.id.btn_create);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if (name.trim().equals("")) {
                    etName.setError("Name is mandatory.");
                } else if (username.trim().equals("")) {
                    etUsername.setError("Username is mandatory.");
                } else if (password.trim().equals("")) {
                    etPassword.setError("Password is Mandatory.");
                } else {
                    createData();

                }
            }
        });
    }

    private void createData(){
        BaseApiService ardData = RetroServer2.connectRetrofit().create(BaseApiService.class);
        Call<ResponseModel> saveData = ardData.ardCreateData(name, username, password);
        saveData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()){
                    JSONObject newUser = new JSONObject();
                    try {
                        newUser.put("name", "name");
                        newUser.put("username", "username");
                        newUser.put("password", "password");
                        Toast.makeText(AddActivity.this, "Create User succeeded.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddActivity.this, LandingActivity.class);
                        startActivity(intent);
                        finish();

                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
                Toast.makeText(AddActivity.this, "LOGIN ERROR: Wrong Password or Username!"+t.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddActivity.this, LandingActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        JSONObject jCreateUser = new JSONObject();
//        try {
//            jCreateUser.put("name", "name");
//            jCreateUser.put("username", "username");
//            jCreateUser.put("password", "password");
//
//        } catch (JSONException e){
//            e.printStackTrace();
//        }

//        saveData.enqueue(new Callback<ResponseModel>() {
//            @Override
//            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                int code = response.body().getCode();
//                String message = response.body().getMessage();
//
//                Toast.makeText(AddActivity.this, "Code : "+code+" | Message : "+message, Toast.LENGTH_SHORT).show();
//                finish();
//            }
//
//            @Override
//            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                Toast.makeText(AddActivity.this, "Failed to connect to Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}