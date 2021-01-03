package com.example.fastdoctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.NotifRecycleAdapter;
import com.example.fastdoctor.Model.ModelMsgPost;

import java.util.ArrayList;
import java.util.List;

public class NotificationFrag extends Fragment {

    private RecyclerView mRecyclerView;
    private NotifRecycleAdapter mAdapter;
    private List<ModelMsgPost> notifList;

    public NotificationFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.notif_patient_frag, container, false);

        // Recycle view notifications
        notifList = new ArrayList<>();
        notifList.add(new ModelMsgPost("Nom d'utilisateur 1", "image_url", "a publier dans forum géneral", "19:30"));
        notifList.add(new ModelMsgPost("Nom d'utilisateur 2", "image_url", "a commenter votre publication", "12:00"));
        notifList.add(new ModelMsgPost("Nom d'utilisateur 3", "image_url", "a réagir avec votre publication", "09:24"));
        notifList.add(new ModelMsgPost("Nom d'utilisateur 4", "image_url", "a publier dans forum géneral", "Hier 11:35"));

        notifList.add(new ModelMsgPost("Nom d'utilisateur 5", "image_url", "a publier dans forum cardiologie", "Hier 19:30"));
        notifList.add(new ModelMsgPost("Nom d'utilisateur 6", "image_url", "a réagir avec votre publication", "Hier 15:02"));
        notifList.add(new ModelMsgPost("Nom d'utilisateur 2", "image_url", "a publier dans forum géneral", "Hier 12:00"));
        notifList.add(new ModelMsgPost("Nom d'utilisateur 3", "image_url", "a commenter votre publication", "Hier 10:00"));

        mRecyclerView = v.findViewById(R.id.List_item_notif);

        mAdapter = new NotifRecycleAdapter(getContext(), notifList);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return v;
    }
}