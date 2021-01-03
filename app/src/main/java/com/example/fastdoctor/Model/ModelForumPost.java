package com.example.fastdoctor.Model;

import java.util.List;

public class ModelForumPost {

    public String user_id, image_url, text_post, timestamp;
    public List<ModelCommentPost> commentPostList;

    public ModelForumPost() {
    }

    public ModelForumPost(String user_id, String image_url, String text_post, String timestamp, List<ModelCommentPost> commentPostList) {
        this.user_id = user_id;
        this.image_url = image_url;
        this.text_post = text_post;
        this.timestamp = timestamp;
        this.commentPostList = commentPostList;
    }

    public List<ModelCommentPost> getCommentPostList() {
        return commentPostList;
    }

    public void setCommentPostList(List<ModelCommentPost> commentPostList) {
        this.commentPostList = commentPostList;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getText_post() {
        return text_post;
    }

    public void setText_post(String text_post) {
        this.text_post = text_post;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
