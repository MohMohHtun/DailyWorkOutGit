package com.example.mohmohhtun.dailyworkout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohmohhtun on 8/8/img15.
 */
public class StartWorkOutLowerBody extends ActionBarActivity {
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
    int timer, timer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startworkout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        imgList = new Integer[18];
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
        SharedPreferences.Editor editor = prefs.edit();
        timer = intent.getIntExtra("timer", 0);
        currentIndex = intent.getIntExtra("resumeIndexL", 0);
        txtTitle.setText(workOuts.get(currentIndex).getExerciseName() + System.getProperty("line.separator") + (currentIndex + 1) + "/" + imgList.length);
        imgUpperBody.setImageResource(workOuts.get(currentIndex).getImage());
        status = true;
        createProgress();

    }

    public void setDatatoimgList() {
        imgList[0] = R.drawable.img14;
        imgList[1] = R.drawable.img15;
        imgList[2] = R.drawable.img16;
        imgList[3] = R.drawable.img17;
        imgList[4] = R.drawable.img18;
        imgList[5] = R.drawable.img19;
        imgList[6] = R.drawable.img20;
        imgList[7] = R.drawable.img21;
        imgList[8] = R.drawable.img22;
        imgList[9] = R.drawable.img23;
        imgList[10] = R.drawable.img24;
        imgList[11] = R.drawable.img25;
        imgList[12] = R.drawable.img26;
        imgList[13] = R.drawable.img27;
        imgList[14] = R.drawable.img28;
        imgList[15] = R.drawable.img29;
        imgList[16] = R.drawable.img30;
        imgList[17] = R.drawable.img31;
    }

    private void initData() {
        Resources resources = getResources();
        String[] exerciseName = resources.getStringArray(R.array.lowerbody);
        for (int i = 0; i < 18; i++) {
            WorkOut workout = new WorkOut();
            workout.setExerciseType("LowerBodyExercise");
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
            if (currentIndex <= 17) {
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
        progressBar.setProgress(timer);
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
                Intent intent = new Intent(StartWorkOutLowerBody.this, LowerInfoActivity.class);
                intent.putExtra("info", currentIndex);
                startActivity(intent);
            }
        });
        if (currentIndex == 17) {

            btnNext.setEnabled(false);
            // currentIndex++;
        } else {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myCountDownTimer.cancel();
                    myCountDownTimer.onFinish();
                    // currentIndex++;
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
        if (currentIndex < 18) {
            editor.putInt("IndexForLower", currentIndex);
            editor.putString("Type", "lower");
            editor.commit();
        } else {
            currentIndex = 0;
            editor.putInt("Index", currentIndex);
            editor.putString("Type", "upper");
            editor.commit();
        }
    }
}

