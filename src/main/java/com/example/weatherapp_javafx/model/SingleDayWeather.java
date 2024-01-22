package com.example.weatherapp_javafx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class SingleDayWeather {
    private final float temperature;
    private final LocalDate date;
    private final String icon;
    private final String cityName;
    private final String country;

    public SingleDayWeather(float temperature, String date, String icon, String country, String cityName) {
        this.temperature = temperature;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        this.date = LocalDate.parse(date, formatter);
        this.icon = icon;
        this.country = country;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public String getIcon() {
        return icon;
    }

    public float getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new StringJoiner(" ", "", "")
                .add(DayOfWeekName.valueOf(date.getDayOfWeek().toString()) + "")
                .add(temperature + " °C")
                .add("\n")
                .toString();
    }
}
