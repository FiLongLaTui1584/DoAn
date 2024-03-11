package com.example.doan.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {

    ImageButton btnLogin;
    TextView register;
    EditText edtEmail,edtPass;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {login();}
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {moRegister();}
        });
    }

    private void login() {
        Drawable icERR=getResources().getDrawable(R.drawable.ic_error);
        icERR.setBounds(0,0,icERR.getIntrinsicWidth(),icERR.getIntrinsicHeight());
        String email=edtEmail.getText().toString();
        String pass=edtPass.getText().toString();
        if(TextUtils.isEmpty(email)){
            edtEmail.setCompoundDrawables(null,null,icERR,null);
            edtEmail.setError("Vui lòng nhập email!",icERR);
            Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            edtPass.setCompoundDrawables(null,null,icERR,null);
            edtPass.setError("Vui lòng nhập pass!",icERR);
            Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
            }
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

        mAuth=FirebaseAuth.getInstance();
    }
}