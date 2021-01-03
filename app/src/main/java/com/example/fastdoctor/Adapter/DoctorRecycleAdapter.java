package com.example.fastdoctor.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.ChatActivity;
import com.example.fastdoctor.Model.ModelDoctor;
import com.example.fastdoctor.R;

import java.util.List;

public class DoctorRecycleAdapter extends RecyclerView.Adapter<DoctorRecycleAdapter.DoctorViewHolder> {
    private Dialog myDialog, rdvDialog;
    private final List<ModelDoctor> doctorList;
    private final LayoutInflater mInflater;
    public final Context context;

    public DoctorRecycleAdapter(Context context, List<ModelDoctor> doctorList) {
        this.doctorList = doctorList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DoctorRecycleAdapter.DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_doctor_search, parent, false);

        final DoctorRecycleAdapter.DoctorViewHolder doctorViewHolder = new DoctorRecycleAdapter.DoctorViewHolder(mItemView, this);

        //Dialog unit
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_doctor);

        //Open dialog contact
        doctorViewHolder.Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameD = myDialog.findViewById(R.id.username_doct);
                final int position = doctorViewHolder.getAdapterPosition();
                final ModelDoctor mCurrent = doctorList.get(position);
                usernameD.setText(mCurrent.getUser_id());
                myDialog.show();
                //Action send message from dialog contact
                CardView sendMsg = myDialog.findViewById(R.id.card_send_msg);
                sendMsg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, ChatActivity.class)
                                .putExtra("userID", mCurrent.getUser_id())
                                .putExtra("userImg", mCurrent.getImage_url()));
                    }
                });
            }
        });

        //Dialog unit
        rdvDialog = new Dialog(parent.getContext());
        rdvDialog.setContentView(R.layout.feedback_fix_rdv);
        //Open dialog rdv
        doctorViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameD = rdvDialog.findViewById(R.id.name_doctor);
                final int position = doctorViewHolder.getAdapterPosition();
                final ModelDoctor mCurrent = doctorList.get(position);
                usernameD.setText(mCurrent.getUser_id());
                CalendarView calendar = rdvDialog.findViewById(R.id.calendar);
                calendar.setMinDate(System.currentTimeMillis() - 1000);
                //
                ListView listheure = rdvDialog.findViewById(R.id.list_heure_dispo);
                String[] dataHeur = {"09:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30"};

                HeurRdvAdapter adapter = new HeurRdvAdapter(context, R.layout.item_available_day, dataHeur);
                listheure.setAdapter(adapter);

                rdvDialog.show();
               /*//Action send message from dialog contact
                CalendarView calendar = myDialog.findViewById(R.id.calendar);
                calendar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, ChatActivity.class)
                                .putExtra("userID",mCurrent.getUser_id())
                                .putExtra("userImg",mCurrent.getImage_url()));
                    }
                });*/
            }
        });

        return doctorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DoctorRecycleAdapter.DoctorViewHolder holder, int position) {
        final ModelDoctor mCurrent = doctorList.get(position);
        holder.nameDoctorItemView.setText(mCurrent.getUser_id());
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout Doctor;
        public final TextView nameDoctorItemView;

        final DoctorRecycleAdapter mAdapter;

        public DoctorViewHolder(@NonNull View itemView, DoctorRecycleAdapter adapter) {
            super(itemView);
            nameDoctorItemView = itemView.findViewById(R.id.username);
            Doctor = itemView.findViewById(R.id.doctor);
            this.mAdapter = adapter;
        }
    }
}
