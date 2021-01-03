package com.example.fastdoctor.Model;


public class ModelDoctor {

    public String user_id, image_url, Adress_c, specialite;

    public ModelDoctor() {
    }

    public ModelDoctor(String user_id, String image_url, String adress_c, String specialite) {
        this.user_id = user_id;
        this.image_url = image_url;
        Adress_c = adress_c;
        this.specialite = specialite;
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

    public String getAdress_c() {
        return Adress_c;
    }

    public void setAdress_c(String adress_c) {
        Adress_c = adress_c;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
