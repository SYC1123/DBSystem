package com.example.dbsystem.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dbsystem.Helper.CollectionAdapter;
import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.MyCollectionNetWorkHelper;
import com.example.dbsystem.Helper.OrderAdapter;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Interface.MyCollectionCallback;
import com.example.dbsystem.Model.Collection;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyCollectionActivity extends AppCompatActivity implements MyCollectionCallback {
    private RecyclerView recyclerView;
    private MyCollectionNetWorkHelper helper;
    private User user;
    private List<Collection> collectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        recyclerView = findViewById(R.id.recycle1);
        helper = new MyCollectionNetWorkHelper();
        collectionList = new ArrayList<Collection>();
        user = SaveUserHelper.getUser(this, "data", "user");
        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "mycollection:" + user.getTel(), this);
    }

    @Override
    public void onSucceed(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String date = jsonObject.optString("Date", null);
                int id = jsonObject.optInt("PlaceID", 0);
                String url = jsonObject.optString("URL", null);

                Collection collection = new Collection(id, date, url);
                collectionList.add(collection);
            }
            CollectionAdapter adapter=new CollectionAdapter(collectionList, MyCollectionActivity.this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MyCollectionActivity.this));
            recyclerView.addItemDecoration(new DividerItemDecoration(MyCollectionActivity.this, LinearLayoutManager.VERTICAL));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
