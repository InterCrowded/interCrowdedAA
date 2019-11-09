package com.example.intercrowded.api;

import com.example.intercrowded.api.model.ApiResponse;
import com.example.intercrowded.api.response.RouteResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {

    @GET("api/routes")
    Call<ApiResponse> getRoutes(@Query("user_id") String user_id, @Query("startpoint") String startpoint, @Query("endpoint") String endpoint, @Query("timespan") String timespan);

}
