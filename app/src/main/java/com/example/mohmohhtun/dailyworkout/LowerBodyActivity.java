package com.example.mohmohhtun.dailyworkout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mohmohhtun on 8/8/img15.
 */
public class LowerBodyActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    RecyclerView recyclerView;
    public static List<String> lowerBodyExerciseName = new ArrayList<String>();
    public static LowerBodyAdapter adapter;
    Button btnStart;
    TextView txtTitle;
    ImageView imageView;
    int timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_activity);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Resources resources = getResources();
        String[] exerciseName = resources.getStringArray(R.array.lowerbody);
        List<String> exerciseNameList = new ArrayList<String>(Arrays.asList(exerciseName));
        lowerBodyExerciseName.clear();
        for (String current : exerciseNameList) {
            lowerBodyExerciseName.add(current);
        }
        recyclerView = (RecyclerView) findViewById(R.id.upper_recycler);
        txtTitle = (TextView) findViewById(R.id.textTitle);
        txtTitle.setText("LowerBody");
        imageView = (ImageView) findViewById(R.id.img);
        imageView.setImageResource(R.drawable.image25);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter = new LowerBodyAdapter(this, lowerBodyExerciseName);
        recyclerView.setAdapter(adapter);
        btnStart = (Button) findViewById(R.id.btnStartWorkout);
        Intent intent = getIntent();
        timer = intent.getIntExtra("timer", 0);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LowerBodyActivity.this, StartWorkOutLowerBody.class);
                intent.putExtra("timer", timer);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setBackgroundColor(Color.rgb(255, 255, 255));
    }
}
