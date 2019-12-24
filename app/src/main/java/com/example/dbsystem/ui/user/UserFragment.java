package com.example.dbsystem.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.dbsystem.Controller.ChangeInfor;
import com.example.dbsystem.Controller.LoginActivity;
import com.example.dbsystem.Controller.MyCollectionActivity;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.Model.User;
import com.example.dbsystem.R;

public class UserFragment extends Fragment {
    ConstraintLayout constraintLayout,collection;
    Button exit;
    private TextView username,phone,opentime,address;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        username=root.findViewById(R.id.username);
        phone=root.findViewById(R.id.phone);
        opentime=root.findViewById(R.id.opentime);
        address=root.findViewById(R.id.address);
        User user=SaveUserHelper.getUser(getContext(),"data","user");
        username.setText(user.getName());
        phone.setText(user.getTel());
        opentime.setText(user.getDate());
        address.setText(user.getAddress());
        constraintLayout=root.findViewById(R.id.set);
        collection=root.findViewById(R.id.collection);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ChangeInfor.class);
                startActivity(intent);
            }
        });
        exit=root.findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveUserHelper.saveNotlogin(getContext(),"data","islogin");
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });

        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyCollectionActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }
}