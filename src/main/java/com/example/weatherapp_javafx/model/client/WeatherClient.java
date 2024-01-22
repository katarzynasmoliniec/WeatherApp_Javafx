package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.StatusCode;

import java.util.List;

public interface WeatherClient {
    List<SingleDayWeather> currentWeather(String cityName);
    StatusCode getCode(String cityName);
}
