package com.example.fastdoctor.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.RdvD_RecycleAdapter;
import com.example.fastdoctor.Model.ModelRdv;
import com.example.fastdoctor.R;

import java.util.ArrayList;
import java.util.List;

public class RdvDemandéFrag extends Fragment {
    private RecyclerView mRecyclerView;
    private RdvD_RecycleAdapter mAdapter;
    private List<ModelRdv> rdvD_List;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.rdv_demande_frag, container, false);

        // Unit AND action button back
        Button backBtn = v.findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomeDoctor.class);
                startActivity(intent);
            }
        });

        // Recycle view Rdv confirmé
        rdvD_List = new ArrayList<>();
        rdvD_List.add(new ModelRdv("Nom patient 1", "", "image_url", "24-12-2020  h 09:30", "23-12-2020  h19:00"));
        rdvD_List.add(new ModelRdv("Nom patient 2", "", "image_url", "24-12-2020  h 11:00", "23-12-2020  h15:25"));
        rdvD_List.add(new ModelRdv("Nom patient 3", "", "image_url", "24-12-2020  h 13:00", "23-12-2020  h13:01"));
        rdvD_List.add(new ModelRdv("Nom patient 3", "", "image_url", "24-12-2020  h 14:30", "23-12-2020  h10:15"));


        mRecyclerView = v.findViewById(R.id.L_rdv_demande_view);

        mAdapter = new RdvD_RecycleAdapter(getContext(), rdvD_List);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return v;
    }
}