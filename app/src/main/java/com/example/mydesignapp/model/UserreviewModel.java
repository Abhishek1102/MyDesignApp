package com.example.mydesignapp.model;

public class UserreviewModel {
    private String username;
    private String userreview;
    private String userrating;
    private int userimage;

    public UserreviewModel(String username, String userreview, String userrating, int userimage) {
        this.username = username;
        this.userreview = userreview;
        this.userrating = userrating;
        this.userimage = userimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserreview() {
        return userreview;
    }

    public void setUserreview(String userreview) {
        this.userreview = userreview;
    }

    public String getUserrating() {
        return userrating;
    }

    public void setUserrating(String userrating) {
        this.userrating = userrating;
    }

    public int getUserimage() {
        return userimage;
    }

    public void setUserimage(int userimage) {
        this.userimage = userimage;
    }
}
