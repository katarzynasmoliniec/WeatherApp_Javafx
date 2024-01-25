package com.example.weatherapp_javafx.model.client;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.StatusCode;
import com.example.weatherapp_javafx.model.WeatherService;
import com.example.weatherapp_javafx.model.client.dto.OpenWeatherDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.springframework.util.Assert.*;

@ExtendWith(MockitoExtension.class)
class OpenWeatherMapClientTest {
    @InjectMocks
    private WeatherService weatherService;
    @Spy
    private OpenWeatherMapClient spyMapClient = new OpenWeatherMapClient(new RestTemplate());

    private final String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?q=kraków&appid=5f46e9291e83dbac9d73644d47b1c20a&lang=pl&units=metric";

    @Test
    public void test_GET() throws URISyntaxException {
        //given
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<OpenWeatherDto> response = restTemplate.getForEntity(baseUrl, OpenWeatherDto.class);
        ResponseEntity<OpenWeatherDto> responseExchange = restTemplate.exchange(baseUrl, HttpMethod.GET, null, OpenWeatherDto.class);

        URI uri = new URI(baseUrl);
        ResponseEntity<OpenWeatherDto> responseURI = restTemplate.getForEntity(uri, OpenWeatherDto.class);
        ResponseEntity<OpenWeatherDto> responseExchangeURI = restTemplate.exchange(uri, HttpMethod.GET, null, OpenWeatherDto.class);
        //when
        //then
        isTrue(response.getStatusCode() == HttpStatus.OK, "OK");
        isTrue(responseExchange.getStatusCode() == HttpStatus.OK, "OK");

        isTrue(responseURI.getStatusCode() == HttpStatus.OK, "OK");
        isTrue(responseExchangeURI.getStatusCode() == HttpStatus.OK, "OK");
    }

    @Test
    void callGetMethodShouldHttpStatusIsOk() {
        //given
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OpenWeatherDto> response = restTemplate.getForEntity(baseUrl, OpenWeatherDto.class);
        //when
        ResponseEntity responseWithMethod = callGetMethod(baseUrl, OpenWeatherDto.class);
        //then
        isTrue(response.getStatusCode() == HttpStatus.OK, "OK");
        isTrue(responseWithMethod.getStatusCode() == HttpStatus.OK, "OK");
    }

    @Test
    void shouldReturnStatusCodeSuccess() {
        //given
        StatusCode status = StatusCode.SUCCESS;
        given(spyMapClient.getCode("Kraków")).willReturn(StatusCode.SUCCESS);
        //when
        StatusCode result = weatherService.getStatusConnect("Kraków");
        //then
        assertThat(result, is(status));
    }

    @Test
    void shouldReturnStatusCodeFailed_4() {
        //given
        StatusCode status = StatusCode.FAILED_4;
        given(spyMapClient.getCode("Kraków")).willReturn(StatusCode.FAILED_4);
        //when
        StatusCode result = weatherService.getStatusConnect("Kraków");
        //then
        assertThat(result, is(status));
    }
    @Test
    void shouldThrowFailedToGetCodeWhenCodeNotFound() {
        //given
        given(spyMapClient.getCode("Krak")).willThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
        //when
        //then
        assertThrows(HttpClientErrorException.class, () -> spyMapClient.getCode("Krak"));
    }

    @Test
    void currentWeatherShouldBeReturnList() {
        List<SingleDayWeather> list = prepareWeatherForecastData();
        given(spyMapClient.currentWeather("Kraków")).willReturn(list);
        //when
        List<SingleDayWeather> resul = weatherService.getWeather("Kraków");
        //then
        assertThat(resul, hasSize(3));
        assertThat(resul.get(0), equalTo(list.get(0)));
    }

    private List<SingleDayWeather> prepareWeatherForecastData() {
        SingleDayWeather day1 = new SingleDayWeather(10, "2023-01-23 10:51:00", "10n", "PL", "Kraków");
        SingleDayWeather day2 = new SingleDayWeather(10, "2023-01-24 10:51:00", "10n", "PL", "Kraków");
        SingleDayWeather day3 = new SingleDayWeather(10, "2023-01-25 10:51:00", "10n", "PL", "Kraków");
        return Arrays.asList(day1, day2, day3);
    }

    private <T> ResponseEntity callGetMethod(String url, Class<T> responseType, Object... objects) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url,
                responseType,
                objects);
    }
}