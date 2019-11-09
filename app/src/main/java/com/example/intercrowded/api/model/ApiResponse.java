package com.example.intercrowded.api.model;

import java.util.ArrayList;

public class ApiResponse {

    ArrayList<RouteData> routes;

    public ApiResponse(ArrayList<RouteData> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "routes=" + routes.toString() +
                '}';
    }
}
