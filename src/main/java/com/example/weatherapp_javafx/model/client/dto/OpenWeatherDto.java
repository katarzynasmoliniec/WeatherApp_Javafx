package com.example.weatherapp_javafx.model.client.dto;

import java.util.List;

public class OpenWeatherDto {
    private OpenWeatherCityDto city;
    private List<OpenWeatherListDto> list;
    private int cnt;

    public int getCnt() {
        return cnt;
    }
    public OpenWeatherCityDto getCity() {
        return city;
    }

    public List<OpenWeatherListDto> getList() {
        return list;
    }
}
