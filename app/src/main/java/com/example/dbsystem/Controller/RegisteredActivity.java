package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.dbsystem.R;

public class RegisteredActivity extends AppCompatActivity {
    private EditText mPassword2;
    private EditText mAddress;
    private EditText mName;
    private Button mRegisted;
    private EditText mPhone;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        bindViews();
    }

    private void bindViews() {

        mPassword2 = (EditText) findViewById(R.id.password2);
        mAddress = (EditText) findViewById(R.id.address);
        mName = (EditText) findViewById(R.id.name);
        mRegisted = (Button) findViewById(R.id.registed);
        mPhone = (EditText) findViewById(R.id.www);
        mPassword = (EditText) findViewById(R.id.password);
    }
}
