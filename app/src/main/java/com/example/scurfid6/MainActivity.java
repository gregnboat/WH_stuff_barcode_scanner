package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scurfid6.apihelper.BaseApiService;
import com.example.scurfid6.apihelper.UtilsAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button   btnLogin;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    private static String JSON_URL = "https://run.mocky.io/v3/46f0f9ad-9baf-4bd3-87b2-abdbd1c18876";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mApiService = UtilsAPI.getAPIService(); // meng-init yang ada di package apihelper
        initComponents();
    }

    private void initComponents() {
        etUsername = (EditText) findViewById(R.id.edtUsername);
        etPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(MainActivity.this, null, "Please Wait...", true, false);
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        mApiService.loginRequest(etUsername.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("code").equals("200")) {
                                    Toast.makeText(MainActivity.this, "LOGIN SUCCESS!", Toast.LENGTH_SHORT).show();
                                    String name = jsonRESULTS.getString("user");
                                    Log.d("test", name);
                                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                    intent.putExtra("result_name", name);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If login fails
                                    String error_message = jsonRESULTS.getString("ERROR");
                                    Toast.makeText(MainActivity.this, "Login Error! : "+error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e){
                                e.printStackTrace();
                            } catch (IOException  e){
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        Toast.makeText(MainActivity.this, "LOGIN ERROR: Wrong Password or Username!", Toast.LENGTH_SHORT).show();
                        loading.dismiss();

                    }
                });
    }
}