package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;
import java.util.List;

public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherForecast getWeather(String cityName) {
        List<SingleDayWeather> currentWeather = weatherClient.currentWeather(cityName);
        return new WeatherForecast(cityName, currentWeather);
    }
    public StatusCode getStatusConnect(String cityName) {
        return weatherClient.getCode(cityName);
    }
}
