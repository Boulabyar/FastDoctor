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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.ChatActivity;
import com.example.fastdoctor.Model.ModelCommentPost;
import com.example.fastdoctor.R;

import java.util.List;

public class CommentRecycleAdapter extends RecyclerView.Adapter<CommentRecycleAdapter.CommentViewHolder> {

    private Dialog myDialog;
    private final List<ModelCommentPost> commentPostList;
    private final Context context;

    public CommentRecycleAdapter(Context context, List<ModelCommentPost> commentPostList) {
        this.commentPostList = commentPostList;
        this.context = context;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public final ConstraintLayout userCommentItemView;
        public final TextView usernameComment;
        public final TextView commentItem;
        public final TextView dateComment;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            userCommentItemView = itemView.findViewById(R.id.item_comment);
            usernameComment = itemView.findViewById(R.id.username);
            commentItem = itemView.findViewById(R.id.comment);
            dateComment = itemView.findViewById(R.id.DateTime_comment);
        }
    }

    @NonNull
    @Override
    public CommentRecycleAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_comment, parent, false);

        final CommentViewHolder commentViewHolder = new CommentViewHolder(view);

        //Dialog unit
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_patient);

        //Open dialog contact
        commentViewHolder.userCommentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameC = myDialog.findViewById(R.id.username_patient);
                final int position = commentViewHolder.getAdapterPosition();
                final ModelCommentPost mCurrent = commentPostList.get(position);
                usernameC.setText(mCurrent.getUser_id());
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


        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        ModelCommentPost mCurrent = commentPostList.get(position);
        holder.usernameComment.setText(mCurrent.getUser_id());
        holder.commentItem.setText(mCurrent.getText_cmt());
        holder.dateComment.setText(mCurrent.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return commentPostList.size();
    }

}