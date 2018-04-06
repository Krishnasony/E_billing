package com.example.krishanasony.e_billing;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_Pssd extends AppCompatActivity {
    EditText edtTextmail;
    Button changepasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__pssd);
        edtTextmail = findViewById(R.id.edittextemail);
        changepasword =findViewById(R.id.changepasword);
        changepasword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email =edtTextmail.getText().toString().trim();
                FirebaseAuth.getInstance().sendPasswordResetEmail(Email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(forgot_Pssd.this, "Reset Password Link Sent successfuly to yor email", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(forgot_Pssd.this, "Error During sending ? Please Try Again!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
}
