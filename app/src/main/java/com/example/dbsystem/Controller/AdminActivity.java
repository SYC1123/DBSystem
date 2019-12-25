package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbsystem.R;

public class AdminActivity extends AppCompatActivity {

    private Button mPlacemanager;
    private Button mStatistical;
    private Button mChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        bindViews();
        mPlacemanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AdminActivity.this, "123132123", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AdminActivity.this,ManagerActivity.class);
                startActivity(intent);
            }
        });
        mStatistical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminActivity.this,ReportActivity.class);
                startActivity(intent);
            }
        });
        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminActivity.this,CancelOrederActivity.class);
                startActivity(intent);
            }
        });
    }
    private void bindViews() {
        mPlacemanager = (Button) findViewById(R.id.placemanager);
        mStatistical = (Button) findViewById(R.id.statistical);
        mChange=findViewById(R.id.change);
    }
}
