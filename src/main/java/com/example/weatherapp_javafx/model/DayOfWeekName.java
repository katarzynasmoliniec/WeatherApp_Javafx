package com.example.weatherapp_javafx.model;

public enum DayOfWeekName {
    MONDAY ("Pon"),
    TUESDAY ("Wt"),
    WEDNESDAY ("Śr"),
    THURSDAY ("Czw"),
    FRIDAY ("Pią"),
    SATURDAY ("Sob"),
    SUNDAY ("Niedz");

    private String dayName;
    DayOfWeekName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return dayName + "";
    }
}
