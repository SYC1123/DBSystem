package com.example.dbsystem.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dbsystem.Controller.PalceUpActivity;
import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.QueryPlaceNetWorkHelper;
import com.example.dbsystem.Interface.QueryPlaceCallback;
import com.example.dbsystem.Interface.RepairCallback;
import com.example.dbsystem.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment implements QueryPlaceCallback {
    //首页碎片
    private TextView mText_home;
    private CalendarView mCalendarView;
    private Button mSelect;
    private View root;
    private String TAG = "HomeFragment";
    private String date = "";
    private QueryPlaceNetWorkHelper helpe;
    Map<Integer, Integer> ordedPlace = new HashMap<Integer, Integer>();
    ArrayList<Integer> repairList = new ArrayList<Integer>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        bindViews();
        helpe = new QueryPlaceNetWorkHelper();
        //日期选择
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (!isDateAfter(year, month, (dayOfMonth + 1))) {
                    Toast.makeText(getContext(), "您不可以选择当前日期之前的场地", Toast.LENGTH_SHORT).show();
                } else {
                    String myear = year + "";
                    String mmonth = (month + 1) + "";
                    String day = dayOfMonth + "";
                    if ((month + 1) / 10 == 0) {
                        mmonth = "0" + mmonth;
                    }
                    if (dayOfMonth / 10 == 0) {
                        day = "0" + day;
                    }
                    date = year + "-" + mmonth + "-" + day;
//                    Toast.makeText(getContext(), ""+date, Toast.LENGTH_SHORT).show();
                }

            }
        });
        //场地查询
        mSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpe.startNetThread(Constant.IPADDRESS, Constant.PORT, "queryplace:" + date, HomeFragment.this);
                // repairNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "queryrepairplace:", HomeFragment.this);
            }
        });
        return root;
    }

    private void bindViews() {
        mCalendarView = (CalendarView) root.findViewById(R.id.calendarView);
        mSelect = root.findViewById(R.id.selectplace);
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


    @Override
    public void onSucceed(String response) {
        ordedPlace.clear();
        repairList.clear();
        try {
            /**
             * JSON数组有了 key person 这样的标记，就必须先是个 JSON对象
             * 最外层的JSON对象，最大的哪个 { ... }
             * 解析带KEY的json数组
             */
            JSONObject jsonObjectALL = new JSONObject(response);

            // 通过标识(person)，获取JSON数组
            JSONArray jsonArray = jsonObjectALL.getJSONArray("OrderedPlace");
            Log.d(TAG, "已经预定的 jsonArray:" + jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                // JSON数组里面的具体-JSON对象
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int placeid = jsonObject.optInt("PlaceID", 0);
                int ordertime = jsonObject.optInt("OrderTime", 0);
                ordedPlace.put(placeid, ordertime);
                // 日志打印结果：
            }
            Log.d(TAG, "已经预定的 解析的结果 " + ordedPlace);

            JSONArray jsonArray2 = jsonObjectALL.getJSONArray("RepairingPlace");
            Log.d(TAG, "维修的 jsonArray:" + jsonArray2);
            for (int i = 0; i < jsonArray2.length(); i++) {
                // JSON数组里面的具体-JSON对象
                JSONObject jsonObject = jsonArray2.getJSONObject(i);
                int placeid = jsonObject.optInt("PlaceID", 0);
                repairList.add(placeid);
                // 日志打印结果：
            }
            Log.d(TAG, "维修的 解析的结果 " + repairList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(getContext(), PalceUpActivity.class);
        intent.putIntegerArrayListExtra("repairID",repairList);
        intent.putExtra("map",(Serializable)ordedPlace);
        startActivity(intent);
    }
}