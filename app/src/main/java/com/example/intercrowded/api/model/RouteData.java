package com.example.intercrowded.api.model;

import java.util.ArrayList;

public class RouteData {

    String route_id;
    ArrayList<InterPath> paths;

    public RouteData(String route_id, ArrayList<InterPath> paths) {
        this.route_id = route_id;
        this.paths = paths;
    }

    @Override
    public String toString() {
        return "RouteData{" +
                "route_id='" + route_id + '\'' +
                ", paths=" + paths.toString() +
                '}';
    }
}

