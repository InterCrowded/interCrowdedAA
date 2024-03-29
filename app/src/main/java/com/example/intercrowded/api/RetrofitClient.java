package com.example.intercrowded.api;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String API_BASE_URL = "http://18.203.246.79:8081/";


    private static final RetrofitClient mInstance = new RetrofitClient();
    private Retrofit retrofit;
    private IApiService apiService;

    private RetrofitClient() {

    }

    public static RetrofitClient getInstance() {
        return mInstance;
    }

    public IApiService getApiService() {

        if (retrofit != null && apiService != null) {
            return apiService;
        }

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();

                        Request request = original.newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Accept", "application/json")
                                .addHeader("X-Requested-With", "XMLHttpRequest")
                                .method(original.method(), original.body())
                                .build();

                        return chain.proceed(request);
                    }
                });


        OkHttpClient okClient = httpClient
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(IApiService.class);
        return apiService;

    }

}