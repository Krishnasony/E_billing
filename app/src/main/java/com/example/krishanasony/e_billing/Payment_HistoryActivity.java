package com.example.krishanasony.e_billing;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Payment_HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView=null;
    DatabaseReference mdatabase;
    //// toh open kr or branch bna

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__history);
        recyclerView = findViewById(R.id.recylerpayment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Bill_pay");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query = mdatabase;
        FirebaseRecyclerOptions<ModelHistory> Options = new FirebaseRecyclerOptions.Builder<ModelHistory>()
                .setQuery(query,ModelHistory.class)
                .build();
        FirebaseRecyclerAdapter<ModelHistory,ModelViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ModelHistory, ModelViewHolder>
                (Options) {
            @Override
            protected void onBindViewHolder(@NonNull ModelViewHolder holder, int position, @NonNull ModelHistory model) {
                holder.setBilling_date("Billing_date :"+model.getBilling_date());
                holder.setTotal_amount("Amount :"+model.getTotal_amount());
                holder.setService_number("Reciept_no :"+model.getService_number());
            }

            @Override
            public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view =  LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.payment_item, parent, false);
                return new ModelViewHolder(view);
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();


    }
    public static class ModelViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public ModelViewHolder(View itemView) {
            super(itemView);
            this.mView = itemView;
        }
        public void setTotal_amount(String total_amount) {
            TextView mamount = mView.findViewById(R.id.amount);
            mamount.setText(total_amount);

        }

        public void setBilling_date(String billing_date) {
            TextView mdate = mView.findViewById(R.id.bdate);
            mdate.setText(billing_date);
        }
        public void setService_number(String service_number) {
            TextView mreciept = mView.findViewById(R.id.recieptn);
            mreciept.setText(service_number);
        }
    }
}
