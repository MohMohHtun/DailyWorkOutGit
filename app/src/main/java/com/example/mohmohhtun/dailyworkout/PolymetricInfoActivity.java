package com.example.mohmohhtun.dailyworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * Created by mohmohhtun on 8/17/15.
 */
public class PolymetricInfoActivity extends ActionBarActivity {

    ImageView imageInfo;
    String[] info;
    Integer[] imgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        imgList = new Integer[15];
        imageInfo = (ImageView) findViewById(R.id.infoImage);
        setDatatoimgList();
        Intent intent = getIntent();
        int currentindex = intent.getIntExtra("info", 0);
        imageInfo.setImageResource(imgList[currentindex]);
    }

    public void setDatatoimgList() {

        imgList[0] = R.drawable.poly1;
        imgList[1] = R.drawable.poly2;
        imgList[2] = R.drawable.poly3;
        imgList[3] = R.drawable.poly4;
        imgList[4] = R.drawable.poly5;
        imgList[5] = R.drawable.poly6;
        imgList[6] = R.drawable.poly7;
        imgList[7] = R.drawable.poly8;
        imgList[8] = R.drawable.poly9;
        imgList[9] = R.drawable.poly10;
        imgList[10] = R.drawable.poly11;
        imgList[11] = R.drawable.poly12;
        imgList[12] = R.drawable.poly13;
        imgList[13] = R.drawable.poly14;
        imgList[14] = R.drawable.poly15;

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


