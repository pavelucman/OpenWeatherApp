package com.example.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("temp")
    String temp;

    @SerializedName("feels_like")
    String feelsLike;

    @SerializedName("humidity")
    String humidity;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
