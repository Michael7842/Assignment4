package com.michael.customers.HelperClass;

public class Session {

    private String userName;
    private String duration;

    public Session() {

    }

    public Session(String userName, String userImage) {
        this.userName = userName;
        this.duration = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return duration;
    }

    public void setUserImage(String userImage) {
        this.duration = userImage;
    }
}