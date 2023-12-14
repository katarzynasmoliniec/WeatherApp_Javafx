package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.ExampleWeatherClient;
import com.example.weatherapp_javafx.model.client.WeatherClient;

public class WeatherServiceFactory {
    public static WeatherService createWeatherService() { return new WeatherService(createWeatherClient()); }
    private static WeatherClient createWeatherClient() {
        return new ExampleWeatherClient();
    }
}
