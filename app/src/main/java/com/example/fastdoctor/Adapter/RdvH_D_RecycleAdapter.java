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

public class RdvH_D_RecycleAdapter extends RecyclerView.Adapter<RdvH_D_RecycleAdapter.RdvViewHolder> {
    private final List<ModelRdv> rdvList;
    private final LayoutInflater mInflater;
    private final Context context;
    private Dialog myDialog;

    public RdvH_D_RecycleAdapter(Context context, List<ModelRdv> rdvList) {
        this.context = context;
        this.rdvList = rdvList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RdvH_D_RecycleAdapter.RdvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_histo_rdv, parent, false);

        final RdvH_D_RecycleAdapter.RdvViewHolder rdvViewHolder = new RdvH_D_RecycleAdapter.RdvViewHolder(mItemView, this);

        //Dialog unit
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_patient);

        //Open dialog contact
        rdvViewHolder.Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameP = myDialog.findViewById(R.id.username_patient);
                final int position = rdvViewHolder.getAdapterPosition();
                final ModelRdv mCurrent = rdvList.get(position);
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

        return rdvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RdvH_D_RecycleAdapter.RdvViewHolder holder, int position) {
        ModelRdv mCurrent = rdvList.get(position);
        holder.prefixName.setVisibility(View.GONE);
        holder.userIdPatient.setText(mCurrent.getUserId());
        holder.timeRdv.setText(mCurrent.getTimeRdv());
        holder.timeSend.setText(mCurrent.getTimeSend());
        holder.timeConfirm.setText(mCurrent.getTimeConfirm());
    }

    @Override
    public int getItemCount() {
        return rdvList.size();
    }

    public class RdvViewHolder extends RecyclerView.ViewHolder {
        //public final TextView  imageUrlPatient;
        public final LinearLayout Patient;
        public final TextView prefixName;

        public final TextView userIdPatient;
        public final TextView timeRdv;
        public final TextView timeSend;
        public final TextView timeConfirm;
        final RdvH_D_RecycleAdapter mAdapter;

        public RdvViewHolder(@NonNull View itemView, RdvH_D_RecycleAdapter adapter) {
            super(itemView);
            Patient = itemView.findViewById(R.id.identifiant);
            userIdPatient = itemView.findViewById(R.id.username);
            prefixName = itemView.findViewById(R.id.prefix_name);
            //imageUrlpatient = itemView.findViewById(R.id.img_profil_doctor);
            timeRdv = itemView.findViewById(R.id.date_rdv);
            timeSend = itemView.findViewById(R.id.date_send_rdv);
            timeConfirm = itemView.findViewById(R.id.date_confirm_rdv);

            this.mAdapter = adapter;
        }
    }
}