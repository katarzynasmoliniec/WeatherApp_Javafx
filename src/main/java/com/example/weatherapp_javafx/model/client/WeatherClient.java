package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import java.util.Collection;

public interface WeatherClient {
    Collection<SingleDayWeather> currentWeather(String cityName);
}
