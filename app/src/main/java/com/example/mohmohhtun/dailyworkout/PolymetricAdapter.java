package com.example.mohmohhtun.dailyworkout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by mohmohhtun on 8/8/15.
 */
public class PolymetricAdapter extends RecyclerView.Adapter<PolymetricAdapter.CustomViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<String> data = Collections.emptyList();
    Integer[] imgList = new Integer[15];

    public PolymetricAdapter(Context context, List<String> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        setDatatoimgList();

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

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.polymetric_list_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        CustomViewHolder holder1 = new CustomViewHolder(view);

        return holder1;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        String current = data.get(position);
        Log.i("CurrentAdapeter", current + "position:" + position);
        holder.imgExercise.setImageResource(imgList[position]);
        holder.text.setText(current);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView exerciseName;

        public MyViewHolder(View itemView) {
            super(itemView);
            exerciseName = (TextView) itemView.findViewById(R.id.exerciseName);
        }


        @Override
        public void onClick(View v) {

        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView imgExercise;

        public CustomViewHolder(View itemView) {
            super(itemView);
            imgExercise = (ImageView) itemView.findViewById(R.id.imgExercise);
            text = (TextView) itemView.findViewById(R.id.exerciseName);
        }

    }
}

