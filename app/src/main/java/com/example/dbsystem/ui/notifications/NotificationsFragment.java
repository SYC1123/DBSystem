package com.example.dbsystem.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dbsystem.Controller.ChangeInfor;
import com.example.dbsystem.Controller.LoginActivity;
import com.example.dbsystem.Controller.MainActivity;
import com.example.dbsystem.Helper.SaveUserHelper;
import com.example.dbsystem.R;

public class NotificationsFragment extends Fragment {
    ConstraintLayout constraintLayout;
    Button exit;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        constraintLayout=root.findViewById(R.id.set);
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
        return root;
    }
}