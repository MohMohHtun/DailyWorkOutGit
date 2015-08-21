package com.moh.mohhtun.dailyworkout.Core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.moh.mohhtun.dailyworkout.R;

/**
 * Created by mohmohhtun on 8/17/15.
 */
public class CoreInfoActivity extends ActionBarActivity {

    ImageView imageInfo;
    String[] info;
    Integer[] imgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        imgList = new Integer[18];
        imageInfo = (ImageView) findViewById(R.id.infoImage);
        setDatatoimgList();
        Intent intent = getIntent();
        int currentindex = intent.getIntExtra("info", 0);
        imageInfo.setImageResource(imgList[currentindex]);
    }

    public void setDatatoimgList() {

        imgList[0] = R.drawable.core1;
        imgList[1] = R.drawable.core2;
        imgList[2] = R.drawable.core3;
        imgList[3] = R.drawable.core4;
        imgList[4] = R.drawable.core5;
        imgList[5] = R.drawable.core6;
        imgList[6] = R.drawable.core7;
        imgList[7] = R.drawable.core8;
        imgList[8] = R.drawable.core9;
        imgList[9] = R.drawable.core10;
        imgList[10] = R.drawable.core11;
        imgList[11] = R.drawable.core12;
        imgList[12] = R.drawable.core13;
        imgList[13] = R.drawable.core14;
        imgList[14] = R.drawable.core15;
        imgList[15] = R.drawable.core16;
        imgList[16] = R.drawable.core17;
        imgList[17] = R.drawable.core18;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
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
}


