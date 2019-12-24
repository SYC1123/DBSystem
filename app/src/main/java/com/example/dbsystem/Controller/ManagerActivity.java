package com.example.dbsystem.Controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dbsystem.Helper.CollectionAdapter;
import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.QueryBadNetWorkHelper;
import com.example.dbsystem.Helper.RepairNetWorkHelper;
import com.example.dbsystem.Interface.QueryBadCallback;
import com.example.dbsystem.Interface.RepairCallback;
import com.example.dbsystem.Model.Collection;
import com.example.dbsystem.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagerActivity extends AppCompatActivity implements QueryBadCallback, View.OnClickListener, RepairCallback {
    private ImageButton mIbtn1;
    private ImageButton mIbtn2;
    private ImageButton mIbtn3;
    private ImageButton mIbtn4;
    private ImageButton mIbtn5;
    private ImageButton mIbtn6;
    private ImageButton[] imageButtons = {mIbtn1, mIbtn2, mIbtn3, mIbtn4, mIbtn5, mIbtn6};
    private int[] id = {R.id.ibtn1, R.id.ibtn2, R.id.ibtn3, R.id.ibtn4, R.id.ibtn5, R.id.ibtn6};
    private boolean[] flags = {true, true, true, true, true, true};
    private Button mRepair;
    private Button mDestroy;
    private QueryBadNetWorkHelper helper;
    List<Integer> list = new ArrayList<Integer>();
    private RepairNetWorkHelper repairNetWorkHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        bindViews();
        repairNetWorkHelper=new RepairNetWorkHelper();
        helper = new QueryBadNetWorkHelper();
        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "querybad:", this);
    }

    private void bindViews() {
        for (int i = 0; i < 6; i++) {
            imageButtons[i] = findViewById(id[i]);
            imageButtons[i].setOnClickListener(this);
        }
        mRepair = (Button) findViewById(R.id.repair);
        mDestroy = (Button) findViewById(R.id.destroy);
        mRepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id="";
                for (int i=0;i<6;i++){
                    if(!flags[i]){
                        id=id+(i+1)+"&";
                    }
                }
                id = id.substring(0,id.length() - 1);
//                Toast.makeText(ManagerActivity.this, id, Toast.LENGTH_SHORT).show();
                repairNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "repair:"+id, ManagerActivity.this);
            }
        });
        mDestroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id="";
                for (int i=0;i<6;i++){
                    if(!flags[i]){
                        id=id+(i+1)+"&";
                    }
                }
                id = id.substring(0,id.length() - 1);
//                Toast.makeText(ManagerActivity.this, id, Toast.LENGTH_SHORT).show();
                repairNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "destroy:"+id, ManagerActivity.this);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onSucceed(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.optInt("PlaceID", 0) - 1;
                list.add(id);
                imageButtons[id].setImageDrawable(getResources().getDrawable(R.drawable.repair));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn1:
                if (flags[0]) {
                    imageButtons[0].setImageDrawable(getResources().getDrawable(R.drawable.right));
                    flags[0] = false;
                } else {
                    if (list.contains(0)) {
                        imageButtons[0].setImageDrawable(getResources().getDrawable(R.drawable.repair));
                    } else {
                        imageButtons[0].setImageDrawable(getResources().getDrawable(R.drawable.one));
                    }
                    flags[0] = true;
                }
                break;
            case R.id.ibtn2:
                if (flags[1]) {
                    imageButtons[1].setImageDrawable(getResources().getDrawable(R.drawable.right));
                    flags[1] = false;
                } else {
                    if (list.contains(1)) {
                        imageButtons[1].setImageDrawable(getResources().getDrawable(R.drawable.repair));
                    } else {
                        imageButtons[1].setImageDrawable(getResources().getDrawable(R.drawable.two));
                    }
                    flags[1] = true;
                }
                break;
            case R.id.ibtn3:
                if (flags[2]) {
                    imageButtons[2].setImageDrawable(getResources().getDrawable(R.drawable.right));
                    flags[2] = false;
                } else {
                    if (list.contains(2)) {
                        imageButtons[2].setImageDrawable(getResources().getDrawable(R.drawable.repair));
                    } else {
                        imageButtons[2].setImageDrawable(getResources().getDrawable(R.drawable.three));
                    }
                    flags[2] = true;
                }
                break;
            case R.id.ibtn4:
                if (flags[3]) {
                    imageButtons[3].setImageDrawable(getResources().getDrawable(R.drawable.right));
                    flags[3] = false;
                } else {
                    if (list.contains(3)) {
                        imageButtons[3].setImageDrawable(getResources().getDrawable(R.drawable.repair));
                    } else {
                        imageButtons[3].setImageDrawable(getResources().getDrawable(R.drawable.four));
                    }
                    flags[3] = true;
                }
                break;
            case R.id.ibtn5:
                if (flags[4]) {
                    imageButtons[4].setImageDrawable(getResources().getDrawable(R.drawable.right));
                    flags[4] = false;
                } else {
                    if (list.contains(4)) {
                        imageButtons[4].setImageDrawable(getResources().getDrawable(R.drawable.repair));
                    } else {
                        imageButtons[4].setImageDrawable(getResources().getDrawable(R.drawable.five));
                    }
                    flags[4] = true;
                }
                break;
            case R.id.ibtn6:
                if (flags[5]) {
                    imageButtons[5].setImageDrawable(getResources().getDrawable(R.drawable.right));
                    flags[5] = false;
                } else {
                    if (list.contains(5)) {
                        imageButtons[5].setImageDrawable(getResources().getDrawable(R.drawable.repair));
                    } else {
                        imageButtons[5].setImageDrawable(getResources().getDrawable(R.drawable.six));
                    }
                    flags[5] = true;
                }
                break;
        }
    }

    @Override
    public void onRepairSucceed(String response) {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        finish();
    }
}
