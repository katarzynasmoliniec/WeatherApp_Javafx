package com.example.weatherapp_javafx.model.client.dto;

import java.util.List;

public class OpenWeatherDto {

    private List<OpenWeatherListDto> list;
    private int cnt;

    public int getCnt() { return cnt; }

    public List<OpenWeatherListDto> getList() {
        return list;
    }
}
