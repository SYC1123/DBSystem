package com.example.dbsystem.Helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbsystem.Model.OrderDetail;
import com.example.dbsystem.R;

import java.util.List;

class MyHolder extends RecyclerView.ViewHolder{
     TextView mPlaceId;
     TextView mOrderdate;
     TextView mName;
     TextView mPrice;
     TextView mTime;
     TextView mStatue;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        mPlaceId = itemView.findViewById(R.id.placeId);
        mOrderdate=itemView.findViewById(R.id.orderdate);
        mName=itemView.findViewById(R.id.name);
        mPrice=itemView.findViewById(R.id.price);
        mTime=itemView.findViewById(R.id.opentime);
        mStatue=itemView.findViewById(R.id.statue);
    }

    public void bind(OrderDetail detail){
        mPlaceId.setText(detail.getPalceId()+"");
        mPrice.setText(detail.getPrice()+"");
        mTime.setText(detail.getTimeId()+"");
        mName.setText(detail.getName());
        mOrderdate.setText(detail.getOrderDate());
        mStatue.setText(detail.getStatue()+"");
    }
}

public class OrderAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<OrderDetail> orderDetailList;

    public OrderAdapter(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
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


        return new MyHolder(view);
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
