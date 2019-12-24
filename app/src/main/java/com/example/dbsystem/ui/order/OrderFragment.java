package com.example.dbsystem.ui.order;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.OrderAdapter;
import com.example.dbsystem.Helper.OrderNetWorkHelper;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Interface.OrderCalllback;
import com.example.dbsystem.Model.OrderDetail;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment implements OrderCalllback {
    //订单碎片
    private RecyclerView recyclerView;
    private OrderNetWorkHelper helper;
    private String TAG = "OrderFragment";
    private List<OrderDetail> orderDetails;
    private User user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_order, container, false);
        user = SaveUserHelper.getUser(getContext(), "data", "user");
        recyclerView = root.findViewById(R.id.recycle);
        orderDetails = new ArrayList<OrderDetail>();

        helper = new OrderNetWorkHelper();
        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "order:" + user.getTel(), this);

        return root;
    }

    @Override
    public void onSucceed(String response) {

        try {
            // 整个最大的JSON数组
            JSONArray jsonArray = new JSONArray(response);
            Log.d(TAG, "订单的jsonArray:" + jsonArray);
            // [{"name":"君君","age":89,"sex":"男"},{"name":"小君","age":99,"sex":"女"},{"name":"大君","age":88,"sex":"男"}]

            for (int i = 0; i < jsonArray.length(); i++) {
                // JSON数组里面的具体-JSON对象
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.optInt("PlaceID", 0);
                String date = jsonObject.optString("Date", null);
                int time = jsonObject.optInt("OrderTime", 0);
                double price = jsonObject.optDouble("Money", 0);
                OrderDetail orderDetail = new OrderDetail(id, date, time, (float) price, user.getName());
                orderDetails.add(orderDetail);
                // 日志打印结果：
            }
            recyclerView.setAdapter(new OrderAdapter(orderDetails, getContext(),getActivity()));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}