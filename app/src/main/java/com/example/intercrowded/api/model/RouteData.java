package com.example.intercrowded.api.model;

public class RouteData {
    String message;


    public RouteData(String message) {
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
