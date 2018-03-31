package com.example.krishanasony.e_billing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Customer_careActivity extends AppCompatActivity {
    EditText nm_txt,phn_no,cmp_txt;
    Button sub_btn;
    FirebaseDatabase db;
    DatabaseReference Customer_care;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_care);
        db  = FirebaseDatabase.getInstance();
        Customer_care =db.getReference("customer_care").push();

        nm_txt = findViewById(R.id.nm_txt);
        phn_no = findViewById(R.id.phn_no);
        cmp_txt = findViewById(R.id.cmp_txt);
        sub_btn = findViewById(R.id.sub_btn);

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = nm_txt.getText().toString().trim();
                final String contact = phn_no.getText().toString().trim();
                final String complent = cmp_txt.getText().toString().trim();

                Customer_care.child("your_name").setValue(name);
                Customer_care.child("contact_number").setValue(contact);
                Customer_care.child("your_complaint").setValue(complent);
                Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_LONG).show();
            }

        });
    }
    }

