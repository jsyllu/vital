package com.numad21fa.vital.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.numad21fa.vital.R;

// FDC WebService TEST Activity
public class FDCWebServiceActivity extends AppCompatActivity {
    Button btn_getFDCID, btn_getNutrientsByFDCID;
    EditText editText_dataInput;
    ListView list_view_FDC_results;
    String entered_food_name;

    FDCWebService foodWebService = new FDCWebService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdcweb_service);
        btn_getFDCID = findViewById(R.id.btn_getFDCID);
        btn_getNutrientsByFDCID = findViewById(R.id.btn_getNutrientsByFDCID);
        editText_dataInput = findViewById(R.id.editText_dataInput);
        list_view_FDC_results = findViewById(R.id.list_view_FDC_results);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_getFDCID:
                //
                foodWebService.getFoodID(editText_dataInput.getText().toString(), new FDCWebService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(FDCWebServiceActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(String fdcID) {
                        Toast.makeText(FDCWebServiceActivity.this, "Return " + fdcID, Toast.LENGTH_SHORT).show();
                        editText_dataInput.setText(fdcID);
                        entered_food_name = editText_dataInput.getText().toString();
                        Log.i("WebActivityResponse", entered_food_name);

                    }
                });
                break;
        }

    }
}