package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.Weather;

import java.util.Collection;

public class ExampleWeatherClient implements WeatherClient {

    @Override
    public Weather getWeather(String countryName, String cityName) {
        return new Weather(countryName, cityName);
                //result

    }

    @Override
    public SingleDayWeather currentWeather(String countryName, String cityName) {
        return null;
    }

    @Override
    public Collection<SingleDayWeather> forecast(String countryName, String cityName) {
        return null;
    }
}
