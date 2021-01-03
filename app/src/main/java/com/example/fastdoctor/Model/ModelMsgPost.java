package com.example.fastdoctor.Model;


public class ModelMsgPost {

    public String user_id, image_url, text_msg, timestamp;

    public ModelMsgPost() {
    }

    public ModelMsgPost(String user_id, String image_url, String text_post, String timestamp) {
        this.user_id = user_id;
        this.image_url = image_url;
        this.text_msg = text_post;
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

    public String getText_post() {
        return text_msg;
    }

    public void setText_post(String text_post) {
        this.text_msg = text_post;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
