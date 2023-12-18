package com.example.weatherapp_javafx.model;

public enum DayOfWeekName {
    MONDAY ("Poniedziałek"),
    TUESDAY ("Wtorek"),
    WEDNESDAY ("Środa"),
    THURSDAY ("Czwartek"),
    FRIDAY ("Piątek"),
    SATURDAY ("Sobota"),
    SUNDAY ("Niedziela");

    private String dayName;
    DayOfWeekName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return dayName + "";
    }
}
