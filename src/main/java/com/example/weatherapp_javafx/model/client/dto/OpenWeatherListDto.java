package com.example.weatherapp_javafx.model.client.dto;

import java.util.List;

public class OpenWeatherListDto {

    private OpenWeatherMain main;
    private String dt_txt;
    List<OpenWeatherListWeather> weather;

    public List<OpenWeatherListWeather> getWeather() {
        return weather;
    }

    public OpenWeatherMain getMain() {
        return main;
    }

    public String  getDt_txt() {
        return dt_txt;
    }
}
