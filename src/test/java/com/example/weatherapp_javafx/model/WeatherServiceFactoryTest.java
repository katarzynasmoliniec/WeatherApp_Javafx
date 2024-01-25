package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.OpenWeatherMapClient;
import com.example.weatherapp_javafx.model.client.WeatherClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WeatherServiceFactoryTest {

    @ExtendWith(MockitoExtension.class)
    @MockitoSettings(strictness = Strictness.LENIENT)
    @Test
    void weatherClientShouldBeNotNull() {
        try (var mockedStatic = Mockito.mockStatic(WeatherServiceFactory.class)) {
            var expectedExpression = new WeatherService(mock(WeatherClient.class));
            mockedStatic
                    .when(WeatherServiceFactory::createWeatherService)
                    .thenReturn(expectedExpression);
            assertEquals(expectedExpression, WeatherServiceFactory.createWeatherService());

            var expectedWeatherClient = new WeatherService(mock(WeatherClient.class));
            mockedStatic
                    .when(WeatherServiceFactory::createWeatherService)
                    .thenReturn(expectedWeatherClient);
            assertEquals(expectedWeatherClient, WeatherServiceFactory.createWeatherService());
        }
    }

    @ExtendWith(MockitoExtension.class)
    @MockitoSettings(strictness = Strictness.LENIENT)
    @Test
    void weatherClientShouldBeOpenWeatherMapClient() {
        try (var mockedStatic = Mockito.mockStatic(WeatherServiceFactory.class)) {
            var expectedExpression = new WeatherService(mock(OpenWeatherMapClient.class));
            mockedStatic
                    .when(WeatherServiceFactory::createWeatherService)
                    .thenReturn(expectedExpression);
            assertEquals(expectedExpression, WeatherServiceFactory.createWeatherService());

            var expectedWeatherClient = new WeatherService(mock(OpenWeatherMapClient.class));
            mockedStatic
                    .when(WeatherServiceFactory::createWeatherService)
                    .thenReturn(expectedWeatherClient);
            assertEquals(expectedWeatherClient, WeatherServiceFactory.createWeatherService());
        }
    }

}