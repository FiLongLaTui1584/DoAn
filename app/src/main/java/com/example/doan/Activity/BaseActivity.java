package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.doan.R;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database=FirebaseDatabase.getInstance();
    }
}