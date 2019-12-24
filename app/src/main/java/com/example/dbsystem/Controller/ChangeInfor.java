package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbsystem.Helper.ChangeInfoNetWorkHelper;
import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Interface.ChangeInfoCallback;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

public class ChangeInfor extends AppCompatActivity implements ChangeInfoCallback<String> {
    private TextView mTextView;
    private EditText mEdit_username;
    private EditText mEdit_tel;
    private EditText mEdit_address;
    private EditText mEdit_pass1;
    private EditText mEdit_pass2;
    private Button mBtn_sure;
    private ChangeInfoNetWorkHelper helper;
    private String beforeTel="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_infor);
        bindViews();
        helper=new ChangeInfoNetWorkHelper(this);
        User user= SaveUserHelper.getUser(ChangeInfor.this,"data","user");
        beforeTel=user.getTel();
        mEdit_username.setText(user.getName());
        mEdit_address.setText(user.getAddress());
        mEdit_tel.setText(user.getTel());
        mEdit_pass1.setText(user.getPassword());
        mEdit_pass2.setText(user.getPassword());
        mBtn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=mEdit_username.getText().toString();
                String tel=mEdit_tel.getText().toString();
                String address=mEdit_address.getText().toString();
                String pass1=mEdit_pass1.getText().toString();
                String pass2=mEdit_pass2.getText().toString();
                if(name.equals("")||tel.equals("")||address.equals("")||pass1.equals("")||pass2.equals("")){
                    Toast.makeText(ChangeInfor.this, "输入内容不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    helper.startNetThread(Constant.IPADDRESS,Constant.PORT,"changeinfo:"+name+"&"+tel+"&"+address+"&"+pass1+"&"+beforeTel,ChangeInfor.this);
                }
            }
        });
    }
    private void bindViews() {

        mTextView = (TextView) findViewById(R.id.textView);
        mEdit_username = (EditText) findViewById(R.id.edit_username);
        mEdit_tel = (EditText) findViewById(R.id.edit_tel);
        mEdit_address = (EditText) findViewById(R.id.edit_address);
        mEdit_pass1 = (EditText) findViewById(R.id.edit_pass1);
        mEdit_pass2 = (EditText) findViewById(R.id.edit_pass2);
        mBtn_sure = (Button) findViewById(R.id.btn_sure);
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
