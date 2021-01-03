package com.example.fastdoctor;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.example.fastdoctor.Forum.CardiologieForumFrag;
import com.example.fastdoctor.Forum.GeneralForumFrag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ForumFrag extends Fragment implements AdapterView.OnItemSelectedListener {
    private FloatingActionButton btnShowNewPost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.forum_frag, container, false);
        // Create list of specials
        Spinner spinner = (Spinner) v.findViewById(R.id.select_forum);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Specialites, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Show feedback post in forum
        btnShowNewPost = (FloatingActionButton) v.findViewById(R.id.btn_show_new_post);
        btnShowNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                showDialog();
            }
        });

        return v;
    }

    //method defines the action on the item selected in the list of specials
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
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();
            CardiologieForumFrag cardiologieForumFrag = new CardiologieForumFrag();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.main_home, cardiologieForumFrag, cardiologieForumFrag.getTag()).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //Creation method showDialog
    private void showDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("Nouveau post");

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View reg_layout = inflater.inflate(R.layout.feedback_new_post, null);

        dialog.setView(reg_layout);

        dialog.setPositiveButton("POST", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        // Button close dialog
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}