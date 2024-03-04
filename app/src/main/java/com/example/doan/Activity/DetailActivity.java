package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.doan.R;
import com.example.doan.model.PopularModel;

public class DetailActivity extends AppCompatActivity {

    TextView txtTensp,txtDongia,txtDanhgia,txtDiem;
    ImageView ivHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        addControls();
        xuLyChiTiet();
    }




   private void xuLyChiTiet() {
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            ivHinh.setImageResource(bundle.getInt("ivHinh"));
            txtTensp.setText(bundle.getString("txtTensp"));
            txtDongia.setText(bundle.getString("txtDongia"));
            txtDanhgia.setText(bundle.getString("txtDanhgia"));
            txtDiem.setText(bundle.getString("txtDiem"));
        }
    }

    private void addControls() {
        ivHinh=findViewById(R.id.ivHinh);
        txtTensp=findViewById(R.id.txtTensp);
        txtDongia=findViewById(R.id.txtDongia);
        txtDanhgia=findViewById(R.id.txtDanhgia);
        txtDiem=findViewById(R.id.txtDiem);
    }

    public void QuayVe(View view){
        finish();
    }
}