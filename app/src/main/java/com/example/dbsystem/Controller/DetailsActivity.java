package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dbsystem.Helper.CollectNetWorkHelper;
import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.PlaceDetailNetWorkHelper;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Interface.CollectCallback;
import com.example.dbsystem.Interface.PlaceDetailCallback;
import com.example.dbsystem.Interface.ReservationCallback;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.TimeZone;

public class DetailsActivity extends AppCompatActivity implements PlaceDetailCallback, CollectCallback {
    private PlaceDetailNetWorkHelper helper;

    private ImageView mImage1;
    private ImageView mImage2;
    private Button mReservation;
    private TextView mAir_con;
    private TextView mDress;
    private TextView mShower;
    private TextView mWc;
    private TextView mPrice;
    private TextView[] textViews = {mAir_con, mDress, mShower, mWc, mPrice};
    private int[] id = {R.id.air_con, R.id.dress, R.id.shower, R.id.wc, R.id.price};
    private float[] prices = {100, 20, 20, 10,};
    private TextView mId;
    private Button mColletion;
    private String TAG = "DetailsActivity";
    private CollectNetWorkHelper collectNetWorkHelper;
    private float money = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);
        final int time = intent.getIntExtra("time", 0);
        final String date = intent.getStringExtra("date");
        bindViews();
        final User user = SaveUserHelper.getUser(DetailsActivity.this, "data", "user");
//        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
        mId.setText(position + "");
        helper = new PlaceDetailNetWorkHelper();
        collectNetWorkHelper = new CollectNetWorkHelper();
        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "placedetail:" + position, DetailsActivity.this);
        mColletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = user.getTel();
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                String date1 = year + "-" + month + "-" + day;
                Log.d(TAG, "onClick: " + date);
                collectNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "collect:" + userID + "&" + position + "&" + date1, DetailsActivity.this);
            }
        });
        mReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailsActivity.this, PayActivity.class);
                intent1.putExtra("position", position);
                intent1.putExtra("time", time);
                intent1.putExtra("money", money);
                intent1.putExtra("date", date);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onSucceed(String response) {
        Log.d(TAG, "onSucceed: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            /**
             * 为什么要使用jsonObject.optString， 不使用jsonObject.getString
             * 因为jsonObject.optString获取null不会报错
             */
            int detailnum = jsonObject.optInt("DetailNum", 0);
            //float money = 0;
            for (int i = 0; i < detailnum; i++) {
                int index = jsonObject.optInt(i + "", 0) - 1;
                Log.d(TAG, "onSucceed:index " + index);
                textViews[index].setText("有");
                money = money + prices[index];
            }
            String url1 = jsonObject.optString("URL1", null);
            String url2 = jsonObject.optString("URL2", null);
            Glide.with(DetailsActivity.this)
                    .load(url1)
                    .into(mImage1);
            Glide.with(DetailsActivity.this)
                    .load(url2)
                    .into(mImage2);
            textViews[4].setText("￥" + money);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bindViews() {

        mImage1 = (ImageView) findViewById(R.id.image1);
        mImage2 = (ImageView) findViewById(R.id.image2);
        mReservation = (Button) findViewById(R.id.reservation);
//        mAir_con = (TextView) findViewById(R.id.air_con);
//        mDress = (TextView) findViewById(R.id.dress);
//        mShower = (TextView) findViewById(R.id.shower);
//        mWc = (TextView) findViewById(R.id.wc);
//        mPrice = (TextView) findViewById(R.id.price);
        mId = (TextView) findViewById(R.id.id);
        mColletion = (Button) findViewById(R.id.colletion);
        for (int i = 0; i < 5; i++) {
            textViews[i] = findViewById(id[i]);
        }
    }

    @Override
    public void onCollectSucceed(String response) {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }

}
