package com.example.krishanasony.e_billing;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EbsSignin extends AppCompatActivity {
    EditText editemail , editpassword;
    Button signin;
    TextView forgot;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebs_signin);
        editemail = findViewById(R.id.email1);
        editpassword =findViewById(R.id.pass1);
        signin = findViewById(R.id.signin1);
        TextView forgot = findViewById(R.id.forgot);


        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EbsSignin.this,forgot_Pssd.class));
            }
        });


        TextView click = findViewById(R.id.clickhere);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EbsSignin.this,EbsSignup.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = editemail.getText().toString().trim();
                String Password = editpassword.getText().toString().trim();

                if (Email.isEmpty() & Password.isEmpty()) {
                    Toast.makeText(EbsSignin.this, "Please Enter Email and Password..? and try again", Toast.LENGTH_SHORT).show();


                } else if (Email.isEmpty()) {
                    Toast.makeText(EbsSignin.this, "Please Enter Email and Password..? and try again", Toast.LENGTH_SHORT).show();
                } else if (Password.isEmpty()) {
                    Toast.makeText(EbsSignin.this, "Please Enter Email and Password..? and try again", Toast.LENGTH_SHORT).show();

                } else {
                    mAuth.signInWithEmailAndPassword(Email, Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(EbsSignin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(EbsSignin.this, HomeActivity.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EbsSignin.this, "Login Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }
        });
    }
}
