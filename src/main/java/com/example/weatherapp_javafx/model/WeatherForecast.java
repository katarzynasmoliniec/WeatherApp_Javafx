package com.example.weatherapp_javafx.model;

import java.util.List;
import java.util.StringJoiner;

public class WeatherForecast {
    private final String cityName;
    private final List<SingleDayWeather> weathers;

    public WeatherForecast(String cityName, List<SingleDayWeather> weathers) {
        this.cityName = cityName;
        this.weathers = weathers;
    }
    public String getCityName() { return cityName; }

    public List<SingleDayWeather> getWeathers() {
        return weathers;
    }


    @Override
    public String toString() {
        return new StringJoiner(" ", "", "")
                .add( weathers.toString().replace("[", "").replace("]", "").replace(",", ""))
                .toString();
    }
}
