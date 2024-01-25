package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.*;

class WeatherServiceTest {
    @Test
    void getWeather() {
        //given
        List<SingleDayWeather> forecasts = prepareWeatherForecastData();
        WeatherClient weatherClient = mock(WeatherClient.class);
        WeatherService weatherService = new WeatherService(weatherClient);
        given(weatherClient.currentWeather("Kraków")).willReturn(forecasts);
        //when
        List<SingleDayWeather> forecastList = weatherService.getWeather("Kraków");
        //then
        assertThat(forecastList, hasSize(3));
        assertThat(forecastList.get(0), equalTo(forecasts.get(0)));
    }
    @Test
    void getStatusCode() {
        //given
        WeatherClient weatherClient = mock(WeatherClient.class);
        WeatherService weatherService = new WeatherService(weatherClient);
        given(weatherClient.getCode("Kraków")).willReturn(StatusCode.SUCCESS);
        //when
        StatusCode statusCode = weatherService.getStatusConnect("Kraków");
        //then
        assertThat(statusCode, is(StatusCode.SUCCESS));
    }
    @Test
    void getStatusCodeFailed_4() {
        //given
        WeatherClient weatherClient = mock(WeatherClient.class);
        WeatherService weatherService = new WeatherService(weatherClient);
        given(weatherClient.getCode("Kraków")).willReturn(StatusCode.FAILED_4);
        //when
        StatusCode statusCode = weatherService.getStatusConnect("Kraków");
        //then
        assertThat(statusCode, is(StatusCode.FAILED_4));
    }
    @Test
    void getStatusCodeFailed_5() {
        //given
        WeatherClient weatherClient = mock(WeatherClient.class);
        WeatherService weatherService = new WeatherService(weatherClient);
        given(weatherClient.getCode("Kraków")).willReturn(StatusCode.FAILED_5);
        //when
        StatusCode statusCode = weatherService.getStatusConnect("Kraków");
        //then
        assertThat(statusCode, is(StatusCode.FAILED_5));
    }
    @Test
    void getStatusCodeFailedUnexpectedError() {
        //given
        WeatherClient weatherClient = mock(WeatherClient.class);
        WeatherService weatherService = new WeatherService(weatherClient);
        given(weatherClient.getCode("Kraków")).willReturn(StatusCode.FAILED_UNEXPECTED_ERROR);
        //when
        StatusCode statusCode = weatherService.getStatusConnect("Kraków");
        //then
        assertThat(statusCode, is(StatusCode.FAILED_UNEXPECTED_ERROR));
    }

    private List<SingleDayWeather> prepareWeatherForecastData() {
        SingleDayWeather day1 = new SingleDayWeather(10, "2023-01-23 10:51:00", "10n", "PL", "Kraków");
        SingleDayWeather day2 = new SingleDayWeather(10, "2023-01-24 10:51:00", "10n", "PL", "Kraków");
        SingleDayWeather day3 = new SingleDayWeather(10, "2023-01-25 10:51:00", "10n", "PL", "Kraków");
        return Arrays.asList(day1, day2, day3);
    }
}