package com.example.weatherapp_javafx.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Weather {
    private final String cityName;
    private final String countryName;
    //private final Collection<SingleDayWeather> weathers;

    public Weather(String countryName, String cityName){
                   //Collection<SingleDayWeather> weathers

        this.countryName = countryName;
        this.cityName = cityName;
        //this.weathers = weathers;
    }

    public String getCityName() { return cityName; }
    public String getCountryName() { return countryName; }
    //public Collection<SingleDayWeather> getWeathers() { return weathers; }

//    public SingleDayWeather forToDay() {
//        return weathers.stream()
//                .filter(weather -> LocalDate.now().equals(weather.getDate()))
//                .findFirst()
//                .orElseThrow() -> new RuntimeException("Weather for today not found.");
//    }
}
