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
    EditText sc_no,con_nm,b_dat,amt_txt;
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
        amt_txt = findViewById(R.id.amt_txt);
        sub_btn = findViewById(R.id.sub_btn);
        TextView click = findViewById(R.id.clickhere);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bill_payActivity.this,Pay.class));
            }
        });

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String servicenumber = sc_no.getText().toString().trim();
                final String coonsumername = con_nm.getText().toString().trim();
                final String billingdate = b_dat.getText().toString().trim();
                final String totalamount = amt_txt.getText().toString().trim();

                Bill_pay.child("service_number").setValue(servicenumber);
                Bill_pay.child("consumer_name").setValue(coonsumername);
                Bill_pay.child("billing_date").setValue(billingdate);
                Bill_pay.child("total_amount").setValue(totalamount);
                Toast.makeText(getApplicationContext(), "Successfully Payment done", Toast.LENGTH_LONG).show();
            }

            });
        }
    }