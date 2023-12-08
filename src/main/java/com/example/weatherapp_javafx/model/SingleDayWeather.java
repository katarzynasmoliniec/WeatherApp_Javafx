package com.example.weatherapp_javafx.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class SingleDayWeather {
    private final double temInCelsius;
    private final LocalDate date;

    public SingleDayWeather(double temInCelsius, LocalDate date) {
        this.temInCelsius = temInCelsius;
        this.date = date;
    }

    public double getTemInCelsius() { return temInCelsius; }

    public LocalDate getDate() { return date; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleDayWeather that = (SingleDayWeather) o;
        return Double.compare(that.temInCelsius, temInCelsius) == 0 && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temInCelsius, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SingleDayWeather.class.getSimpleName() + "[", "]")
                .add("tempInCelsius= " + temInCelsius)
                .add("date= " + date)
                .toString();
    }
}
