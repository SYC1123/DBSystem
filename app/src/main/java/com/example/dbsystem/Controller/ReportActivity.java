package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.RepairNetWorkHelper;
import com.example.dbsystem.Interface.RepairCallback;
import com.example.dbsystem.R;

import org.json.JSONObject;

public class ReportActivity extends AppCompatActivity implements RepairCallback {
    private TextView mAllorder;
    private TextView mAllmoney;
    private RepairNetWorkHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        bindViews();
        helper = new RepairNetWorkHelper();
        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "report:", this);
    }

    private void bindViews() {

        mAllorder = (TextView) findViewById(R.id.allorder);
        mAllmoney = (TextView) findViewById(R.id.allmoney);
    }

    @Override
    public void onRepairSucceed(String response) {
        Log.d("1554154", "onRepairSucceed: "+response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            String money = jsonObject.optString("Money", null);
            String ordernum = jsonObject.optString("Order", null);
            mAllmoney.setText("￥" + money);
            mAllorder.setText(ordernum + "份");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
