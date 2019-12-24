package com.example.dbsystem.Helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbsystem.Model.OrderDetail;
import com.example.dbsystem.R;

import java.util.List;

class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView mPlaceId;
    TextView mOrderdate;
    TextView mName;
    TextView mPrice;
    TextView mTime;
    TextView mStatue;
    Button mAsk;
    private Context mContent;
    private Activity activity;
    String[] dates = {"8:00-10:00", "10:00-12:00", "13:00-15:00", "15:00-17:00", "18:00-20:00", "20:00-22:00"};

    public MyHolder(@NonNull View itemView, Context context, Activity activity) {
        super(itemView);
        mPlaceId = itemView.findViewById(R.id.placeId);
        mOrderdate = itemView.findViewById(R.id.orderdate);
        mName = itemView.findViewById(R.id.name);
        mPrice = itemView.findViewById(R.id.price);
        mTime = itemView.findViewById(R.id.opentime);
        mStatue = itemView.findViewById(R.id.statue);
        mAsk = itemView.findViewById(R.id.ask);
        mAsk.setOnClickListener(this);
        mContent = context;
        this.activity = activity;
    }

    public void bind(OrderDetail detail) {
        mPlaceId.setText(detail.getPalceId() + "号场地");
        mPrice.setText("￥" + detail.getPrice());
        mTime.setText(dates[detail.getTimeId() - 1]);
        mName.setText("预定人：" + detail.getName());
        mOrderdate.setText(detail.getOrderDate());
        mStatue.setText("已预定");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ask:
                if (ContextCompat.checkSelfPermission(mContent, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //未授权则调用ActivityCompat.requestPermissions（）方法
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    call();
                }
        }
    }

    public void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:18545626763"));
            activity.startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}

public class OrderAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<OrderDetail> orderDetailList;
    private Context context;
    private Activity activity;

    public OrderAdapter(List<OrderDetail> orderDetailList, Context context, Activity activity) {
        this.orderDetailList = orderDetailList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order, parent, false);

//        holder.fruitView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = holder.getAdapterPosition();
//                Fruit fruit = orderDetailList.get(position);
//                Toast.makeText(view.getContext(), "你点击了View" + fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = holder.getAdapterPosition();
//                Fruit fruit = orderDetailList.get(position);
//                Toast.makeText(view.getContext(), "你点击了图片" + fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });


        return new MyHolder(view, context, activity);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        OrderDetail detail = orderDetailList.get(position);
        holder.bind(detail);
    }

    @Override
    public int getItemCount() {
        return orderDetailList.size();
    }
}
