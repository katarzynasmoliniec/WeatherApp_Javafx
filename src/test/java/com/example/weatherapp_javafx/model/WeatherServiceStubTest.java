package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;
import com.example.weatherapp_javafx.model.client.WeatherClientStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class WeatherServiceStubTest {
    @Test
    void getWeather() {
        //given
        WeatherClient weatherClientStub = new WeatherClientStub();
        WeatherService weatherService = new WeatherService(weatherClientStub);
        //when
        List<SingleDayWeather> weatherList = weatherService.getWeather("Kraków");
        //then
        assertThat(weatherList, hasSize(3));
    }

}