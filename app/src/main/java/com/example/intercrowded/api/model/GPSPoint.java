package com.example.intercrowded.api.model;

public class GPSPoint {

    int latitude;
    int longitude;
    String name;

    public GPSPoint(int latitude, int longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }
}
