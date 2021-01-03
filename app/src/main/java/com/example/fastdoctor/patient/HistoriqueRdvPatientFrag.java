package com.example.fastdoctor.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.RdvH_P_RecycleAdapter;
import com.example.fastdoctor.Model.ModelRdv;
import com.example.fastdoctor.R;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueRdvPatientFrag extends Fragment {

    private RecyclerView mRecyclerView;
    private RdvH_P_RecycleAdapter mAdapter;
    private List<ModelRdv> rdvList;

    public HistoriqueRdvPatientFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.historique_rdv_frag, container, false);

        // Unit AND action button back
        Button backBtn = v.findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomePatient.class);
                startActivity(intent);
            }
        });

        // Recycle view Rdv
        rdvList = new ArrayList<>();
        rdvList.add(new ModelRdv("1", "Nom docteur 1", "image_url", "24-12-2020  h 09:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 2", "image_url", "24-12-2020  h 10:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 3", "image_url", "24-12-2020  h 11:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 4", "image_url", "24-12-2020  h 13:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 5", "image_url", "24-12-2020  h 14:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 6", "image_url", "24-12-2020  h 15:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 7", "image_url", "24-12-2020  h 16:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 8", "image_url", "24-12-2020  h 17:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));
        rdvList.add(new ModelRdv("1", "Nom docteur 9", "image_url", "24-12-2020  h 08:30", "23-12-2020  h19:00", "23-12-2020  h19:25"));

        mRecyclerView = v.findViewById(R.id.List_h_rdv_view);

        mAdapter = new RdvH_P_RecycleAdapter(getContext(), rdvList);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return v;
    }
}