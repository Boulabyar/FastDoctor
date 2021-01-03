package com.example.fastdoctor.Model;

public class ModelRdv {

    public String userId, userIdDoctor, imageUrl, timeRdv, timeSend, timeConfirm, age;

    public ModelRdv(String userId, String userIdDoctor, String imageUrl, String timeRdv, String timeSend) {
        this.userId = userId;
        this.userIdDoctor = userIdDoctor;
        this.imageUrl = imageUrl;
        this.timeRdv = timeRdv;
        this.timeSend = timeSend;
    }

    public ModelRdv(String userId, String userIdDoctor, String imageUrl, String timeRdv, String timeSend, String timeConfirm) {
        this.userId = userId;
        this.userIdDoctor = userIdDoctor;
        this.imageUrl = imageUrl;
        this.timeRdv = timeRdv;
        this.timeSend = timeSend;
        this.timeConfirm = timeConfirm;
    }

    public ModelRdv(String userId, String userIdDoctor, String imageUrl, String timeRdv, String timeSend, String timeConfirm, String age) {
        this.userId = userId;
        this.userIdDoctor = userIdDoctor;
        this.imageUrl = imageUrl;
        this.timeRdv = timeRdv;
        this.timeSend = timeSend;
        this.timeConfirm = timeConfirm;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIdDoctor() {
        return userIdDoctor;
    }

    public void setUserIdDoctor(String userIdDoctor) {
        this.userIdDoctor = userIdDoctor;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTimeRdv() {
        return timeRdv;
    }

    public void setTimeRdv(String timeRdv) {
        this.timeRdv = timeRdv;
    }

    public String getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(String timeSend) {
        this.timeSend = timeSend;
    }

    public String getTimeConfirm() {
        return timeConfirm;
    }

    public void setTimeConfirm(String timeConfirm) {
        this.timeConfirm = timeConfirm;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
