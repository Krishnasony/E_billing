package com.example.krishanasony.e_billing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity{
    EditText nametxt,edt1;
    Button regbtn;
    FirebaseDatabase db;
    DatabaseReference Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db= FirebaseDatabase.getInstance();
        Register=db.getReference("Register").push();
        edt1=findViewById(R.id.edt1);
        nametxt=findViewById(R.id.nametxt);
        regbtn=findViewById(R.id.regbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name= nametxt.getText().toString().trim();
                final String registrationnumber = edt1.getText().toString().trim();

                    Register.child("consumer_Name").setValue(name);
                    Register.child("reg_number").setValue(registrationnumber);
                    Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_LONG).show();
                }
        });
    }
}
