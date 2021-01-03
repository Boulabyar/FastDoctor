package com.example.fastdoctor.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Adapter.RdvCourantRecycleAdapter;
import com.example.fastdoctor.Model.ModelCommentPost;
import com.example.fastdoctor.Model.ModelRdv;
import com.example.fastdoctor.R;
import com.example.fastdoctor.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeDoctorFrag extends Fragment {

    private final List<ModelCommentPost> mcp = new ArrayList<>();
    private ImageButton imageButtonSearch;
    private LinearLayout rdvDemandé;
    private LinearLayout historiqueRdv;

    public static RecyclerView rdvC_RecyclerView;
    public static RdvCourantRecycleAdapter rdvC_Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_doctor_frag, container, false);


        //Start Action chercher
        imageButtonSearch = (ImageButton) v.findViewById(R.id.button_search);
        imageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //Open rdv Confirmé fragment
        rdvDemandé = v.findViewById(R.id.rdv_demandé);
        rdvDemandé.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.container, new RdvDemandéFrag()).commit();
                HomeDoctor.chipNavigationBar.setItemSelected(R.id.home, false);
            }
        });

        //Open historique rdv fragment
        historiqueRdv = v.findViewById(R.id.historique_rdv);
        historiqueRdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.container, new HistoriqueRdvDoctFrag()).commit();
                HomeDoctor.chipNavigationBar.setItemSelected(R.id.home, false);
            }
        });

        //configure recycleview
        rdvC_RecyclerView = v.findViewById(R.id.list_rdv_recycled);

        rdvC_Adapter = new RdvCourantRecycleAdapter(getActivity(), buildRdvC_List());
        rdvC_RecyclerView.setAdapter(rdvC_Adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rdvC_RecyclerView.setLayoutManager(layoutManager);

        return v;
    }

    //create methode return list des rendez-vous courant
    public List<ModelRdv> buildRdvC_List() {
        List<ModelRdv> rdvC_List = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            ModelRdv rdvC = new ModelRdv("Nom patient " + i, "", "", "09:" + i + "0", "", "", "2" + i);
            rdvC_List.add(rdvC);
        }
        return rdvC_List;
    }
}