package com.example.weatherapp_javafx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

class SingleDayWeatherTest {
    @Test
    void newSingleDayWeatherShouldBeFormattedStringDateToLocalDate () {
        //given
        SingleDayWeather singleDayWeather = new SingleDayWeather(0, "2024-01-23 10:13:00", "20d", "PL", "Kraków");
        //when
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        LocalDate date = LocalDate.parse("2024-01-23 10:13:00", formatter);
        //then
        assertThat(singleDayWeather.getDate(), is(date));
    }
    @Test
    void newSingleDayWeatherShouldBeNotNull() {
        //given
        SingleDayWeather singleDayWeather = new SingleDayWeather(0, "2024-01-23 10:13:00", "20d", "PL", "Kraków");
        //when
        //then
        assertNotNull(singleDayWeather);
        assertThat(singleDayWeather.getIcon(), containsString("20d"));
        assertThat(singleDayWeather.getCountry(), containsString("PL"));
        assertThat(singleDayWeather.getCityName(), containsString("Kraków"));
        assertThat(singleDayWeather.getTemperature(), is(0.0F));
    }

    @Test
    void singleDayWeatherToString() {
        //given
        SingleDayWeather singleDayWeather = new SingleDayWeather(0, "2024-01-23 10:13:00", "20d", "PL", "Kraków");
        //when
        //then
        assertThat(singleDayWeather.toString(), equalTo("Wt 0.0 °C \n"));
    }

}