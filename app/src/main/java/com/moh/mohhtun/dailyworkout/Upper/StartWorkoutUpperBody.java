package com.moh.mohhtun.dailyworkout.Upper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moh.mohhtun.dailyworkout.R;
import com.moh.mohhtun.dailyworkout.WorkOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohmohhtun on 8/7/img15.
 */
public class StartWorkoutUpperBody extends ActionBarActivity {
    Button buttonStart;
    ProgressBar progressBar;
    TextView txtTimer;
    MyCountDownTimer myCountDownTimer;
    SharedPreferences prefs;
    List<WorkOut> workOuts = new ArrayList<WorkOut>();
    Integer[] imgList;
    Intent intent;
    TextView txtTitle;
    ImageView imgUpperBody;
    Button btnInfo, btnStartPause, btnNext;
    boolean status;
    long tempMillisec;
    int currentIndex;
    int timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startworkout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        imgList = new Integer[13];
        setDatatoimgList();
        initData();
        intent = getIntent();
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        imgUpperBody = (ImageView) findViewById(R.id.imgUpperBody);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnStartPause = (Button) findViewById(R.id.btnStartPause);
        btnNext = (Button) findViewById(R.id.btnNext);
        txtTimer = (TextView) findViewById(R.id.txtTimer);
        prefs = getSharedPreferences("MOH", MODE_PRIVATE);
        timer = intent.getIntExtra("timer", 0);
        Log.i("Timerrrr", String.valueOf(timer));
        currentIndex = intent.getIntExtra("resumeIndex", 0);
        txtTitle.setText(workOuts.get(currentIndex).getExerciseName() + System.getProperty("line.separator") + (currentIndex + 1) + "/" + imgList.length);
        imgUpperBody.setImageResource(workOuts.get(currentIndex).getImage());
        status = true;
        createProgress();

    }

    public void setDatatoimgList() {
        imgList[0] = R.drawable.img1;
        imgList[1] = R.drawable.img2;
        imgList[2] = R.drawable.img3;
        imgList[3] = R.drawable.img4;
        imgList[4] = R.drawable.img5;
        imgList[5] = R.drawable.img6;
        imgList[6] = R.drawable.img7;
        imgList[7] = R.drawable.img8;
        imgList[8] = R.drawable.img9;
        imgList[9] = R.drawable.img10;
        imgList[10] = R.drawable.img11;
        imgList[11] = R.drawable.img12;
        imgList[12] = R.drawable.img13;
    }

    private void initData() {
        Resources resources = getResources();
        String[] exerciseName = resources.getStringArray(R.array.upperbody);
        for (int i = 0; i < 13; i++) {
            WorkOut workout = new WorkOut();
            workout.setExerciseType("UpperBodyExercise");
            workout.setExerciseName(exerciseName[i]);
            workout.setImage(imgList[i]);
            workOuts.add(workout);

        }
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tempMillisec = millisUntilFinished;
            //int progress = (int) (30000 - millisUntilFinished);
            long tmp;

            txtTimer.setText(millitoFormat(millisUntilFinished));
            int progress = timer - (Integer.parseInt(millitoFormat(millisUntilFinished)) - 1);

            progressBar.setProgress(progress);
        }

        @Override
        public void onFinish() {
            currentIndex++;
            status = true;
            btnStartPause.setBackgroundResource(R.drawable.pausep);
            txtTimer.setText("Finished");
            progressBar.setProgress(timer);
            if (currentIndex <= 12) {
                createProgress();
                txtTitle.setText(workOuts.get(currentIndex).getExerciseName() + System.getProperty("line.separator") + (currentIndex + 1) + "/" + imgList.length);
                imgUpperBody.setImageResource(workOuts.get(currentIndex).getImage());
            }

        }

    }

    public String millitoFormat(long millis) {
        String hms = String.format("%02d",
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        return hms;
    }

    public void createProgress() {
        progressBar.setProgress(0);
        progressBar.setMax(timer);
        int milli = timer * 1000;
        myCountDownTimer = new MyCountDownTimer(milli, 1000);
        myCountDownTimer.start();
        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    btnStartPause.setBackgroundResource(R.drawable.playp);
                    myCountDownTimer.cancel();
                    status = false;
                } else {
                    btnStartPause.setBackgroundResource(R.drawable.pausep);
                    myCountDownTimer = new MyCountDownTimer(tempMillisec, 1000);
                    myCountDownTimer.start();
                    status = true;
                }
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartWorkoutUpperBody.this,UpperInfoActivity.class);
                intent.putExtra("info",currentIndex);
                startActivity(intent);
            }
        });
        if (currentIndex == 12) {

            btnNext.setEnabled(false);

        } else {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myCountDownTimer.cancel();
                    myCountDownTimer.onFinish();
                    status = true;
                }
            });
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        prefs = getSharedPreferences("MOH", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        if (currentIndex < 13) {
            editor.putInt("Index", currentIndex);
            editor.putString("Type", "upper");
            editor.commit();
        } else {
            currentIndex = 0;
            editor.putInt("Index", currentIndex);
            editor.putString("Type", "upper");
            editor.commit();
        }
    }
}
