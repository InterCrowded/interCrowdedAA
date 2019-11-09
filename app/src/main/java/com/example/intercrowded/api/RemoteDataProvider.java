package com.example.intercrowded.api;

import androidx.annotation.NonNull;

import com.example.intercrowded.api.model.ApiResponse;
import com.example.intercrowded.api.response.RouteResponse;

public class RemoteDataProvider implements IDataProvider {

    private final IApiService apiService = RetrofitClient.getInstance().getApiService();

    private RemoteDataProvider() {
    }

    public static RemoteDataProvider instance() {
        return RemoteDataProviderInstanceHolder.instance;
    }

    @Override
    public void getRoutes(String user_id, String startpoint, String endpoint, String timespan, @NonNull DataListener<ApiResponse> routeListener) {


        ResponseHandler.handleCall(apiService.getRoutes(user_id, startpoint, endpoint, timespan), routeListener);

    }

    private static class RemoteDataProviderInstanceHolder {
        static final RemoteDataProvider instance = new RemoteDataProvider();
    }
}