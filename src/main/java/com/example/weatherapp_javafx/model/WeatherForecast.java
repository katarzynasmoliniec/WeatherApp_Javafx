package com.example.weatherapp_javafx.model;

import java.util.Collection;
import java.util.StringJoiner;

public class WeatherForecast {
    private final String cityName;
    private final Collection<SingleDayWeather> weathers;

    public WeatherForecast(String cityName, Collection<SingleDayWeather> weathers) {
        this.cityName = cityName;
        this.weathers = weathers;
    }
    public String getCityName() { return cityName; }

    //public Collection<SingleDayWeather> getWeathers() { return weathers; }

    @Override
    public String toString() {
        return new StringJoiner(" ", "", "")
                .add( weathers.toString().replace("[", "").replace("]", "").replace(",", ""))
                .toString();
    }
}
