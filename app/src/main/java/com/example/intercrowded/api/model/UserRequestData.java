package com.example.intercrowded.api.model;

public class UserRequestData {

    String user_id;
    GPSPoint startpoint;
    GPSPoint endpoint;
    Timespan timespan;

    public UserRequestData(String user_id, GPSPoint startpoint, GPSPoint endpoint, Timespan timespan) {
        this.user_id = user_id;
        this.startpoint = startpoint;
        this.endpoint = endpoint;
        this.timespan = timespan;
    }

    @Override
    public String toString() {
        return "{" +
                "user_id:'" + user_id + '\'' +
                ", startpoint:" + startpoint +
                ", endpoint:" + endpoint +
                ", timespan:" + timespan +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public GPSPoint getStartpoint() {
        return startpoint;
    }

    public GPSPoint getEndpoint() {
        return endpoint;
    }

    public Timespan getTimespan() {
        return timespan;
    }
}
