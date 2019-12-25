package com.example.dbsystem.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbsystem.Helper.Constant;
import com.example.dbsystem.Helper.RepairNetWorkHelper;
import com.example.dbsystem.Interface.RepairCallback;
import com.example.dbsystem.R;
import com.example.dbsystem.ui.home.HomeFragment;

import java.util.Calendar;

public class CancelOrederActivity extends AppCompatActivity implements RepairCallback {
    private CalendarView mCalendar;
    private EditText mCanceltel,id,time;
    private Button mCancel;
    private String date = "";
    private RepairNetWorkHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_oreder);
        bindViews();
        helper=new RepairNetWorkHelper();
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (!isDateAfter(year, month, (dayOfMonth + 1))) {
                    Toast.makeText(CancelOrederActivity.this, "您不可以选择当前日期之前的场地", Toast.LENGTH_SHORT).show();
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
                    //场地查询
                    mCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "cancel:" + date+"&"+mCanceltel.getText().toString()+"&"+id.getText()+"&"+time.getText(), CancelOrederActivity.this);
                            // repairNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "queryrepairplace:", HomeFragment.this);
                        }
                    });
                }

            }
        });
    }
    private void bindViews() {

        mCalendar = (CalendarView) findViewById(R.id.calendar);
        mCanceltel = (EditText) findViewById(R.id.canceltel);
        mCancel = (Button) findViewById(R.id.cancel);
        id=findViewById(R.id.editid);
        time=findViewById(R.id.edittime);
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
    public void onRepairSucceed(String response) {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }
}
