package com.example.krishanasony.e_billing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Button btn1,btn2,btn3,btn4,btn5;
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,RegistrationActivity.class));
            }
        });
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,Payment_HistoryActivity.class));
            }
        });
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FeedbackActivity.class));
            }
        });
        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,Bill_payActivity.class));
            }
        });
        btn5=findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,Customer_careActivity.class));
            }
        });
        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle =new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navbar);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;

        }
      return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.reg:
                Toast.makeText(this, "this is registeration", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,RegistrationActivity.class));
                break;
            case R.id.ctmr:
                Toast.makeText(this, "this is customer Care", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Customer_careActivity.class));
                break;

            case R.id.pyh:
                Toast.makeText(this, "this is Payment History", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Payment_HistoryActivity.class));
                break;

            case R.id.fed:
                Toast.makeText(this, "this is Feedback", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,FeedbackActivity.class));
                break;
                case R.id.blp:
                Toast.makeText(this, "this is Bill Pay", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Bill_payActivity.class));
                break;
            case R.id.l_out:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,EbsSignin.class));
                finish();
                break;



        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
