package com.example.fastdoctor.Model;


public class ModelCommentPost {

    public String user_id, image_url, text_cmt, timestamp;

    public ModelCommentPost() {
    }

    public ModelCommentPost(String user_id, String image_url, String text_cmt, String timestamp) {
        this.user_id = user_id;
        this.image_url = image_url;
        this.text_cmt = text_cmt;
        this.timestamp = timestamp;
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

    public String getText_cmt() {
        return text_cmt;
    }

    public void setText_cmt(String text_cmt) {
        this.text_cmt = text_cmt;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
