package com.example.intercrowded.api;

import com.example.intercrowded.api.response.RouteResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {

    @GET("/api/routes")
    Call<RouteResponse> getRoutes(@Query("limit") String limit/*, @Query("ts") String ts, @Query("apikey") String apiKey, @Query("hash") String hash*/);

}
