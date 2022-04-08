package com.example.scurfid6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView scanBC, listBC, organizeBC, logBC;
    private TextView tvNameResult, tvUpdates;
    private String resultName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        scanBC = (ImageView) findViewById(R.id.bScan);
        scanBC.setOnClickListener(this);

        listBC = (ImageView) findViewById(R.id.bBList);
        listBC.setOnClickListener(this);

        organizeBC = (ImageView) findViewById(R.id.bOrganize);
        organizeBC.setOnClickListener(this);

        logBC = (ImageView) findViewById(R.id.bLog);
        logBC.setOnClickListener(this);

        tvUpdates = (TextView) findViewById(R.id.textUpdates);
        tvUpdates.setOnClickListener(this);





        initComponents();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultName = extras.getString("result_name");
        tvNameResult.setText(resultName);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bScan:
                scanCode();
                break;
        }
        switch (view.getId()){
            case R.id.bBList:
                Intent showBBList = new Intent(MenuActivity.this, BarcodeListActivity.class);
                startActivity(showBBList);
                break;
        }
        switch (view.getId()){
            case R.id.bOrganize:
                Intent showBOrganize = new Intent(MenuActivity.this, OrganizeActivity.class);
                startActivity(showBOrganize);
                break;
        }
        switch (view.getId()){
            case R.id.bLog:
                Intent showBLog = new Intent(MenuActivity.this, LogSessionActivity.class);
                startActivity(showBLog);
                break;
        }
        switch (view.getId()){
            case R.id.textUpdates:
                Intent showUpdates = new Intent(MenuActivity.this, UpdateActivity.class);
                startActivity(showUpdates);
                break;
        }



    }



    private void initComponents() {
        tvNameResult = (TextView) findViewById(R.id.textUsername);
    }

    private void scanCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(Capture.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Put the barcode on the highlighted square ");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Scanning Result");
                builder.setPositiveButton("More Details", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String bcCode = result.getContents();
                        Log.d("bcdReport", bcCode);
                        Intent iBC = new Intent(MenuActivity.this, BCDetailsActivity.class);
                        iBC.putExtra("details_result", bcCode);
                        startActivity(iBC);

                    }
                }).setNegativeButton("finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        putDataForDetails();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                Toast.makeText(this, "No Results", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void putDataForDetails() {

    }
}