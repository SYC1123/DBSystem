package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.PlaceDetailNetWorkHelper;
import com.example.dbsystem.Interface.PlaceDetailCallback;
import com.example.dbsystem.R;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements PlaceDetailCallback {
    private PlaceDetailNetWorkHelper helper;

    private ImageView mImage1;
    private ImageView mImage2;
    private Button mReservation;
    private TextView mAir_con;
    private TextView mDress;
    private TextView mShower;
    private TextView mWc;
    private TextView mPrice;
    private TextView mId;
    private Button mColletion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        bindViews();
//        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
        mId.setText(position + "");
        helper = new PlaceDetailNetWorkHelper();
        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "placedetail:" + position, DetailsActivity.this);
    }

    @Override
    public void onSucceed(String response) {

    }

    private void bindViews() {

        mImage1 = (ImageView) findViewById(R.id.image1);
        mImage2 = (ImageView) findViewById(R.id.image2);
        mReservation = (Button) findViewById(R.id.reservation);
        mAir_con = (TextView) findViewById(R.id.air_con);
        mDress = (TextView) findViewById(R.id.dress);
        mShower = (TextView) findViewById(R.id.shower);
        mWc = (TextView) findViewById(R.id.wc);
        mPrice = (TextView) findViewById(R.id.price);
        mId = (TextView) findViewById(R.id.id);
        mColletion = (Button) findViewById(R.id.colletion);
    }

}
