package com.example.fastdoctor.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.ChatActivity;
import com.example.fastdoctor.Model.ModelRdv;
import com.example.fastdoctor.R;

import java.util.List;

public class RdvCourantRecycleAdapter extends RecyclerView.Adapter<RdvCourantRecycleAdapter.RdvC_ViewHolder> {
    private final List<ModelRdv> rdvC_List;
    private final LayoutInflater mInflater;
    public final Context context;
    private Dialog myDialog;

    public RdvCourantRecycleAdapter(Context context, List<ModelRdv> rdvC_List) {
        this.rdvC_List = rdvC_List;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RdvCourantRecycleAdapter.RdvC_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_rdv_courant, parent, false);

        final RdvCourantRecycleAdapter.RdvC_ViewHolder rdvC_ViewHolder = new RdvCourantRecycleAdapter.RdvC_ViewHolder(mItemView, this);

        //Dialog unit
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_patient);

        //Open dialog contact
        rdvC_ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameP = myDialog.findViewById(R.id.username_patient);
                final int position = rdvC_ViewHolder.getAdapterPosition();
                final ModelRdv mCurrent = rdvC_List.get(position);
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

        return rdvC_ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RdvCourantRecycleAdapter.RdvC_ViewHolder holder, int position) {
        final ModelRdv mCurrent = rdvC_List.get(position);
        holder.patientItemView.setText(mCurrent.getUserId());
        holder.ageItemView.setText(mCurrent.getAge());
        holder.dateRdv.setText(mCurrent.getTimeRdv());
    }

    @Override
    public int getItemCount() {
        return rdvC_List.size();
    }

    public class RdvC_ViewHolder extends RecyclerView.ViewHolder {
        public final TextView patientItemView;
        public final TextView ageItemView;
        public final TextView dateRdv;
        final RdvCourantRecycleAdapter mAdapter;

        public RdvC_ViewHolder(@NonNull View itemView, RdvCourantRecycleAdapter adapter) {
            super(itemView);
            patientItemView = itemView.findViewById(R.id.username);
            ageItemView = itemView.findViewById(R.id.age);
            dateRdv = itemView.findViewById(R.id.DateTime_rdv);

            this.mAdapter = adapter;
        }
    }
}
