package com.example.secretdiary;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Story> lstStory;


    public MainFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main, container, false);
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