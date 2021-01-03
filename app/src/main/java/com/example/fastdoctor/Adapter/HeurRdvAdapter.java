package com.example.fastdoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fastdoctor.R;

public class HeurRdvAdapter extends ArrayAdapter {
    Context context;
    int adapterResources;
    String[] listheur;

    public HeurRdvAdapter(@NonNull Context context, int resource, @NonNull String[] listHeur) {
        super(context, resource, listHeur);
        this.context = context;
        this.adapterResources = resource;
        this.listheur = listHeur;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        LayoutInflater rowIflate = LayoutInflater.from(context);
        view = rowIflate.inflate(adapterResources, parent, false);
        RadioButton heurbtn = (RadioButton) view.findViewById(R.id.heur);
        String heur = listheur[position];

        heurbtn.setText(heur);
        return view;
    }
}
