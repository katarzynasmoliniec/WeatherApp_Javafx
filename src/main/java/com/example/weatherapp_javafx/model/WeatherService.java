package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;
import java.util.Collection;

public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Collection <SingleDayWeather> getWeather(String cityName) {
        Collection<SingleDayWeather> currentWeather = weatherClient.currentWeather(cityName);
        System.out.println(currentWeather);
        return currentWeather;
    }
}
