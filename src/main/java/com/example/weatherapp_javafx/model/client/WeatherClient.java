package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.Weather;

import java.util.Collection;

public interface WeatherClient {
    Weather getWeather(String countryName, String cityName);

    SingleDayWeather currentWeather(String countryName, String cityName);

    Collection<SingleDayWeather> forecast(String countryName, String cityName);
}
