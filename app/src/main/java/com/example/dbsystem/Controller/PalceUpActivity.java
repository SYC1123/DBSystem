package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbsystem.R;

import java.util.Arrays;

public class PalceUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button, button1, button2, button3,
            button4, button5, button6, button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button16, button17, button18, button19, button20, button21,
            button22, button23, button24,up;
    private Button[] buttons = new Button[]{button, button1, button2, button3,
            button4, button5, button6, button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button16, button17, button18, button19, button20, button21,
            button22, button23, button24};
    private int[] id = {R.id.botton, R.id.button2, R.id.botton2, R.id.button4
            , R.id.botton5, R.id.button6, R.id.botton7, R.id.button8, R.id.botton9
            , R.id.button10, R.id.botton11, R.id.button12, R.id.botton13, R.id.button14, R.id.botton15, R.id.button16, R.id.botton17
            , R.id.button18, R.id.botton19, R.id.button20, R.id.botton21, R.id.button22, R.id.botton23, R.id.button24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palce);
        bindViews();
        for (int i = 0; i < 24; i++) {
            buttons[i].setOnClickListener(this);
        }
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PalceUpActivity.this,PlaceDownActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        for (int i = 0; i < 24; i++) {
            buttons[i] = (Button) findViewById(id[i]);
        }
        up=findViewById(R.id.up);
    }

    @Override
    public void onClick(View v) {
        int position;
        Intent intent;
        switch (v.getId()) {
            case R.id.botton:
                position = Arrays.binarySearch(id, v.getId());
                Toast.makeText(PalceUpActivity.this, position + "123456", Toast.LENGTH_SHORT).show();
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton2:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton5:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button6:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton7:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button8:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton9:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button10:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton11:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button12:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton13:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button14:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton15:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button16:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton17:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button18:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton19:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button20:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton21:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button22:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.botton23:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button24:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceUpActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
