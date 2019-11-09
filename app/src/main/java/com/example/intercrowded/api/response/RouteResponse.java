package com.example.intercrowded.api.response;

public class RouteResponse {
    String message;


    public RouteResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    @Override
    public String toString() {
        return "RouteData{" +
                "message='" + message + '\'' +
                '}';
    }
}