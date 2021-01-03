package com.example.fastdoctor.patient;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fastdoctor.Forum.GeneralForumFrag;
import com.example.fastdoctor.Model.ModelCommentPost;
import com.example.fastdoctor.Model.ModelForumPost;
import com.example.fastdoctor.R;
import com.example.fastdoctor.SearchActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class HomePatientFrag extends Fragment {

    private final List<ModelCommentPost> mcp = new ArrayList<>();
    private ImageButton imageButtonSearch;
    private FloatingActionButton btnShowNewPost;
    private LinearLayout rdvConfirmé;
    private LinearLayout historiqueRdv;


    public GeneralForumFrag generalForumFrag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_patient_frag, container, false);
        generalForumFrag = new GeneralForumFrag();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.main_home, generalForumFrag, generalForumFrag.getTag()).commit();

        //Start Action
        imageButtonSearch = (ImageButton) v.findViewById(R.id.button_search);
        imageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //Show feedback post in forum
        btnShowNewPost = (FloatingActionButton) v.findViewById(R.id.btn_show_new_post);
        btnShowNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                showDialog();
            }
        });
        //Open rdv Confirmé fragment
        rdvConfirmé = v.findViewById(R.id.rdv_confirmé);
        rdvConfirmé.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.container, new RdvConfirmeFrag()).commit();
                HomePatient.chipNavigationBar.setItemSelected(R.id.home, false);
            }
        });

        //Open historique rdv fragment
        historiqueRdv = v.findViewById(R.id.historique_rdv);
        historiqueRdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.container, new HistoriqueRdvPatientFrag()).commit();
                HomePatient.chipNavigationBar.setItemSelected(R.id.home, false);
            }
        });

        return v;
    }

    //Creation method showDialog NEW POST
    private void showDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("Nouveau post");

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View reg_layout = inflater.inflate(R.layout.feedback_new_post, null);

        final TextInputLayout editPost = reg_layout.findViewById(R.id.post);

        dialog.setView(reg_layout);
        //Action add post
        dialog.setPositiveButton("POST", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String postText = editPost.getEditText().getText().toString();
                if (!TextUtils.isEmpty(postText)) {
                    generalForumFrag.buildPostList().add(new ModelForumPost("Nom d'utilisateur", "image_url", postText, "18/12/2020 19:30", mcp));
                    generalForumFrag.postAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), postText, Toast.LENGTH_LONG).show();
                }
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