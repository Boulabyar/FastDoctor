package com.example.fastdoctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class HomePatientFrag extends Fragment {
    private ImageButton imageButtonSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_patient_frag, container, false);
        GeneralForumFrag generalForumFrag = new GeneralForumFrag();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.main_home,generalForumFrag,generalForumFrag.getTag()).commit();

        //Start Action search
        imageButtonSearch =(ImageButton) v.findViewById(R.id.button_search);
        imageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Search.class);
                startActivity(intent);
            }
        });
        return v;
    }
}