package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.doan.R;

public class RegisterActivity extends AppCompatActivity {

    ImageButton btnLogin;
    EditText edtName,edtEmail,edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable icERR=getResources().getDrawable(R.drawable.ic_error);
                icERR.setBounds(0,0,icERR.getIntrinsicWidth(),icERR.getIntrinsicHeight());
                String name=edtName.getText().toString().trim();
                String email=edtEmail.getText().toString().trim();
                String pass=edtPass.getText().toString().trim();
                if(name.isEmpty()){
                    edtName.setCompoundDrawables(null,null,icERR,null);
                    edtName.setError("Vui lòng nhập tên!",icERR);
                }
                if(email.isEmpty()){
                    edtEmail.setCompoundDrawables(null,null,icERR,null);
                    edtEmail.setError("Vui lòng nhập email!",icERR);
                }
                if(pass.isEmpty()){
                    edtPass.setCompoundDrawables(null,null,icERR,null);
                    edtPass.setError("Vui lòng nhập pass!",icERR);
                }
                if(!name.isEmpty()&&!email.isEmpty()&&!pass.isEmpty()){
                    edtName.setCompoundDrawables(null,null,null,null);
                    edtEmail.setCompoundDrawables(null,null,null,null);
                    edtPass.setCompoundDrawables(null,null,null,null);
                    Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void addControls() {
        btnLogin=findViewById(R.id.btnLogin1);
        edtName=findViewById(R.id.edtName);
        edtEmail=findViewById(R.id.edtEmail1);
        edtPass=findViewById(R.id.edtPass1);
    }
}