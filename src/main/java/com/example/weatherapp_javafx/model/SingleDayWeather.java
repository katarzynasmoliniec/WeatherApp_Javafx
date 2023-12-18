package com.example.weatherapp_javafx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public class SingleDayWeather {
    private final float temperature;
    private final LocalDate date;

    public SingleDayWeather(float temperature, String date) {
        this.temperature = temperature;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        this.date = LocalDate.parse(date, formatter);
    }
    public float getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleDayWeather that = (SingleDayWeather) o;
        return Float.compare(that.temperature, temperature) == 0 && Objects.equals(date, that.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash( temperature, date);
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
