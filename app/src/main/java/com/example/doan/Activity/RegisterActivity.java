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

public class RegisterActivity extends AppCompatActivity {

    ImageButton btnLogin;
    EditText edtEmail,edtPass;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        Drawable icERR=getResources().getDrawable(R.drawable.ic_error);
        icERR.setBounds(0,0,icERR.getIntrinsicWidth(),icERR.getIntrinsicHeight());
        String email=edtEmail.getText().toString();
        String pass=edtPass.getText().toString();
        if(TextUtils.isEmpty(email)){
            edtEmail.setCompoundDrawables(null,null,icERR,null);
            edtEmail.setError("Vui lòng nhập email!",icERR);
            Toast.makeText(RegisterActivity.this,"Đăng kí thất bại",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            edtPass.setCompoundDrawables(null,null,icERR,null);
            edtPass.setError("Vui lòng nhập pass!",icERR);
            Toast.makeText(RegisterActivity.this,"Đăng kí thất bại",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Đăng kí thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        btnLogin=findViewById(R.id.btnLogin1);
        edtEmail=findViewById(R.id.edtEmail1);
        edtPass=findViewById(R.id.edtPass1);

        mAuth=FirebaseAuth.getInstance();
    }
}