package com.example.fastdoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostRecycleAdapter extends RecyclerView.Adapter<PostRecycleAdapter.PostViewHolder > {

    private final List<ForumPost> forumPostList;
    private final LayoutInflater mInflater;

    public PostRecycleAdapter(Context context,List<ForumPost> forumPostList) {
        this.forumPostList=forumPostList;
        mInflater = LayoutInflater.from(context);
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        public final TextView namePostItemView;
        public final TextView postItemView ;
        public final TextView datePost ;
        final PostRecycleAdapter mAdapter;

        public PostViewHolder(@NonNull View itemView, PostRecycleAdapter adapter ) {
            super(itemView);
            postItemView = itemView.findViewById(R.id.questionPost);
            namePostItemView = itemView.findViewById(R.id.username);
            datePost = itemView.findViewById(R.id.DateTime_post);

            this.mAdapter = adapter;
        }
    }

    @NonNull
    @Override
    public PostRecycleAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_post_forum,parent,false);

        PostViewHolder postViewHolder = new PostViewHolder(mItemView,this);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        ForumPost mCurrent = forumPostList.get(position);
        holder.namePostItemView.setText(mCurrent.getUser_id());
        holder.postItemView.setText(mCurrent.getText_post());
        holder.datePost.setText(mCurrent.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return forumPostList.size();
    }


}
