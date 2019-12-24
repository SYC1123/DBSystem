package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.ReservationNetWorkHelper;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Interface.ReservationCallback;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

import java.util.Calendar;
import java.util.TimeZone;

public class PayActivity extends AppCompatActivity implements ReservationCallback {
    private TextView mMoney;
    private ImageView mImageView;
    private RadioButton mRadio1;
    private RadioButton mRadio3;
    private RadioButton mRadio4;
    private Button mPay;
    private ReservationNetWorkHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        bindViews();
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);
        final int time = intent.getIntExtra("time", 0);
        final float money = intent.getFloatExtra("money", 0);
        final String date = intent.getStringExtra("date");
        helper = new ReservationNetWorkHelper(this);
        User user = SaveUserHelper.getUser(PayActivity.this, "data", "user");
        final String tel = user.getTel();
        mMoney.setText("￥" + money);
        mRadio1.setChecked(true);
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "reservation:" + tel + "&" + position + "&" + date + "&" + time + "&" + money, PayActivity.this);
            }
        });

//        Toast.makeText(this, time+"   "+position+" "+money+" "+date, Toast.LENGTH_SHORT).show();

    }

    private void bindViews() {

        mMoney = (TextView) findViewById(R.id.money);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mRadio1 = (RadioButton) findViewById(R.id.radio1);
        mRadio3 = (RadioButton) findViewById(R.id.radio3);
        mRadio4 = (RadioButton) findViewById(R.id.radio4);
        mPay = (Button) findViewById(R.id.pay);
    }

    @Override
    public void onResSucceed(String response) {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PayActivity.this,UserActivity.class));
    }
}
