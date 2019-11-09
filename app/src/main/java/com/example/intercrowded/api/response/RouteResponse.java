package com.example.intercrowded.api.response;

import com.example.intercrowded.api.model.RouteData;

import java.util.ArrayList;

public class RouteResponse {

    ArrayList<RouteData> routes;


    public RouteResponse(ArrayList<RouteData> routes) {
        this.routes = routes;
    }

    public ArrayList<RouteData> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<RouteData> routes) {
        this.routes = routes;

    }

    @Override
    public String toString() {
        return "RouteData{" +
                "routes='" + routes + '\'' +
                '}';
    }
}