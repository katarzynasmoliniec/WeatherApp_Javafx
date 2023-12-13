package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.client.dto.OpenWeatherDto;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ExampleWeatherClient implements WeatherClient {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "5f46e9291e83dbac9d73644d47b1c20a";

    @Override
    public Collection<SingleDayWeather> currentWeather(String cityName) {
        OpenWeatherDto openWeatherDto = callGetMethod("forecast?q={cityName}&appid={API_KEY}&lang=pl&units=metric",
                OpenWeatherDto.class,
                cityName,
                API_KEY);
        int cnt = openWeatherDto.getCnt();
        List<SingleDayWeather> result = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            result.add(new SingleDayWeather(
                    openWeatherDto.getCity().getName(),
                    openWeatherDto.getList().get(i).getMain().getTemp(),
                    openWeatherDto.getList().get(i).getDt_txt())
            );
        }
        return result;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType,
                objects);
    }
}
