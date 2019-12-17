package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbsystem.R;

import java.util.Arrays;

public class PalceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button, button1, button2, button3,
            button4, button5, button6, button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button16, button17, button18, button19, button20, button21,
            button22, button23, button24;
    private Button[] buttons = new Button[]{button, button1, button2, button3,
            button4, button5, button6, button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button16, button17, button18, button19, button20, button21,
            button22, button23, button24};
    private int[] id = {R.id.button, R.id.button2, R.id.button3, R.id.button4
            , R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
            , R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17
            , R.id.button18, R.id.button19, R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palce);
        bindViews();
        for (int i = 0; i < 24; i++) {
            buttons[i].setOnClickListener(this);
        }

    }

    private void bindViews() {
        for (int i = 0; i < 24; i++) {
            buttons[i] = (Button) findViewById(id[i]);
        }
    }

    @Override
    public void onClick(View v) {
        int position;
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                position = Arrays.binarySearch(id, v.getId());
                Toast.makeText(PalceActivity.this, position + "", Toast.LENGTH_SHORT).show();
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button5:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button6:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button7:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button8:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button9:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button10:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button11:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button12:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button13:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button14:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button15:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button16:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button17:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button18:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button19:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button20:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button21:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button22:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button23:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.button24:
                position = Arrays.binarySearch(id, v.getId());
                intent = new Intent(PalceActivity.this, DetailsActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
