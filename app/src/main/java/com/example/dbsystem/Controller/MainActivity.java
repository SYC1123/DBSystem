package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

public class MainActivity extends AppCompatActivity {
    private boolean islogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        islogin= SaveUserHelper.getIslogin(this,"data","islogin");
        if (islogin) {
            User user=SaveUserHelper.getUser(this,"data","user");
            Toast.makeText(this, "欢迎回来"+user.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
