package com.moh.mohhtun.dailyworkout.Upper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moh.mohhtun.dailyworkout.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by mohmohhtun on 8/7/img15.
 */
public class UpperBodyAdapter extends RecyclerView.Adapter<UpperBodyAdapter.CustomViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<String> data= Collections.emptyList();
    Integer[] imgList =  new Integer[13];

    public UpperBodyAdapter(Context context, List<String> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        setDatatoimgList();

    }
    public void setDatatoimgList()
    {
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
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.upperbody_list_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        CustomViewHolder holder1 = new CustomViewHolder(view);

        return holder1;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        String current = data.get(position);
        Log.i("CurrentAdapeter",current+"position:"+position);
        holder.imgExercise.setImageResource(imgList[position]);
        holder.text.setText(current);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView exerciseName;
        public MyViewHolder(View itemView) {
            super(itemView);
            exerciseName = (TextView) itemView.findViewById(R.id.exerciseName);
        }


        @Override
        public void onClick(View v) {

        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView imgExercise;
        public CustomViewHolder(View itemView) {
            super(itemView);
            imgExercise = (ImageView)itemView.findViewById(R.id.imgExercise);
            text = (TextView)itemView.findViewById(R.id.exerciseName);
        }

    }
}
