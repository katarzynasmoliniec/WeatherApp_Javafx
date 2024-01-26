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

@ExtendWith(MockitoExtension.class)
class WeatherServiceFactoryTest {
    @MockitoSettings(strictness = Strictness.LENIENT)

    @Test
    void weatherClientShouldBeNotNull() {
        //given
        WeatherService weatherService = WeatherServiceFactory.createWeatherService();
        //when
        //then
        assertNotNull(weatherService);
    }
    @Test
    void weatherServiceFromStaticMethod() {
        try (var mockedStatic = Mockito.mockStatic(WeatherServiceFactory.class)) {
            var expectedExpression = new WeatherService(mock(WeatherClient.class));
            mockedStatic
                    .when(WeatherServiceFactory::createWeatherService)
                    .thenReturn(expectedExpression);
            assertEquals(expectedExpression, WeatherServiceFactory.createWeatherService());
        }
    }
    @Test
    void weatherServiceFromStaticMethodShouldBeOpenWeatherMapClient() {
        try (var mockedStatic = Mockito.mockStatic(WeatherServiceFactory.class)) {
            var expectedExpression = mock(OpenWeatherMapClient.class);
            mockedStatic
                    .when(WeatherServiceFactory::createWeatherClient)
                    .thenReturn(expectedExpression);
            assertEquals(expectedExpression, WeatherServiceFactory.createWeatherClient());
        }
    }

}