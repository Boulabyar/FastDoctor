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

public class GeneralForumFrag extends Fragment {
    public static RecyclerView pRecyclerView;
    public static PostRecycleAdapter postAdapter;

    public GeneralForumFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.general_forum_frag, container, false);

        //configure recycleview
        pRecyclerView = v.findViewById(R.id.Forum_post);

        postAdapter = new PostRecycleAdapter(getActivity(), buildPostList());
        pRecyclerView.setAdapter(postAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pRecyclerView.setLayoutManager(layoutManager);

        return v;
    }

    public List<ModelForumPost> buildPostList() {
        List<ModelForumPost> postList = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            ModelForumPost forumPost = new ModelForumPost("Nom d'utilisateur " + i, "image_url", "Post " + i, "19:3" + i, buildCommentList());
            postList.add(forumPost);
        }
        return postList;
    }

    public static List<ModelCommentPost> buildCommentList() {
        List<ModelCommentPost> commentList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            ModelCommentPost commentPost = new ModelCommentPost("Non d'utilisateur " + i, "url", "Commentaire " + i, "09:0" + i);
            commentList.add(commentPost);
        }
        return commentList;
    }
}