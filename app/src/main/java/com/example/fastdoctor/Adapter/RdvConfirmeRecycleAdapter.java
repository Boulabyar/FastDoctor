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

public class RdvConfirmeRecycleAdapter extends RecyclerView.Adapter<RdvConfirmeRecycleAdapter.RdvConfirmeViewHolder> {
    private final List<ModelRdv> rdvList;
    private final LayoutInflater mInflater;
    private final Context context;
    private Dialog myDialog;

    public RdvConfirmeRecycleAdapter(Context context, List<ModelRdv> rdvList) {
        this.context = context;
        this.rdvList = rdvList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RdvConfirmeRecycleAdapter.RdvConfirmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_rdv_confirm, parent, false);

        final RdvConfirmeRecycleAdapter.RdvConfirmeViewHolder rdvConfirmeViewHolder = new RdvConfirmeRecycleAdapter.RdvConfirmeViewHolder(mItemView, this);

        //Dialog unit
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_doctor);

        //Open dialog contact
        rdvConfirmeViewHolder.Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView usernameD = myDialog.findViewById(R.id.username_doct);
                final int position = rdvConfirmeViewHolder.getAdapterPosition();
                final ModelRdv mCurrent = rdvList.get(position);
                usernameD.setText(mCurrent.getUserIdDoctor());
                myDialog.show();
                //Action send message from dialog contact
                CardView sendMsg = myDialog.findViewById(R.id.card_send_msg);
                sendMsg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, ChatActivity.class)
                                .putExtra("userID", mCurrent.getUserIdDoctor())
                                .putExtra("userImg", mCurrent.getImageUrl()));
                    }
                });
            }
        });

        return rdvConfirmeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RdvConfirmeRecycleAdapter.RdvConfirmeViewHolder holder, int position) {
        ModelRdv mCurrent = rdvList.get(position);

        holder.userIdDoctor.setText(mCurrent.getUserIdDoctor());
        holder.timeRdv.setText(mCurrent.getTimeRdv());
        holder.timeSend.setText(mCurrent.getTimeSend());
        holder.timeConfirm.setText(mCurrent.getTimeConfirm());
    }

    @Override
    public int getItemCount() {
        return rdvList.size();
    }

    public static class RdvConfirmeViewHolder extends RecyclerView.ViewHolder {
        //public final TextView  imageUrlDoctor;
        public final LinearLayout Doctor;

        public final TextView userIdDoctor;
        public final TextView timeRdv;
        public final TextView timeSend;
        public final TextView timeConfirm;
        final RdvConfirmeRecycleAdapter mAdapter;

        public RdvConfirmeViewHolder(@NonNull View itemView, RdvConfirmeRecycleAdapter adapter) {
            super(itemView);
            Doctor = itemView.findViewById(R.id.doctor);
            userIdDoctor = itemView.findViewById(R.id.username_doct);
            //imageUrlDoctor = itemView.findViewById(R.id.img_profil_doctor);
            timeRdv = itemView.findViewById(R.id.date_rdv);
            timeSend = itemView.findViewById(R.id.date_send_rdv);
            timeConfirm = itemView.findViewById(R.id.date_confirm_rdv);

            this.mAdapter = adapter;
        }
    }
}