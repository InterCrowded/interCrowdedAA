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

    public Timespan getTimespan() {
        return timespan;
    }

    public GPSPoint getStartpoint() {
        return startpoint;
    }

    public GPSPoint getEndpoint() {
        return endpoint;
    }

    public double getOccupancy() {
        return occupancy;
    }

    public double getRating() {
        return rating;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    @Override
    public String toString() {
        return "InterPath{" +
                "timespan=" + timespan.toString() +
                ", startpoint=" + startpoint.toString() +
                ", endpoint=" + endpoint.toString() +
                ", occupancy=" + occupancy +
                ", rating=" + rating +
                ", vehicle_type='" + vehicle_type + '\'' +
                '}';
    }
}
