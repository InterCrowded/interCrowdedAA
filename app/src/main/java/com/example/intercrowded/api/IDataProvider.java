package com.example.intercrowded.api;

import androidx.annotation.NonNull;

import com.example.intercrowded.api.response.RouteResponse;

public interface IDataProvider {

        //void getRoutes(String limit, String timestmp, String apikey, String hash, @NonNull DataListener<RouteResponse> contractsDataListener);

        void getRoutes(String limit, @NonNull DataListener<RouteResponse> contractsDataListener);


        interface DataListener<T> {

            void onSuccess(T t);

            void onError(String errorMessage);
        }
    }
