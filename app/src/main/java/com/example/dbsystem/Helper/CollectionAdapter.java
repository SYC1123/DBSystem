package com.example.dbsystem.Helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dbsystem.Controller.DetailsActivity;
import com.example.dbsystem.Interface.RepairCallback;
import com.example.dbsystem.Model.Collection;
import com.example.dbsystem.Model.OrderDetail;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

import java.util.List;


public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.MyHolder1>  {
    private List<Collection> collectionList;
    private AppCompatActivity activity;

    public CollectionAdapter(List<Collection> collectionList, AppCompatActivity appCompatActivity) {
        this.collectionList = collectionList;
        this.activity = appCompatActivity;
    }


    class MyHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener, RepairCallback {
        private ImageView mImg;
        private TextView mId;
        private TextView mDate;
        private Button mDelete;
        private AppCompatActivity mContent;
        private RepairNetWorkHelper helper;
        private User user;
        public MyHolder1(@NonNull View itemView, AppCompatActivity appCompatActivity) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mId = itemView.findViewById(R.id.id);
            mDate = itemView.findViewById(R.id.date);
            mDelete = itemView.findViewById(R.id.delete);
            mDelete.setOnClickListener(this);
            mContent = appCompatActivity;
            helper=new RepairNetWorkHelper();
            user=SaveUserHelper.getUser(mContent,"data","user");
        }

        public void bind(Collection collection) {
            mId.setText(collection.getPalceId() + "号场地");
            mDate.setText(collection.getCollectionDate());
            Glide.with(mContent)
                    .load(collection.getImageURL())
                    .into(mImg);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.delete:
//                    Toast.makeText(mContent, mId.getText(), Toast.LENGTH_SHORT).show();
                    String id=mId.getText().toString().substring(0,1);
                    helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "delete:" + id+"&"+user.getTel(), this);
                    break;
            }
        }

        @Override
        public void onRepairSucceed(String response) {
            Toast.makeText(mContent, response, Toast.LENGTH_SHORT).show();
            mContent.finish();
        }
    }

    @NonNull
    @Override
    public MyHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.collect, parent, false);
        return new MyHolder1(view, activity);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder1 holder, int position) {
        Collection collection = collectionList.get(position);
        holder.bind(collection);
    }

    @Override
    public int getItemCount() {
        return collectionList.size();
    }

}
