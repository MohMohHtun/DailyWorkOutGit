package com.moh.mohhtun.dailyworkout.Polymetric;

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

import com.moh.mohhtun.dailyworkout.R;
import com.moh.mohhtun.dailyworkout.WorkOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohmohhtun on 8/8/15.
 */
public class StartWorkOutPolymetric extends ActionBarActivity {
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
        imgList = new Integer[15];
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
        currentIndex = intent.getIntExtra("resumeIndexP", 0);
        txtTitle.setText(workOuts.get(currentIndex).getExerciseName() + System.getProperty("line.separator") + (currentIndex + 1) + "/" + imgList.length);
        imgUpperBody.setImageResource(workOuts.get(currentIndex).getImage());
        status = true;
        createProgress();

    }

    public void setDatatoimgList() {
        imgList[0] = R.drawable.img65;
        imgList[1] = R.drawable.img66;
        imgList[2] = R.drawable.img67;
        imgList[3] = R.drawable.img68;
        imgList[4] = R.drawable.img69;
        imgList[5] = R.drawable.img70;
        imgList[6] = R.drawable.img71;
        imgList[7] = R.drawable.img72;
        imgList[8] = R.drawable.img73;
        imgList[9] = R.drawable.img74;
        imgList[10] = R.drawable.img75;
        imgList[11] = R.drawable.img76;
        imgList[12] = R.drawable.img77;
        imgList[13] = R.drawable.img78;
        imgList[14] = R.drawable.img79;
    }

    private void initData() {
        Resources resources = getResources();
        String[] exerciseName = resources.getStringArray(R.array.polymetric);
        for (int i = 0; i < 15; i++) {
            WorkOut workout = new WorkOut();
            workout.setExerciseType("PolymetricExercise");
            workout.setExerciseName(exerciseName[i]);
            workout.setImage(imgList[i]);
            workOuts.add(workout);
            //workout.setInstruction();
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
            if (currentIndex <= 14) {
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
                Intent intent = new Intent(StartWorkOutPolymetric.this, PolymetricInfoActivity.class);
                intent.putExtra("info", currentIndex);
                startActivity(intent);
            }
        });
        if (currentIndex == 14) {

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
        if (currentIndex < 15) {
            editor.putInt("IndexForPoly", currentIndex);
            editor.putString("Type", "poly");
            editor.commit();
        } else {
            currentIndex = 0;
            editor.putInt("Index", currentIndex);
            editor.putString("Type", "upper");
            editor.commit();
        }
    }
}

