package com.example.mydesignapp.model;

public class NotificationModelClass {
    private int notificationIcon;
    private String notificationTitle;
    private String notificationDescription;
    private String notificationTime;

    public NotificationModelClass(int notificationIcon, String notificationTitle, String notificationDescription, String notificationTime) {
        this.notificationIcon = notificationIcon;
        this.notificationTitle = notificationTitle;
        this.notificationDescription = notificationDescription;
        this.notificationTime = notificationTime;
    }

    public int getNotificationIcon() {
        return notificationIcon;
    }

    public void setNotificationIcon(int notificationIcon) {
        this.notificationIcon = notificationIcon;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }
}
