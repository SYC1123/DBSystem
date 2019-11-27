package com.example.dbsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mAccount;
    private EditText mPassword;
    private TextView mRegister;
    private Button mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
    }
    private void bindViews() {
        mTextView = (TextView) findViewById(R.id.textView);
        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mRegister = (TextView) findViewById(R.id.register);
        mLogin = (Button) findViewById(R.id.login);
    }
}
