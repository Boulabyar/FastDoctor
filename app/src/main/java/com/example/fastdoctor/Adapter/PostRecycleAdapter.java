package com.example.fastdoctor.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastdoctor.ChatActivity;
import com.example.fastdoctor.Model.ModelForumPost;
import com.example.fastdoctor.R;

import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class PostRecycleAdapter extends RecyclerView.Adapter<PostRecycleAdapter.PostViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<ModelForumPost> forumPostList;

    private Dialog myDialog;
    private final LayoutInflater mInflater;
    private final Context context;

    public PostRecycleAdapter(Context context, List<ModelForumPost> forumPostList) {
        this.forumPostList = forumPostList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public final ConstraintLayout userPostItemView;
        public final LinearLayout showComments;
        public final TextView namePostItemView;
        public final TextView postItemView;
        public final TextView datePost;
        public final EditText editComment;
        public final Button sendComment;
        //public final TextView nbrComments ;

        //public final PostRecycleAdapter mAdapter;
        private RecyclerView commentList;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            //Variable for action click
            userPostItemView = itemView.findViewById(R.id.user_post);
            showComments = itemView.findViewById(R.id.show_comments);
            //Variable
            postItemView = itemView.findViewById(R.id.questionPost);
            namePostItemView = itemView.findViewById(R.id.username);
            datePost = itemView.findViewById(R.id.DateTime_post);
            //nbrComments = itemView.findViewById(R.id.nbr_comment);
            commentList = itemView.findViewById(R.id.comment_list);
            editComment = itemView.findViewById(R.id.edit_comment);
            sendComment = itemView.findViewById(R.id.send_comment);
        }
    }

    @NonNull
    @Override
    public PostRecycleAdapter.PostViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_post_forum, parent, false);

        final PostViewHolder postViewHolder = new PostViewHolder(mItemView);

        //Dialog contact unit
        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.feedback_contact_patient);

        //Open dialog contact
        postViewHolder.userPostItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usernameP = myDialog.findViewById(R.id.username_patient);
                final int position = postViewHolder.getAdapterPosition();
                final ModelForumPost mCurrent = forumPostList.get(position);
                usernameP.setText(mCurrent.getUser_id());
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

        //Show or hide comments
        postViewHolder.showComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postViewHolder.commentList.getVisibility() == GONE)
                    postViewHolder.commentList.setVisibility(VISIBLE);
                else postViewHolder.commentList.setVisibility(GONE);
            }
        });

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, int position) {
        ModelForumPost mCurrent = forumPostList.get(position);
        holder.namePostItemView.setText(mCurrent.getUser_id());
        holder.postItemView.setText(mCurrent.getText_post());
        holder.datePost.setText(mCurrent.getTimestamp());

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.commentList.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(mCurrent.getCommentPostList().size());

        //Create comment view adapter
        CommentRecycleAdapter commentRecycleAdapter = new CommentRecycleAdapter(context, mCurrent.getCommentPostList());
        holder.commentList.setLayoutManager(layoutManager);
        holder.commentList.setAdapter(commentRecycleAdapter);
        holder.commentList.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return forumPostList.size();
    }


}
