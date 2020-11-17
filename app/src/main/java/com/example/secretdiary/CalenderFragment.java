package com.example.secretdiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secretdiary.R;
import com.example.secretdiary.RecyclerViewAdapter;
import com.example.secretdiary.Story;

import java.util.ArrayList;
import java.util.List;

public class CalenderFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Story> lstStory;


    public CalenderFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_calender, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler_story);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),lstStory);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstStory = new ArrayList<>();
        lstStory.add(new Story("Wed, Nov 11, 2020","Finally..","7:30 AM at Rajabasa Bandar Lampung",R.drawable.lj));

    }
}