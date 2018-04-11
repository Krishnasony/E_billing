package com.example.krishanasony.e_billing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.krishanasony.e_billing.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.util.ResourceBundle;

public class Paymentdetails extends AppCompatActivity {
    TextView txtid,txtamt,txtstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentdetails);
        TextView txtid = (TextView) findViewById(R.id.txtid);
        TextView txtstatus = (TextView) findViewById(R.id.txtstatus);
        TextView txtamt = (TextView) findViewById(R.id.txtamt);


        //Getting Intent
        Intent intent = getIntent();
        try {
            JSONObject jsonDetails = new JSONObject(intent.getStringExtra("PaymentDetails"));
            //Displaying payment details
            showDetails(jsonDetails.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject jsonObject, String paymentAmount) throws JSONException {

        //Showing the details from json object
        try {
            txtid.setText(jsonObject.getString("id"));
            txtstatus.setText(jsonObject.getString("state"));
            txtamt.setText(paymentAmount + " USD");
            ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}