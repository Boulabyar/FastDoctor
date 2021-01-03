package com.example.fastdoctor.patient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.DoctorRecycleAdapter;
import com.example.fastdoctor.Model.ModelDoctor;
import com.example.fastdoctor.R;

import java.util.ArrayList;
import java.util.List;

public class List_doctorFrag extends Fragment {
    public static RecyclerView dRecyclerView;
    public static DoctorRecycleAdapter doctorAdapter;

    public List_doctorFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.list_search_doctor, container, false);

        dRecyclerView = v.findViewById(R.id.List_doctor);

        doctorAdapter = new DoctorRecycleAdapter(getActivity(), buildDoctorList());
        dRecyclerView.setAdapter(doctorAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        dRecyclerView.setLayoutManager(layoutManager);

        return v;
    }

    public List<ModelDoctor> buildDoctorList() {
        List<ModelDoctor> doctorList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            ModelDoctor doctor = new ModelDoctor("Nom docteur " + i, "image_url", "Adresse" + i, "Géneraliste");
            doctorList.add(doctor);
        }
        return doctorList;
    }

}