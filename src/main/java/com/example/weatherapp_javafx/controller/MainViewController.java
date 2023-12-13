package com.example.weatherapp_javafx.controller;

import com.example.weatherapp_javafx.model.SingleDayWeather;
import com.example.weatherapp_javafx.model.WeatherService;
import com.example.weatherapp_javafx.model.WeatherServiceFactory;
import com.example.weatherapp_javafx.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private TextField currentCityField;
    @FXML
    private TextField searchCityField;
    @FXML
    private Label currenrTemparatureLabel;
    @FXML
    private Label searchTemparatureLabel;

    private WeatherService weatherService;

    protected ViewFactory viewFactory;
    private final String fxmlName;

    public MainViewController(ViewFactory viewFactory, String fmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fmlName;
    }

    @FXML
    void currentLocationBtn() {
        System.out.println("Current button");
        Collection <SingleDayWeather> singleDayWeather = weatherService.getWeather(currentCityField.getText());
        displayWeatherCurrent(singleDayWeather);
    }

    @FXML
    void searchLocationBtn() {
        System.out.println("Search button");
        Collection <SingleDayWeather> searchWeather = weatherService.getWeather(searchCityField.getText());
        displayWeatherSearch(searchWeather);

    }
    private void displayWeatherCurrent(Collection<SingleDayWeather> singleDayWeather) {
        currenrTemparatureLabel.setVisible(true);
        currenrTemparatureLabel.setText(singleDayWeather.toString());
    }
    private void displayWeatherSearch(Collection <SingleDayWeather> searchWeather) {
        searchTemparatureLabel.setVisible(true);
        searchTemparatureLabel.setText(searchWeather.toString());
    }
    public String getFxmlName() { return fxmlName;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
        currenrTemparatureLabel.setVisible(false);
        searchTemparatureLabel.setVisible(false);
    }
}