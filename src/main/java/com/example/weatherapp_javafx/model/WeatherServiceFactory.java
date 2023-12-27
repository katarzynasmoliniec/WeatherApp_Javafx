package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.OpenWeatherMapClient;
import com.example.weatherapp_javafx.model.client.WeatherClient;
import org.springframework.web.client.RestTemplate;

public class WeatherServiceFactory {
    public static WeatherService createWeatherService() { return new WeatherService(createWeatherClient()); }
    private static WeatherClient createWeatherClient() { return new OpenWeatherMapClient(new RestTemplate());
    }
}
