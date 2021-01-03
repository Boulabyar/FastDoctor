package com.example.fastdoctor.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.ChatActivity;
import com.example.fastdoctor.Model.ModelMsgPost;
import com.example.fastdoctor.R;

import java.util.List;

public class MsgRecycleAdapter extends RecyclerView.Adapter<MsgRecycleAdapter.PostMsgViewHolder> {
    private final List<ModelMsgPost> msgList;
    private final LayoutInflater mInflater;
    public final Context context;

    public MsgRecycleAdapter(Context context, List<ModelMsgPost> msgList) {
        this.msgList = msgList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MsgRecycleAdapter.PostMsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_boite_r_msg, parent, false);

        MsgRecycleAdapter.PostMsgViewHolder msgViewHolder = new MsgRecycleAdapter.PostMsgViewHolder(mItemView, this);
        return msgViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MsgRecycleAdapter.PostMsgViewHolder holder, int position) {
        final ModelMsgPost mCurrent = msgList.get(position);
        holder.nameMsgItemView.setText(mCurrent.getUser_id());
        holder.msgItemView.setText(mCurrent.getText_post());
        holder.dateMsg.setText(mCurrent.getTimestamp());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ChatActivity.class)
                        .putExtra("userID", mCurrent.getUser_id())
                        .putExtra("userImg", mCurrent.getImage_url()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    public class PostMsgViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameMsgItemView;
        public final TextView msgItemView;
        public final TextView dateMsg;
        final MsgRecycleAdapter mAdapter;

        public PostMsgViewHolder(@NonNull View itemView, MsgRecycleAdapter adapter) {
            super(itemView);
            msgItemView = itemView.findViewById(R.id.msg);
            nameMsgItemView = itemView.findViewById(R.id.username);
            dateMsg = itemView.findViewById(R.id.DateTime_msg);

            this.mAdapter = adapter;
        }
    }
}
