package com.example.mohmohhtun.dailyworkout;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;


public class AlarmActivity extends Activity {

    DatePicker pickerDate;
    TimePicker pickerTime;
    Switch alarmToggle;
    TextView info;
    Calendar current;
    Calendar calendar;
    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        pickerTime = (TimePicker) findViewById(R.id.alarmTimePicker);
        Calendar now = Calendar.getInstance();
        calendar = Calendar.getInstance();
        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));
        alarmToggle = (Switch) findViewById(R.id.alarmToggle);

        current = Calendar.getInstance();
        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    calendar.set(Calendar.HOUR_OF_DAY, pickerTime.getCurrentHour());
                    calendar.set(Calendar.MINUTE, pickerTime.getCurrentMinute());
                    Calendar cal = Calendar.getInstance();

                    if (calendar.compareTo(current) <= 0) {
//                        The set Date/Time already passed
                        Toast.makeText(getApplicationContext(),
                                "Invalid Date/Time",
                                Toast.LENGTH_LONG).show();
                    } else {
                        setAlarm(calendar);
                    }

                }
            }
        });
    }

    private void setAlarm(Calendar targetCal) {

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }
}
