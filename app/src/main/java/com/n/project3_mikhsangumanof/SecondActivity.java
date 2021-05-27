package com.n.project3_mikhsangumanof;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Month;

public class SecondActivity extends Activity implements View.OnClickListener {
    DatePicker pickDate;
    TimePicker pickTime;
    Button btnDate, btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        pickDate = findViewById(R.id.pickDate);
        pickTime = findViewById(R.id.pickTime);
        pickTime.setIs24HourView(true);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);
        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDate:
                final String day = "Tanggal : "+pickDate.getDayOfMonth();
                String month = "\nBulan : "+(pickDate.getMonth()+1);
                String year = "\nTahun : "+pickDate.getYear();
                Toast.makeText(getApplicationContext(),day+month+year,Toast.LENGTH_LONG).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    pickDate.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            Toast.makeText(getApplicationContext(), dayOfMonth+"-"+monthOfYear+"-"+year,Toast.LENGTH_LONG).show();
                        }
                    });
                }
                break;
            case R.id.btnTime:
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    String hour = "Jam : "+pickTime.getHour();
//                    String minute = "\nMenit : "+pickTime.getMinute();
//                    Toast.makeText(getApplicationContext(),hour+minute,Toast.LENGTH_LONG).show();
//                }
                pickTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(getApplicationContext(), hourOfDay+" : "+minute,Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
