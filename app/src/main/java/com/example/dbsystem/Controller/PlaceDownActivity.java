package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbsystem.R;

import java.util.Arrays;

public class PlaceDownActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtn10, mBtn11, mBtn12, mDown;
    private Button[] buttons = new Button[]{mBtn, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtn10, mBtn11, mBtn12};
    private int[] id = {R.id.botton, R.id.botton2, R.id.botton5, R.id.botton7, R.id.botton9, R.id.botton11, R.id.botton13, R.id.botton15, R.id.botton17, R.id.botton19, R.id.botton21, R.id.botton23};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_down);
        bindView();
        for (int i = 0; i < 12; i++) {
            buttons[i].setOnClickListener(this);
        }
    }

    private void bindView() {
        for (int i = 0; i < 12; i++) {
            buttons[i] = findViewById(id[i]);
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
        int position;
        Intent intent;
        switch (v.getId()) {
            case R.id.botton:
                position = Arrays.binarySearch(id, v.getId());
                Toast.makeText(PlaceDownActivity.this, position + "123456", Toast.LENGTH_SHORT).show();
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton2:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton5:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton7:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton9:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton11:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button12:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton13:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton15:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button16:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton17:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton19:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton21:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton23:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PlaceDownActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
