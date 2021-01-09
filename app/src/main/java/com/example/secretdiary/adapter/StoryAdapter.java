package com.example.secretdiary.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secretdiary.AddUpdateActivity;
import com.example.secretdiary.CustomOnItemClickListener;
import com.example.secretdiary.R;
import com.example.secretdiary.entity.Story;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private final ArrayList<Story> listStory = new ArrayList<>();
    private final Activity activity;

    public StoryAdapter(Activity activity){
        this.activity = activity;
    }

    public ArrayList<Story>getListStory(){
        return listStory;
    }

    public void setListStory(ArrayList<Story> listStory){

        if (listStory.size() > 0){
            this.listStory.clear();
        }
        this.listStory.addAll(listStory);
        notifyDataSetChanged();
    }


    public void addItem(Story story){
        this.listStory.add(story);
        notifyItemInserted(listStory.size() - 1);
    }

    public void updateItem(int position, Story story){
        this.listStory.set(position, story);
        notifyItemChanged(position, story);
    }

    public void removeItem(int position){
        this.listStory.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listStory.size());
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        holder.tvTitle.setText(listStory.get(position).getTitle());
        holder.tvDate.setText(listStory.get(position).getDate());
        holder.tvDescription.setText(listStory.get(position).getDescription());
        holder.cvStory.setOnClickListener(new CustomOnItemClickListener(position, (view, position1) -> {
            Intent intent = new Intent(activity, AddUpdateActivity.class);
            intent.putExtra(AddUpdateActivity.EXTRA_POSITION, position1);
            intent.putExtra(AddUpdateActivity.EXTRA_NOTE, listNotes.get(position1));
            activity.startActivityForResult(intent, AddUpdateActivity.REQUEST_UPDATE);
        }));
    }

    @Override
    public int getItemCount() {
        return listStory.size();
    }

    static class StoryViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvDescription, tvDate;
        final CardView cvStory;

        StoryViewHolder(View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            cvStory = itemView.findViewById(R.id.cv_item_story);
        }
    }
}
