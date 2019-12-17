package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dbsystem.R;

public class LoginActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        //注册
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisteredActivity.class);
                startActivity(intent);
            }
        });
        //登陆
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

    }
    private void bindViews() {

        mTextView = (TextView) findViewById(R.id.placeId);
        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (TextView) findViewById(R.id.register);
    }

}
