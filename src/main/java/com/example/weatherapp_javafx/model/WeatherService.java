package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherForecast getWeather(String cityName) {
        Collection<SingleDayWeather> currentWeather = weatherClient.currentWeather(cityName);
        List<SingleDayWeather> result = new ArrayList<>(currentWeather);
        return new WeatherForecast(cityName, result);
    }
}
