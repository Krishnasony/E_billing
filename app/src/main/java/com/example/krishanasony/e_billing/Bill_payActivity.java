package com.example.krishanasony.e_billing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bill_payActivity extends AppCompatActivity {
    EditText sc_no,con_nm,b_dat;
    Button sub_btn;
    FirebaseDatabase db;
    DatabaseReference Bill_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay);
        db  = FirebaseDatabase.getInstance();
        Bill_pay =db.getReference("Bill_pay").push();

        sc_no = findViewById(R.id.sc_no);
        con_nm = findViewById(R.id.con_nm);
        b_dat = findViewById(R.id.b_dat);
        //current_unit = findViewById(R.id.current_unit);

        sub_btn = findViewById(R.id.sub_btn);

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bill_payActivity.this,Pay.class));
                final String servicenumber = sc_no.getText().toString().trim();
                final String coonsumername = con_nm.getText().toString().trim();
                final String billingdate = b_dat.getText().toString().trim();
               // final String currentUnit = current_unit.getText().toString().trim();

                Bill_pay.child("serviceNumber").setValue(servicenumber);
                Bill_pay.child("consumerName").setValue(coonsumername);
                Bill_pay.child("billingDate").setValue(billingdate);
              // Bill_pay.child("currentUnit").setValue(current_unit);
                Toast.makeText(getApplicationContext(), "To Confirm payment Click On Pay Button", Toast.LENGTH_LONG).show();
            }

            });
        }
    }