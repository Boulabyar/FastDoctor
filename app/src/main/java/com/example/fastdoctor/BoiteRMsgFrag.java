package com.example.fastdoctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.MsgRecycleAdapter;
import com.example.fastdoctor.Model.ModelMsgPost;

import java.util.ArrayList;
import java.util.List;


public class BoiteRMsgFrag extends Fragment {

    private RecyclerView mRecyclerView;
    MsgRecycleAdapter mAdapter;
    private List<ModelMsgPost> msgList;

    public BoiteRMsgFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.msg_patient_frag, container, false);
        // Recycle view reception box messages
        msgList = new ArrayList<>();
        msgList.add(new ModelMsgPost("Nom d'utilisateur 1", "image_url", "Merci b1", "19:30"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 2", "image_url", "Ok", "15:02"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 3", "image_url", "Oui t'a raison", "12:00"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 4", "image_url", "Bonne nuit", "09:24"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 5", "image_url", "Nchallah", "Hier 11:35"));

        msgList.add(new ModelMsgPost("Nom d'utilisateur 6", "image_url", "Merci b1", "Hier 19:30"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 7", "image_url", "Ok", "Hier 15:02"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 8", "image_url", "Oui t'a raison", "Hier 12:00"));
        msgList.add(new ModelMsgPost("Nom d'utilisateur 9", "image_url", "Bonne nuit", "Hier 09:24"));

        mRecyclerView = v.findViewById(R.id.List_item_msg);

        mAdapter = new MsgRecycleAdapter(getActivity(), msgList);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return v;
    }
}