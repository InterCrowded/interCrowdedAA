package com.example.intercrowded.api.model;

public class GPSPoint {

    double latitude;
    double longitude;
    String name;

    public GPSPoint(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "latitude:" + latitude +
                ", longitude:" + longitude +
                '}';
    }
}
