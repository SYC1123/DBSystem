package com.example.dbsystem.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dbsystem.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    private TextView mText_home;
    private CalendarView mCalendarView;
    private View root;
    private String TAG = "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        bindViews();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
//        String currentDate =   dateFormat.format( new Date() );

        Calendar calendar = Calendar.getInstance();
//        mCalendarView.setMinDate(CalendarDay.from(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH +1), calendar.get(Calendar.DATE)));
        Log.d(TAG, "onCreateView: " + dateFormat.format(date));
//        mCalendarView.setMinDate(Long.parseLong(dateFormat.format(date)));
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getContext(), year + "年" + month + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    private void bindViews() {
        mCalendarView = (CalendarView) root.findViewById(R.id.calendarView);
    }

}