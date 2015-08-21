package com.moh.mohhtun.dailyworkout.timer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.moh.mohhtun.dailyworkout.R;

public class Timer2Activity extends ActionBarActivity {

    Switch switch10, switch20, switch30, switch40, switch50, switch60;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int timer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        switch10 = (Switch) findViewById(R.id.timerToggle);
        switch20 = (Switch) findViewById(R.id.timerToggle2);
        switch30 = (Switch) findViewById(R.id.timerToggle3);
        switch40 = (Switch) findViewById(R.id.timerToggle4);
        switch50 = (Switch) findViewById(R.id.timerToggle5);
        switch60 = (Switch) findViewById(R.id.timerToggle6);
        preferences = getSharedPreferences("MOH", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        intent = getIntent();
        timer = intent.getIntExtra("timer", 0);
        Log.i("Timer2", String.valueOf(timer));


        switch30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch10.setChecked(false);
                    switch20.setChecked(false);
                    switch40.setChecked(false);
                    switch50.setChecked(false);
                    switch60.setChecked(false);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();
                } else {
                    switch10.setClickable(true);
                    switch20.setClickable(true);
                    switch40.setClickable(true);
                    switch50.setClickable(true);
                    switch60.setClickable(true);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();
                }
            }
        });
        switch10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch30.setChecked(false);
                    switch20.setChecked(false);
                    switch40.setChecked(false);
                    switch50.setChecked(false);
                    switch60.setChecked(false);
                    timer = 10;
                    editor.putInt("timer", timer);
                    editor.commit();
                } else {
                    switch30.setClickable(true);
                    switch20.setClickable(true);
                    switch40.setClickable(true);
                    switch50.setClickable(true);
                    switch60.setClickable(true);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();
                }
            }
        });
        switch20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    switch30.setClickable(false);
//                    switch10.setClickable(false);
//                    switch40.setClickable(false);
//                    switch50.setClickable(false);
//                    switch60.setClickable(false);
                    switch30.setChecked(false);
                    switch10.setChecked(false);
                    switch40.setChecked(false);
                    switch50.setChecked(false);
                    switch60.setChecked(false);
                    timer = 20;
                    editor.putInt("timer", timer);
                    editor.commit();
                } else {
                    switch30.setClickable(true);
                    switch10.setClickable(true);
                    switch40.setClickable(true);
                    switch50.setClickable(true);
                    switch60.setClickable(true);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();

                }
            }
        });
        switch40.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    switch30.setClickable(false);
//                    switch20.setClickable(false);
//                    switch10.setClickable(false);
//                    switch50.setClickable(false);
//                    switch60.setClickable(false);
                    switch30.setChecked(false);
                    switch20.setChecked(false);
                    switch10.setChecked(false);
                    switch50.setChecked(false);
                    switch60.setChecked(false);
                    timer = 40;
                    editor.putInt("timer", timer);
                    editor.commit();
                } else {
                    switch30.setClickable(true);
                    switch20.setClickable(true);
                    switch10.setClickable(true);
                    switch50.setClickable(true);
                    switch60.setClickable(true);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();
                }
            }
        });
        switch50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    switch30.setClickable(false);
//                    switch20.setClickable(false);
//                    switch40.setClickable(false);
//                    switch10.setClickable(false);
//                    switch60.setClickable(false);
                    switch30.setChecked(false);
                    switch20.setChecked(false);
                    switch40.setChecked(false);
                    switch10.setChecked(false);
                    switch60.setChecked(false);
                    timer = 50;
                    editor.putInt("timer", timer);
                    editor.commit();
                } else {
                    switch30.setClickable(true);
                    switch20.setClickable(true);
                    switch40.setClickable(true);
                    switch10.setClickable(true);
                    switch60.setClickable(true);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();
                }
            }
        });
        switch60.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    switch30.setClickable(false);
//                    switch20.setClickable(false);
//                    switch40.setClickable(false);
//                    switch50.setClickable(false);
//                    switch10.setClickable(false);
                    switch30.setChecked(false);
                    switch20.setChecked(false);
                    switch40.setChecked(false);
                    switch50.setChecked(false);
                    switch10.setChecked(false);
                    timer = 60;
                    editor.putInt("timer", timer);
                    editor.commit();
                } else {
                    switch30.setClickable(true);
                    switch20.setClickable(true);
                    switch40.setClickable(true);
                    switch50.setClickable(true);
                    switch10.setClickable(true);
                    timer = 30;
                    editor.putInt("timer", timer);
                    editor.commit();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timer2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor = preferences.edit();
        editor.putInt("timer", timer);
        Log.i("TimerPause", String.valueOf(timer));
        editor.commit();
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        timer = preferences.getInt("timer", 0);
//        Log.i("TimerResume", String.valueOf(timer));
//    }

}
