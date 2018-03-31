package com.example.krishanasony.e_billing;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EbsSignup extends AppCompatActivity {
    Button signup;
    EditText editemail ,editpassword,editfname,editlname,editcontact,editcpass;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebs_signup);
        db  = FirebaseDatabase.getInstance();
        users =db.getReference("Users").push();
        mAuth = FirebaseAuth.getInstance();

        editemail = findViewById(R.id.edittextemail);
        editpassword = findViewById(R.id.edittextpassword);
        editcpass = findViewById(R.id.edittextcpassword);
        editfname = findViewById(R.id.edittextfname);
//        editlname = findViewById(R.id.edittextlname);
        editcontact = findViewById(R.id.editTextphone);
        signup = findViewById(R.id.ebssignup);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(EbsSignup.this,EbsSignin.class));

//                   final  String Lname =editlname.getText().toString().trim();
                final String Fname = editfname.getText().toString().trim();
                final   String Email = editemail.getText().toString().trim();
                final String Contact = editcontact.getText().toString().trim();
                final  String Password = editpassword.getText().toString().trim();
                final String ConPass = editcpass.getText().toString().trim();



                mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            users.child("email").setValue(Email);
                            users.child("password").setValue(Password);
                            users.child("full_name").setValue(Fname);
                            users.child("contact").setValue(Contact);
                            startActivity(new Intent(EbsSignup.this, EbsSignin.class));
                            Toast.makeText(getApplicationContext(), "User Created Successfully", Toast.LENGTH_LONG).show();

                        } else {

                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {

                                Toast.makeText(getApplicationContext(), "You Are Already Registered!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }


                        }


                    }
                });
            }
        });


    }
}
