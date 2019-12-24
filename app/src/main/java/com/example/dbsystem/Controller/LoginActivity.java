package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.LoginNetWorkHelper;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Interface.LoginCallback;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements LoginCallback<String> {
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private TextView mRegister;
    private LoginNetWorkHelper helper = new LoginNetWorkHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        //注册
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);
                startActivity(intent);
            }
        });
        //登陆
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mAccount.getText().toString();
                String password = mPassword.getText().toString();
                if (account.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    if (account.equals("13853531141") && password.equals("123456")) {
                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(intent);
                    } else {
                        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "login:" + account + "&" + password, LoginActivity.this);
                    }
                }
            }
        });

    }

    private void bindViews() {

        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (TextView) findViewById(R.id.register);
    }

    @Override
    public void onSucceed(String response) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        SaveUserHelper.saveIslogin(this, "data", "islogin");

        Log.d("123456", "onSucceed: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            /**
             * 为什么要使用jsonObject.optString， 不使用jsonObject.getString
             * 因为jsonObject.optString获取null不会报错
             */
            String address = jsonObject.optString("Address", null);
            String name = jsonObject.optString("Name", null);
            String tel = jsonObject.optString("Tel", null);
            String date = jsonObject.optString("Date", null);
            String password = jsonObject.optString("Password", null);
            int status = jsonObject.optInt("Status", 0);
            User user = new User(tel, name, address, date, password, status);
            SaveUserHelper.saveUser(this, "data", "user", user);
            // 日志打印结果：
            Log.d("123546", "analyzeJSON1解析的结果：" + address + name + tel + date + password + status);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFalied(String errStr) {
        Toast.makeText(this, errStr, Toast.LENGTH_SHORT).show();
    }
}
