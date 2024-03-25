package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.doan.Adapter.PopularListAdapter;
import com.example.doan.Adapter.myadapter;
import com.example.doan.R;
import com.example.doan.model.model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ViewAll_iPhone_Activity extends AppCompatActivity {
    RecyclerView recyclerViewAll;
    myadapter adapter;
    ImageButton btn_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_iphone);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ViewAll_iPhone_Activity.this, UploadProductActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        recyclerViewAll=findViewById(R.id.view4);
        btn_add=findViewById(R.id.fadd);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewAll.setLayoutManager(gridLayoutManager);


        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("product_iphone"), model.class)
                        .build();

        adapter=new myadapter(options);
        recyclerViewAll.setAdapter(adapter);
    }



    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }


    public void QuayVe(View view){
        finish();
    }
}