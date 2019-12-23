package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbsystem.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalceUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button, button1, button2, button3,
            button4, button5, button6, button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button16, button17, button18, button19, button20, button21,
            button22, button23, up;
    private Button[][] buttons = new Button[][]{{button, button1, button2, button3}
            , {button4, button5, button6, button7}
            , {button8, button9, button10, button11}
            , {button12, button13, button14, button15}
            , {button16, button17, button18, button19}
            , {button20, button21, button22, button23}};
    private int[][] id = {{R.id.botton, R.id.button2, R.id.botton3, R.id.button4}
            , {R.id.botton5, R.id.button6, R.id.botton7, R.id.button8}
            , {R.id.botton9, R.id.button10, R.id.botton11, R.id.button12}
            , {R.id.botton13, R.id.button14, R.id.botton15, R.id.button16}
            , {R.id.botton17, R.id.button18, R.id.botton19, R.id.button20}
            , {R.id.botton21, R.id.button22, R.id.botton23, R.id.button24}};
    HashMap<Integer, Integer> ordedPlace;
    ArrayList<Integer> repairID;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palce);
        bindViews();
        ordedPlace = (HashMap<Integer, Integer>) getIntent().getSerializableExtra("map");
        repairID = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("repairID");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setOnClickListener(this);
            }
        }
        for (Integer key : ordedPlace.keySet()) {
            Log.v("wjw", "接收到的Key = " + key);
            Log.v("wjw", "接收到的value = " + ordedPlace.get(key));
            int i = key - 1;
            int j = ordedPlace.get(key) - 1;
            if (0 <= i && i <= 3) {
                buttons[i][j].setBackgroundColor(R.color.red);
                buttons[i][j].setText("该场地已预定");
                buttons[i][j].setEnabled(false);
            }
        }
        Log.d("123456", "analyze 解析的结果 " + repairID);
        for (int i = 0; i < repairID.size(); i++) {
            if (1 <= repairID.get(i) && repairID.get(i) <= 4) {
                int index = repairID.get(i) - 1;
                for (int j = 0; j < 6; j++) {
//                    Log.d("123456", index+"analyze 解析的结果 " + j);
                    buttons[j][index].setText("该场地正在维修");
                    buttons[j][index].setBackgroundColor(R.color.white);
//                    buttons[j][index].setBackgroundColor(R.color.red);
                    buttons[j][index].setEnabled(false);
                }
            }
        }
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PalceUpActivity.this, PlaceDownActivity.class);
                intent.putExtra("map", (Serializable) ordedPlace);
                intent.putExtra("repairID", repairID);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = (Button) findViewById(id[i][j]);
            }
        }
        up = findViewById(R.id.up);
    }

    @Override
    public void onClick(View v) {
        int position;
        Intent intent;
        switch (v.getId()) {
            case R.id.botton:
                position = 1;
                startactivity(position);
                break;
            case R.id.button2:
                position = 2;
                startactivity(position);
                break;
            case R.id.botton3:
                position = 3;
                startactivity(position);
                break;
            case R.id.button4:
                position = 4;
                startactivity(position);
                break;
            case R.id.botton5:
                position = 1;
                startactivity(position);
                break;
            case R.id.button6:
                position = 2;
                startactivity(position);
                break;
            case R.id.botton7:
                position = 3;
                startactivity(position);
                break;
            case R.id.button8:
                position = 4;
                startactivity(position);
                break;
            case R.id.botton9:
                position = 1;
                startactivity(position);
                break;
            case R.id.button10:
                position = 2;
                startactivity(position);
                break;
            case R.id.botton11:
                position = 3;
                startactivity(position);
                break;
            case R.id.button12:
                position = 4;
                startactivity(position);
                break;
            case R.id.botton13:
                position = 1;
                startactivity(position);
                break;
            case R.id.button14:
                position = 2;
                startactivity(position);
                break;
            case R.id.botton15:
                position = 3;
                startactivity(position);
                break;
            case R.id.button16:
                position = 4;
                startactivity(position);
                break;
            case R.id.botton17:
                position = 1;
                startactivity(position);
                break;
            case R.id.button18:
                position = 2;
                startactivity(position);
                break;
            case R.id.botton19:
                position = 3;
                startactivity(position);
                break;
            case R.id.button20:
                position = 4;
                startactivity(position);
                break;
            case R.id.botton21:
                position = 1;
                startactivity(position);
                break;
            case R.id.button22:
                position = 2;
                startactivity(position);
                break;
            case R.id.botton23:
                position = 3;
                startactivity(position);
                break;
            case R.id.button24:
                position = 4;
                startactivity(position);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void startactivity(int position) {
        Intent intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
