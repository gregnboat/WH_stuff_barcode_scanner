package com.example.scurfid6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class BCDetailsActivity extends AppCompatActivity {

    TextView tvBarcode, tvTableName, tvOldLocation2, tvStorageLocation2, tvNewLocation, tvStorageAt,
            tvClientID, tvOrderState, tvObjectID, tvSuratDataBaru, tvDateIn, tvDateOut,
            tvCodeCharge, tvCheckDate, tvCheckBy, tvMedium, tvRFID, tvLocationInit, tvOldLocation,
            tvStorageLocation;
    String resultBCName;
    private ProgressBar progressBar;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcdetails);

        tvBarcode = findViewById(R.id.textViewBarcodeDetails);
        tvTableName = findViewById(R.id.textViewTableName);
        tvOldLocation2 = findViewById(R.id.textViewOldLocation2);
        tvStorageLocation2 = findViewById(R.id.textViewStorageLocation2);
        tvNewLocation = findViewById(R.id.textViewNewLocation);
        tvStorageAt = findViewById(R.id.textViewStorageAt);
        tvClientID = findViewById(R.id.textViewClientID);
        tvOrderState = findViewById(R.id.textViewOrderState);
        tvObjectID = findViewById(R.id.textViewObjectID);
        tvSuratDataBaru = findViewById(R.id.textViewSuratDataBaru);
        tvDateIn = findViewById(R.id.textViewDateIn);
        tvDateOut = findViewById(R.id.textViewDateOut);
        tvCodeCharge = findViewById(R.id.textViewCodeCharge);
        tvCheckDate = findViewById(R.id.textViewCheckDate);
        tvCheckBy = findViewById(R.id.textViewCheckBy);
        tvMedium = findViewById(R.id.textViewMedium);
        tvRFID = findViewById(R.id.textViewRFID);
        tvLocationInit = findViewById(R.id.textViewLocationInit);
        tvOldLocation = findViewById(R.id.textViewOldLocation1);
        tvStorageLocation = findViewById(R.id.textViewStorageLocation1);
        progressBar = findViewById(R.id.progressBar);



        progressBar = findViewById(R.id.progressBar);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultBCName = extras.getString("details_result");
        Log.d("BCResult", resultBCName);

        getDataDetails();


    }

    private void getDataDetails() {
        progressBar.setVisibility(View.VISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://portal.scu.co.id:1882/v1/skk/?barcode=" + resultBCName;
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // If Connection Success
                progressBar.setVisibility(View.INVISIBLE);
                String result = new String(responseBody);
                Log.d(TAG, result);
                try {
                    JSONObject responseObject = new JSONObject(result);

                    String barcode = responseObject.getString("BARCODE");
                    String table_name = responseObject.getString("TABLE_NAME");
                    String old_location2 = responseObject.getString("OLD_LOCATION2");
                    String storage_location2 = responseObject.getString("STORAGE_LOCATION2");
                    String new_location = responseObject.getString("NEW_LOCATION");
                    String storage_at = responseObject.getString("STORAGE_AT");
                    String client_id = responseObject.getString("CLIENT_ID");
                    String order_state = responseObject.getString("ORDER_STATE");
                    String object_id = responseObject.getString("OBJECT_ID");
                    String surat_data_baru = responseObject.getString("SURAT_DATA_BARU");
                    String date_in = responseObject.getString("DATE_IN");
                    String date_out = responseObject.getString("DATE_OUT");
                    String code_charge = responseObject.getString("CODE_CHARGE");
                    String check_date = responseObject.getString("CHECK_DATE");
                    String check_by = responseObject.getString("CHECK_BY");
                    String medium = responseObject.getString("MEDIUM");
                    String rfid = responseObject.getString("RFID");
                    String location_init = responseObject.getString("LOCATION_INIT");
                    String old_location = responseObject.getString("OLD_LOCATION");
                    String storage_location = responseObject.getString("STORAGE_LOCATION");

                    tvBarcode.setText(barcode);
                    tvTableName.setText(table_name);
                    tvOldLocation2.setText(old_location2);
                    tvStorageLocation2.setText(storage_location2);
                    tvNewLocation.setText(new_location);
                    tvStorageAt.setText(storage_at);
                    tvClientID.setText(client_id);
                    tvOrderState.setText(order_state);
                    tvObjectID.setText(object_id);
                    tvSuratDataBaru.setText(surat_data_baru);
                    tvDateIn.setText(date_in);
                    tvDateOut.setText(date_out);
                    tvCodeCharge.setText(code_charge);
                    tvCheckDate.setText(check_date);
                    tvMedium.setText(medium);
                    tvRFID.setText(rfid);
                    tvCheckBy.setText(check_by);
                    tvLocationInit.setText(location_init);
                    tvOldLocation.setText(old_location);
                    tvStorageLocation.setText(storage_location);

                } catch (JSONException e) {
                    Toast.makeText(BCDetailsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // If connection fails
                progressBar.setVisibility(View.INVISIBLE);

                String errorMessage;
                switch (statusCode) {
                    case 401:
                        errorMessage = statusCode + " : Bad Request";
                        break;
                    case 403:
                        errorMessage = statusCode + " : Forbidden";
                        break;
                    case 404:
                        errorMessage = statusCode + " : Not Found";
                        break;
                    default:
                        errorMessage = statusCode + " : " + error.getMessage();
                        break;
                }
                Toast.makeText(BCDetailsActivity.this, errorMessage, Toast.LENGTH_SHORT);

            }
        });


    }
}