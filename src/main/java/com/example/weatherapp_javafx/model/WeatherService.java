package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;

import java.util.ArrayList;
import java.util.List;

public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public List<SingleDayWeather> getWeather(String cityName) {
        return new ArrayList<>(weatherClient.currentWeather(cityName));
    }
    public StatusCode getStatusConnect(String cityName) {
        return weatherClient.getCode(cityName);
    }
}
