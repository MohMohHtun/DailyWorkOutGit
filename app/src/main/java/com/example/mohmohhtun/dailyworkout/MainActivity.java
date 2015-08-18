package com.example.mohmohhtun.dailyworkout;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs;
    ImageView upper, core, lower, polymetric;
    Button btnStart, btnAlarm, btnTimer, btnAbout;
    int lastIndexU, lastIndexL, lastIndexC, lastIndexP;
    String type;
    public static boolean alarm;
    String hour;
    int count, timer;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("MOH", MODE_PRIVATE);
        editor = prefs.edit();
        lastIndexU = 0;
        lastIndexC = 0;
        lastIndexL = 0;
        lastIndexP = 0;
        hour = "";
        timer = 30;
        editor.putInt("timer", timer);
        editor.commit();
        type = "upper";
        upper = (ImageView) findViewById(R.id.upperImage);
        core = (ImageView) findViewById(R.id.coreImage);
        lower = (ImageView) findViewById(R.id.lowerImage);
        polymetric = (ImageView) findViewById(R.id.polymetriceImage);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnAlarm = (Button) findViewById(R.id.btnSetAlarm);
        btnTimer = (Button) findViewById(R.id.btnsetTimer);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        upper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UpperBodyActivity.class);
                // timer = prefs.getInt("timer",timer);
                i.putExtra("timer", timer);
                startActivity(i);
            }
        });
        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LowerBodyActivity.class);
                i.putExtra("timer", timer);
                startActivity(i);
            }
        });
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CoreActivity.class);
                i.putExtra("timer", timer);
                startActivity(i);
            }
        });
        polymetric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PolymetricActivity.class);
                i.putExtra("timer", timer);
                startActivity(i);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equalsIgnoreCase("upper")) {
                    Intent i = new Intent(MainActivity.this, StartWorkoutUpperBody.class);
                    i.putExtra("resumeIndex", lastIndexU);
                    i.putExtra("timer", timer);
                    startActivity(i);
                } else if (type.equalsIgnoreCase("lower")) {
                    Intent i = new Intent(MainActivity.this, StartWorkOutLowerBody.class);
                    i.putExtra("resumeIndexL", lastIndexL);
                    i.putExtra("timer", timer);
                    startActivity(i);
                } else if (type.equalsIgnoreCase("core")) {
                    Intent i = new Intent(MainActivity.this, StartWorkOutCore.class);
                    i.putExtra("resumeIndexC", lastIndexC);
                    i.putExtra("timer", timer);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, StartWorkOutPolymetric.class);
                    i.putExtra("resumeIndexP", lastIndexP);
                    i.putExtra("timer", timer);
                    startActivity(i);
                }
            }
        });
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AlarmActivity.class);
                // i.putExtra("Time",hour);
                startActivity(i);
            }
        });
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Timer2Activity.class);
                i.putExtra("timer", timer);
                startActivity(i);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    protected void onRestart() {
        super.onRestart();
        lastIndexU = prefs.getInt("Index", 0);
        lastIndexL = prefs.getInt("IndexForLower", 0);
        lastIndexC = prefs.getInt("IndexForCore", 0);
        lastIndexP = prefs.getInt("IndexForPoly", 0);
        type = prefs.getString("Type", "");
        alarm = prefs.getBoolean("setAlarm", true);
        timer = prefs.getInt("timer", 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lastIndexU = prefs.getInt("Index", 0);
        lastIndexL = prefs.getInt("IndexForLower", 0);
        lastIndexC = prefs.getInt("IndexForCore", 0);
        lastIndexP = prefs.getInt("IndexForPoly", 0);
        type = prefs.getString("Type", "");
        alarm = prefs.getBoolean("setAlarm", true);
        timer = prefs.getInt("timer", 0);
        Log.i("Main Resume", String.valueOf(alarm));
        Log.i("MainResumeT", String.valueOf(timer));

    }


}
