package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    TextView tvNameResult;
    String resultName;
    Button scanIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        scanIntent = (Button) findViewById(R.id.buttonScanIntent);
        Intent intent = new Intent(HomePageActivity.this, ScanBarcodeActivity.class);
        startActivity(intent);

        initComponents();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultName = extras.getString("result_name");
            tvNameResult.setText(resultName);

    }

    private void initComponents() {
        tvNameResult = (TextView) findViewById(R.id.tvResultName);
    }
}