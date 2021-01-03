package com.example.fastdoctor.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fastdoctor.R;

import static android.view.View.GONE;

public class FixRdvFlag extends Fragment implements AdapterView.OnItemSelectedListener {
    public CardView searchDoctor;
    public Spinner spinnerSpecialites;
    public Spinner spinnerVilles;

    public FixRdvFlag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fix_rdv_frag, container, false);

        // Unit AND action button back
        Button backBtn = v.findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomePatient.class);
                startActivity(intent);
            }
        });

        //Liste of speciales
        spinnerSpecialites = v.findViewById(R.id.select_special);
        ArrayAdapter<CharSequence> adapterSpecialities = ArrayAdapter.createFromResource(getActivity(), R.array.Specialites, android.R.layout.simple_spinner_item);
        adapterSpecialities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpecialites.setAdapter(adapterSpecialities);
        spinnerSpecialites.setOnItemSelectedListener(this);
        //Liste of contries
        spinnerVilles = v.findViewById(R.id.select_ville);
        ArrayAdapter<CharSequence> adapterVilles = ArrayAdapter.createFromResource(getActivity(), R.array.Villes, android.R.layout.simple_spinner_item);
        adapterVilles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVilles.setAdapter(adapterVilles);
        spinnerVilles.setOnItemSelectedListener(this);

        //Action click chercher
        final LinearLayout defaultImage = v.findViewById(R.id.default_img);
        searchDoctor = v.findViewById(R.id.card_serch_doct);
        searchDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultImage.setVisibility(GONE);
                List_doctorFrag list_doctorFrag = new List_doctorFrag();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.main_calendrier, list_doctorFrag, list_doctorFrag.getTag()).commit();
            }
        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if ((spinnerVilles.getSelectedItemPosition() >= 0) && (spinnerSpecialites.getSelectedItemPosition() >= 0))
            searchDoctor.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        searchDoctor.setVisibility(View.INVISIBLE);
    }
}