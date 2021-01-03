package com.example.fastdoctor.Forum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.PostRecycleAdapter;
import com.example.fastdoctor.Model.ModelCommentPost;
import com.example.fastdoctor.Model.ModelForumPost;
import com.example.fastdoctor.R;

import java.util.ArrayList;
import java.util.List;


public class CardiologieForumFrag extends Fragment {

    private RecyclerView mRecyclerView;
    PostRecycleAdapter mAdapter;
    private List<ModelForumPost> postList;

    public CardiologieForumFrag() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.cardiologie_forum_frag, container, false);

        // Recycle view post forum
        postList = new ArrayList<>();
        postList.add(new ModelForumPost("Nom d'utilisateur 1", "image_url", "A quoi conçerne cette spécialité ?", "11/12/2020 20:03", buildCommentList()));
        postList.add(new ModelForumPost("Nom d'utilisateur 2", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "10/12/2020 21:30", buildCommentList()));
        postList.add(new ModelForumPost("Nom d'utilisateur 3", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "10/12/2020 11:05", buildCommentList()));
        postList.add(new ModelForumPost("Nom d'utilisateur 4", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "10/12/2020 09:06", buildCommentList()));
        postList.add(new ModelForumPost("Nom d'utilisateur 5", "image_url", "A quoi conçerne cette spécialité ?", "10/12/2020 08:30", buildCommentList()));
        postList.add(new ModelForumPost("Nom d'utilisateur 6", "image_url", "Au qulle age le risque de cardiovasculaire augmente chez les femmes ?", "09/12/2020 07:25", buildCommentList()));


        mRecyclerView = v.findViewById(R.id.Forum_post);

        mAdapter = new PostRecycleAdapter(getActivity(), postList);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return v;
    }

    private List<ModelCommentPost> buildCommentList() {
        List<ModelCommentPost> commentList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            ModelCommentPost commentPost = new ModelCommentPost("Non d'utilisateur", "url", "Commentaire " + i, "09:0" + i);
            commentList.add(commentPost);
        }
        return commentList;
    }
}