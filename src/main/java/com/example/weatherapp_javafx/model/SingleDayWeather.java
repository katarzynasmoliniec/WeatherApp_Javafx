package com.example.weatherapp_javafx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class SingleDayWeather {
    private final float temperature;
    private final LocalDate date;

    public SingleDayWeather(float temperature, String date) {
        this.temperature = temperature;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        this.date = LocalDate.parse(date, formatter);
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
