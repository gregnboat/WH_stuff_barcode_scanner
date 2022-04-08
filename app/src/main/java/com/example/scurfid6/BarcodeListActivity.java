package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BarcodeListActivity extends AppCompatActivity {

    ImageView scu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_list);

        scu = findViewById(R.id.imgSCU);

        Glide.with(this).load("http://www.scu.co.id/image/logoscu.png").into(scu);
    }
}