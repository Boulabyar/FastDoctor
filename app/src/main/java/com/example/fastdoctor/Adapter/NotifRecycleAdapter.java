package com.example.fastdoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.Model.ModelMsgPost;
import com.example.fastdoctor.R;

import java.util.List;

public class NotifRecycleAdapter extends RecyclerView.Adapter<NotifRecycleAdapter.NotifViewHolder> {
    private final List<ModelMsgPost> notifList;
    private final LayoutInflater mInflater;

    public NotifRecycleAdapter(Context context, List<ModelMsgPost> notifList) {
        this.notifList = notifList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NotifRecycleAdapter.NotifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_notif, parent, false);

        NotifRecycleAdapter.NotifViewHolder notifViewHolder = new NotifRecycleAdapter.NotifViewHolder(mItemView, this);
        return notifViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotifRecycleAdapter.NotifViewHolder holder, int position) {
        ModelMsgPost mCurrent = notifList.get(position);
        holder.user_name_notifItemView.setText(mCurrent.getUser_id());
        holder.notifItemView.setText(mCurrent.getText_post());
        holder.datenotif.setText(mCurrent.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return notifList.size();
    }

    public class NotifViewHolder extends RecyclerView.ViewHolder {
        public final TextView user_name_notifItemView;
        public final TextView notifItemView;
        public final TextView datenotif;
        final NotifRecycleAdapter mAdapter;

        public NotifViewHolder(@NonNull View itemView, NotifRecycleAdapter adapter) {
            super(itemView);
            notifItemView = itemView.findViewById(R.id.notif);
            user_name_notifItemView = itemView.findViewById(R.id.username);
            datenotif = itemView.findViewById(R.id.DateTime_notif);

            this.mAdapter = adapter;
        }
    }
}
