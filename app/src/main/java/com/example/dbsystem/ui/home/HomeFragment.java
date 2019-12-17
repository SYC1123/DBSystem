package com.example.dbsystem.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dbsystem.Controller.PalceActivity;
import com.example.dbsystem.R;

import java.util.Calendar;

public class HomeFragment extends Fragment {
    //首页碎片
    private TextView mText_home;
    private CalendarView mCalendarView;
    private Button mSelect;
    private View root;
    private String TAG = "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        bindViews();
        //日期选择
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (!isDateAfter(year,month,dayOfMonth)) {
                    Toast.makeText(getContext(), "您不可以选择当前日期之前的场地", Toast.LENGTH_SHORT).show();
                } else {

                }

            }
        });
        //场地查询
        mSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), PalceActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    private void bindViews() {
        mCalendarView = (CalendarView) root.findViewById(R.id.calendarView);
        mSelect=root.findViewById(R.id.selectplace);
    }

    private boolean isDateAfter(int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(year, month,
                dayOfMonth, 0, 0, 0);
        if (tempCalendar.after(mCalendar))
            return true;
        else
            return false;
    }
}