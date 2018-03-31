package com.example.krishanasony.e_billing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {
    EditText edittxt;
    Button btn;
    FirebaseDatabase db;
    DatabaseReference Feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        db  = FirebaseDatabase.getInstance();
        Feedback =db.getReference("Feedback").push();
        edittxt = findViewById(R.id.edittxt);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String text = edittxt.getText().toString().trim();
                Feedback.child("your_feedback").setValue(text);
                Toast.makeText(getApplicationContext(), "Thank You For Your Feedback", Toast.LENGTH_LONG).show();
            }
        });

    }
}
