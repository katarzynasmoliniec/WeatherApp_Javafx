package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.StatusCode;

import java.util.Arrays;
import java.util.List;

public class WeatherClientStub implements WeatherClient {
    @Override
    public List<SingleDayWeather> currentWeather(String cityName) {
        SingleDayWeather day1 = new SingleDayWeather(10, "2023-01-23 10:51:00", "10n", "PL", "Kraków");
        SingleDayWeather day2 = new SingleDayWeather(10, "2023-01-24 10:51:00", "10n", "PL", "Kraków");
        SingleDayWeather day3 = new SingleDayWeather(10, "2023-01-25 10:51:00", "10n", "PL", "Kraków");
        return Arrays.asList(day1, day2, day3);
    }
    @Override
    public StatusCode getCode(String cityName) {
        return null;
    }
}