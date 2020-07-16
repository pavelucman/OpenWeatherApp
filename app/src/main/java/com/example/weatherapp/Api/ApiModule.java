package com.example.weatherapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    private static String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    public static Retrofit getClient() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
}
