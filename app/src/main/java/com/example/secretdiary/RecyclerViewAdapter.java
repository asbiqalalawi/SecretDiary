package com.example.secretdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Story> mData;

    public RecyclerViewAdapter(Context mContext, List<Story> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_story,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_date.setText(mData.get(position).getDate());
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_time.setText(mData.get(position).getClock());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        private TextView tv_date;
        private TextView tv_title;
        private TextView tv_time;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_date = (TextView) itemView.findViewById(R.id.date_text);
            tv_title = (TextView) itemView.findViewById(R.id.title_text);
            tv_time = (TextView) itemView.findViewById(R.id.time_text);
            img = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
