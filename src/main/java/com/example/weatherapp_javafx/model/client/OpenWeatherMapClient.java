package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.StatusCode;
import com.example.weatherapp_javafx.model.client.dto.OpenWeatherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class OpenWeatherMapClient implements WeatherClient {

    private final RestTemplate restTemplate;
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "5f46e9291e83dbac9d73644d47b1c20a";

    public OpenWeatherMapClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public StatusCode getCode(String cityName) {
        try {
            callGetMethod("forecast?q={cityName}&appid={API_KEY}&lang=pl&units=metric",
                    OpenWeatherDto.class,
                    cityName,
                    API_KEY);
            return StatusCode.SUCCESS;
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return StatusCode.FAILED_4;
        }
    }

    @Override
    public List<SingleDayWeather> currentWeather(String cityName) {
        ResponseEntity<OpenWeatherDto> openWeatherDto = callGetMethod("forecast?q={cityName}&appid={API_KEY}&lang=pl&units=metric",
                OpenWeatherDto.class,
                cityName,
                API_KEY);
        int cnt = openWeatherDto.getBody().getCnt();
        List<SingleDayWeather> result = new ArrayList<>();
        for (int i = 0; i < cnt; i = i + 8) {
            result.add(new SingleDayWeather(
                    openWeatherDto.getBody().getList().get(i).getMain().getTemp(),
                    openWeatherDto.getBody().getList().get(i).getDt_txt(),
                    openWeatherDto.getBody().getList().get(i).getWeather().get(0).getIcon(),
                    openWeatherDto.getBody().getCity().getCountry(),
                    openWeatherDto.getBody().getCity().getName()
            ));
        }
        return result;
    }

    private <T> ResponseEntity callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForEntity(WEATHER_URL + url,
                responseType,
                objects);
    }
}
