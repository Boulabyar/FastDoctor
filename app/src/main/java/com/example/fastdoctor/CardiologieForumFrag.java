package com.example.fastdoctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CardiologieForumFrag extends Fragment {

    private RecyclerView mRecyclerView;
    PostRecycleAdapter mAdapter;
    private List<ForumPost> postList;

    public CardiologieForumFrag() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.cardiologie_forum_frag, container, false);

        // Recycle view post forum
        postList=new ArrayList<>();
        postList.add(new ForumPost("Nom d'utilisateur", "image_url", "A quoi conçerne cette spécialité ?", "11/12/2020 20:03"));
        postList.add(new ForumPost("Nom d'utilisateur", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "10/12/2020 21:30"));
        postList.add(new ForumPost("Nom d'utilisateur", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "10/12/2020 11:05"));
        postList.add(new ForumPost("Nom d'utilisateur", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "10/12/2020 09:06"));
        postList.add(new ForumPost("Nom d'utilisateur", "image_url", "A quoi conçerne cette spécialité ?", "10/12/2020 08:30"));
        postList.add(new ForumPost("Nom d'utilisateur", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "09/12/2020 07:25"));


        mRecyclerView = v.findViewById(R.id.Forum_post);

        mAdapter = new PostRecycleAdapter(getActivity(),postList) ;
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return v;
    }
}