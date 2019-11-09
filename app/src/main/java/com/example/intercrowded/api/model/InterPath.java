package com.example.intercrowded.api.model;

public class InterPath {

    Timespan timespan;
    GPSPoint startpoint;
    GPSPoint endpoint;
    double   occupancy;
    double   rating;
    String   vehicle_type;

    public InterPath(Timespan timespan, GPSPoint startpoint, GPSPoint endpoint, double occupancy, double rating, String vehicle_type) {
        this.timespan = timespan;
        this.startpoint = startpoint;
        this.endpoint = endpoint;
        this.occupancy = occupancy;
        this.rating = rating;
        this.vehicle_type = vehicle_type;
    }


}
