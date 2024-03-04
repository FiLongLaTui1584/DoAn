package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.R;

public class LoginActivity extends AppCompatActivity {

    ImageButton btnLogin;
    TextView register;
    EditText edtEmail,edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable icERR=getResources().getDrawable(R.drawable.ic_error);
                icERR.setBounds(0,0,icERR.getIntrinsicWidth(),icERR.getIntrinsicHeight());
                String email=edtEmail.getText().toString().trim();
                String pass=edtPass.getText().toString().trim();
                if(email.isEmpty()){
                    edtEmail.setCompoundDrawables(null,null,icERR,null);
                    edtEmail.setError("Vui lòng nhập email!",icERR);
                    Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
                if(pass.isEmpty()){
                    edtPass.setCompoundDrawables(null,null,icERR,null);
                    edtPass.setError("Vui lòng nhập pass!",icERR);
                    Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
                if(!email.isEmpty()&&!pass.isEmpty()){
                    edtEmail.setCompoundDrawables(null,null,null,null);
                    edtPass.setCompoundDrawables(null,null,null,null);
                    Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {moRegister();}
        });
    }

    private void moRegister() {
        Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void addControls() {
        btnLogin=findViewById(R.id.btnLogin);
        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPass);
        register=(TextView)findViewById(R.id.btn_register);
    }
}