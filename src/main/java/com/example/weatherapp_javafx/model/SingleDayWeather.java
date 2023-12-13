package com.example.weatherapp_javafx.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public class SingleDayWeather {
    private final String city;
    private final float temperature;
    private final LocalDateTime date;

    public SingleDayWeather(String city, float temperature, String date) {
        this.city = city;
        this.temperature = temperature;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        this.date = LocalDateTime.parse(date, formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleDayWeather that = (SingleDayWeather) o;
        return Float.compare(that.temperature, temperature) == 0 && Objects.equals(city, that.city) && Objects.equals(date, that.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, date);
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", SingleDayWeather.class.getSimpleName() + "[", "]")
                .add("Miasto= " + city)
                .add("Temperatura = " + temperature + "C")
                .add("Data = " + date)
                .toString();
    }
}
