package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbsystem.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PlaceDownActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtn10, mBtn11, mBtn12, mDown;
    private Button[][] buttons = new Button[][]{{mBtn, mBtn2}, {mBtn3, mBtn4}, {mBtn5, mBtn6}, {mBtn7, mBtn8}, {mBtn9, mBtn10}, {mBtn11, mBtn12}};
    private int[][] id = {{R.id.botton, R.id.botton3}, {R.id.botton5, R.id.botton7}, {R.id.botton9, R.id.botton11}, {R.id.botton13, R.id.botton15}, {R.id.botton17, R.id.botton19}, {R.id.botton21, R.id.botton23}};
    HashMap<Integer, Integer> ordedPlace;
    ArrayList<Integer> repairID;
    private String date;
    ArrayList<Integer> placeidList = new ArrayList<Integer>();
    ArrayList<Integer> ordertimeList = new ArrayList<Integer>();
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_down);
        bindView();
        repairID = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("repairID");
        ordedPlace = (HashMap<Integer, Integer>) getIntent().getSerializableExtra("map");
        date = getIntent().getStringExtra("date");
        placeidList=(ArrayList<Integer>) getIntent().getIntegerArrayListExtra("placeidList");
        ordertimeList=(ArrayList<Integer>) getIntent().getIntegerArrayListExtra("ordertimeList");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                buttons[i][j].setOnClickListener(this);
            }
        }
        for (int k=0;k<placeidList.size();k++) {
            Log.v("wjw", "接收到的场地号 = " + placeidList.get(k));
            Log.v("wjw", "接收到的时间号 = " + ordertimeList.get(k));
            int i = placeidList.get(k) - 1;
            int j = ordertimeList.get(k) - 1;
            if (3 < i) {
                i = i - 4;
                buttons[j][i].setBackgroundColor(R.color.red);
                buttons[j][i].setText("该场地已预定");
                buttons[j][i].setEnabled(false);
            }
        }
        for (int i = 0; i < repairID.size(); i++) {
            if (4 < repairID.get(i)) {
                int index = repairID.get(i) - 5;
                for (int j = 0; j < 6; j++) {
//                    Log.d("123456", index+"analyze 解析的结果 " + j);
                    buttons[j][index].setText("该场地正在维修");
                    buttons[j][index].setBackgroundColor(R.color.white);
//                    buttons[j][index].setBackgroundColor(R.color.red);
                    buttons[j][index].setEnabled(false);
                }
            }
        }
    }

    private void bindView() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                buttons[i][j] = findViewById(id[i][j]);
            }
        }
        mDown = findViewById(R.id.down);
        mDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        int position, time;
        Intent intent;
        switch (v.getId()) {
            case R.id.botton:
                position = 5;
                time = 1;
                startactivity(position, time, date);
                break;
            case R.id.botton3:
                position = 6;
                time = 1;
                startactivity(position, time, date);
                break;
            case R.id.botton5:
                position = 5;
                time = 2;
                startactivity(position, time, date);
                break;
            case R.id.botton7:
                position = 6;
                time = 2;
                startactivity(position, time, date);
                break;
            case R.id.botton9:
                position = 5;
                time = 3;
                startactivity(position, time, date);
                break;
            case R.id.botton11:
                position = 6;
                time = 3;
                startactivity(position, time, date);
                break;
            case R.id.botton13:
                position = 6;
                time = 4;
                startactivity(position, time, date);
                break;
            case R.id.botton15:
                position = 5;
                time = 4;
                startactivity(position, time, date);
                break;
            case R.id.botton17:
                position = 5;
                time = 5;
                startactivity(position, time, date);
                break;
            case R.id.botton19:
                position = 6;
                time = 5;
                startactivity(position, time, date);
                break;
            case R.id.botton21:
                position = 5;
                time = 6;
                startactivity(position, time, date);
                break;
            case R.id.botton23:
                position = 6;
                time = 6;
                startactivity(position, time, date);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void startactivity(int position, int time, String date) {
        Intent intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("time", time);
        intent.putExtra("date", date);
        startActivity(intent);
    }
}
