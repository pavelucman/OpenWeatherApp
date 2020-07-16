package com.example.weatherapp.Api;

import com.example.weatherapp.model.WeatherData;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("main")
    private WeatherData mainData;

    public WeatherData getMainData() {
        return mainData;
    }

    public void setMainData(WeatherData mainData) {
        this.mainData = mainData;
    }
}
