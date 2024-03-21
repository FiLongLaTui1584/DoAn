package com.example.doan.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class UploadProductActivity extends AppCompatActivity {

    EditText addten, addgia, adddiem, addmota, addhinh;
    Button addsubmit;
    ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_product);

        addControls();
        addEvents();
    }

    private void addEvents() {
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewAll_Activity.class));
                finish();
            }
        });

        addsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();
            }
        });
    }

    private void processinsert() {
        Map<String,Object> map=new HashMap<>();
        map.put("hinh",addhinh.getText().toString());
        map.put("tenSP",addten.getText().toString());
        map.put("dongia",addgia.getText().toString());
        map.put("rate",adddiem.getText().toString());
        map.put("description",addmota.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("product").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        addten.setText("");
                        addgia.setText("");
                        adddiem.setText("");
                        addmota.setText("");
                        addhinh.setText("");

                        Toast.makeText(getApplicationContext(),"Thêm sản phẩm thành công",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Thêm sản phẩm thất bại",Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void addControls() {
        addten=(EditText) findViewById(R.id.addten);
        addgia=(EditText)findViewById(R.id.addgia);
        adddiem=(EditText)findViewById(R.id.adddiem);
        addmota=(EditText)findViewById(R.id.addmota);
        addhinh=(EditText)findViewById(R.id.addhinh);
        addsubmit=findViewById(R.id.addsubmit);

        back_button=findViewById(R.id.back_button);
    }



}