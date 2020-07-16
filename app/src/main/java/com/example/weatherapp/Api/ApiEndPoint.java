package com.example.weatherapp.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("weather?appid=d9db413b4aa011de300a258576be9988&units=metric")
    Call<Data> getWeatherData(@Query("q") String name);

}
