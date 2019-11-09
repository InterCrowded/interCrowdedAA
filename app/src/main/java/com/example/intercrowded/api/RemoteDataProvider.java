package com.example.intercrowded.api;

import androidx.annotation.NonNull;

import com.example.intercrowded.api.response.RouteResponse;

public class RemoteDataProvider implements IDataProvider {

    private final IApiService apiService = RetrofitClient.getInstance().getApiService();

    private RemoteDataProvider() {
    }

    public static RemoteDataProvider instance() {
        return RemoteDataProviderInstanceHolder.instance;
    }

    @Override
    public void getRoutes(String limit, @NonNull DataListener<RouteResponse> routeListener) {


        ResponseHandler.handleCall(apiService.getRoutes(limit), routeListener);

    }

    private static class RemoteDataProviderInstanceHolder {
        static final RemoteDataProvider instance = new RemoteDataProvider();
    }
}