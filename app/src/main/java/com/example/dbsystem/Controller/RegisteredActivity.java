package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbsystem.Helper.RegisterNetWorkHelper;
import com.example.dbsystem.R;
import com.example.dbsystem.Interface.RegisterCallback;

public class RegisteredActivity extends AppCompatActivity implements RegisterCallback<String> {
    private EditText mPassword2;
    private EditText mAddress;
    private EditText mName;
    private Button mRegisted;
    private EditText mPhone;
    private EditText mPassword;

    private RegisterNetWorkHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        bindViews();
        helper = new RegisterNetWorkHelper(this);

        mRegisted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mPasswordText = mPassword.getText().toString();
                String mPasswordText2 = mPassword2.getText().toString();
                String address = mAddress.getText().toString();
                String name = mName.getText().toString();
                String phone = mPhone.getText().toString();
                if (mPasswordText.equals("") || mPasswordText2.equals("") || address.equals("") || name.equals("") || phone.equals("")) {
                    Toast.makeText(RegisteredActivity.this, "内容不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    if (mPasswordText.equals(mPasswordText2)) {
                        Toast.makeText(RegisteredActivity.this, "123456789", Toast.LENGTH_SHORT).show();
                        helper.startNetThread("172.20.10.11",6666,"register:"+name+"&"+phone+"&"+address+"&"+mPasswordText,RegisteredActivity.this);
                    } else {
                        Toast.makeText(RegisteredActivity.this, "两次密码不同！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void bindViews() {

        mPassword2 = (EditText) findViewById(R.id.password2);
        mAddress = (EditText) findViewById(R.id.address);
        mName = (EditText) findViewById(R.id.name);
        mRegisted = (Button) findViewById(R.id.registed);
        mPhone = (EditText) findViewById(R.id.www);
        mPassword = (EditText) findViewById(R.id.password);
    }


    @Override
    public void onSucceed(String response) {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFalied(String errStr) {
        Toast.makeText(this, errStr, Toast.LENGTH_SHORT).show();
    }
}
