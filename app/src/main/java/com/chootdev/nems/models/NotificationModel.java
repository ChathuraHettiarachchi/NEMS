package com.chootdev.nems.models;

public class NotificationModel {

    public String description;
    public String date;

    public NotificationModel() {
    }

    public NotificationModel(String description, String date) {
        this.description = description;
        this.date = date;
    }
}
