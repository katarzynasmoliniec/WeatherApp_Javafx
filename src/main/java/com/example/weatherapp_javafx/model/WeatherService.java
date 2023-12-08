package com.example.weatherapp_javafx.model;

import com.example.weatherapp_javafx.model.client.WeatherClient;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeatherService {
    private final WeatherClient weatherClient;
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Weather getWeather(String countryName, String cityName) {
      //  SingleDayWeather currentWeather = weatherClient.currentWeather(countryName, cityName);
       // Collection<SingleDayWeather> forecast = weatherClient.forecast(countryName, cityName);
        //List<SingleDayWeather> result = new ArrayList<>(forecast);
        //result.add(currentWeather);
        doInBackground(countryName, cityName);
        return new Weather(countryName, cityName);
        //tutaj api
    }
    protected String doInBackground(String countryName, String cityName)  {
        String response = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=Kraków, Pl&appid=5f46e9291e83dbac9d73644d47b1c20a&lang=pl&units=metric",
                String.class);
        System.out.println(response);
        return response;
    }
}
