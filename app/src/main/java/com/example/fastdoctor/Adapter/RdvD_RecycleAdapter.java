package com.example.fastdoctor.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.ChatActivity;
import com.example.fastdoctor.Model.ModelRdv;
import com.example.fastdoctor.R;

import java.util.List;

public class RdvD_RecycleAdapter extends RecyclerView.Adapter<RdvD_RecycleAdapter.RdvD_ViewHolder> {
    private final List<ModelRdv> rdvD_List;
    private final LayoutInflater mInflater;
    private final Context context;
    private Dialog myDialog, confirmationDialog, refusDialog;

    public RdvD_RecycleAdapter(Context context, List<ModelRdv> rdvD_List) {
        this.context = context;
        this.rdvD_List = rdvD_List;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RdvD_RecycleAdapter.RdvD_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_rdv_demande, parent, false);

        final RdvD_RecycleAdapter.RdvD_ViewHolder rdvD_ViewHolder = new RdvD_RecycleAdapter.RdvD_ViewHolder(mItemView, this);

        //Unit dialog
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_patient);

        //Open contact dialog
        rdvD_ViewHolder.Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameP = myDialog.findViewById(R.id.username_patient);
                final int position = rdvD_ViewHolder.getAdapterPosition();
                final ModelRdv mCurrent = rdvD_List.get(position);
                usernameP.setText(mCurrent.getUserId());
                myDialog.show();
                //Action send message from dialog contact
                CardView sendMsg = myDialog.findViewById(R.id.card_send_msg);
                sendMsg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, ChatActivity.class)
                                .putExtra("userID", mCurrent.getUserId())
                                .putExtra("userImg", mCurrent.getImageUrl()));
                    }
                });
            }
        });

        //Unit Confirmation dialog
        confirmationDialog = new Dialog(parent.getContext());
        confirmationDialog.setContentView(R.layout.feedback_accept_rdv);
        //Open Confirmation dialog
        rdvD_ViewHolder.btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameP = confirmationDialog.findViewById(R.id.patient_name);
                final int position = rdvD_ViewHolder.getAdapterPosition();
                final ModelRdv mCurrent = rdvD_List.get(position);
                usernameP.setText(mCurrent.getUserId());
                confirmationDialog.show();
                //Action btn_non from dialog confirmation
                CardView annuler = confirmationDialog.findViewById(R.id.btn_Annuler);
                annuler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        confirmationDialog.dismiss();
                    }
                });
            }
        });

        //Unit Refus dialog
        refusDialog = new Dialog(parent.getContext());
        refusDialog.setContentView(R.layout.feedback_refus_rdv);
        //Open Refus dialog
        rdvD_ViewHolder.btn_refus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameP = refusDialog.findViewById(R.id.patient_name);
                final int position = rdvD_ViewHolder.getAdapterPosition();
                final ModelRdv mCurrent = rdvD_List.get(position);
                usernameP.setText(mCurrent.getUserId());
                refusDialog.show();
                //Action btn_non from dialog confirmation
                CardView annuler = refusDialog.findViewById(R.id.btn_Annuler);
                annuler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refusDialog.dismiss();
                    }
                });
            }
        });


        return rdvD_ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RdvD_RecycleAdapter.RdvD_ViewHolder holder, int position) {
        ModelRdv mCurrent = rdvD_List.get(position);

        holder.userIdPatient.setText(mCurrent.getUserId());
        holder.timeRdv.setText(mCurrent.getTimeRdv());
        holder.timeSend.setText(mCurrent.getTimeSend());

    }

    @Override
    public int getItemCount() {
        return rdvD_List.size();
    }

    public class RdvD_ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout Patient;
        public final TextView userIdPatient;
        public final TextView timeRdv;
        public final TextView timeSend;
        public final CardView btn_confirm;
        public final CardView btn_refus;

        final RdvD_RecycleAdapter mAdapter;

        public RdvD_ViewHolder(@NonNull View itemView, RdvD_RecycleAdapter adapter) {
            super(itemView);
            Patient = itemView.findViewById(R.id.patient);
            userIdPatient = itemView.findViewById(R.id.username_patient);
            timeRdv = itemView.findViewById(R.id.date_rdv);
            timeSend = itemView.findViewById(R.id.date_send_rdv);
            btn_confirm = itemView.findViewById(R.id.btn_confirmer);
            btn_refus = itemView.findViewById(R.id.btn_refuser);

            this.mAdapter = adapter;
        }
    }
}