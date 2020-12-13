package com.example.fastdoctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ForumFrag extends Fragment implements AdapterView.OnItemSelectedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.forum_frag, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.select_forum);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.Forum_list,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (text.equals("Genéral")) {
            Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
            GeneralForumFrag generalForumFrag = new GeneralForumFrag();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.main_home, generalForumFrag, generalForumFrag.getTag()).commit();
        }
        if (text.equals("Cardiologie")) {
            Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
            CardiologieForumFrag cardiologieForumFrag = new CardiologieForumFrag();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.main_home, cardiologieForumFrag, cardiologieForumFrag.getTag()).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}