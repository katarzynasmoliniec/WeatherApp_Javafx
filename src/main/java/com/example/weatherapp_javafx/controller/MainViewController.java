package com.example.weatherapp_javafx.controller;

import com.example.weatherapp_javafx.model.Weather;
import com.example.weatherapp_javafx.model.WeatherService;
import com.example.weatherapp_javafx.model.WeatherServiceFactory;
import com.example.weatherapp_javafx.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private TextField currentCityField;
    @FXML
    private TextField currentCountryField;
    @FXML
    private TextField searchCityField;
    @FXML
    private TextField searchCountryField;
    @FXML
    private Label currenrTemparatureLabel;
    @FXML
    private Label searchTemparatureLabel;

    private WeatherService weatherService;

   // protected ViewFactory viewFactory;
    private final String fxmlName;

    public MainViewController(ViewFactory viewFactory, String fmlName) {
       // this.viewFactory = viewFactory;
        this.fxmlName = fmlName;
    }

    @FXML
    void currentLocationBtn() {
        System.out.println("Current button");
        Weather weather = weatherService.getWeather(currentCountryField.getText(), currentCityField.getText());
        displayWeather(weather);
        
//        Weather weather = new Weather(currentCityField.getText(), searchCityField.getText(),
//                currentCountryField.getText(), searchCountryField.getText());
    }

    private void displayWeather(Weather weather) {
        currenrTemparatureLabel.setVisible(true);
        searchTemparatureLabel.setVisible(true);
       // currenrTemparatureLabel.setText(weather.getTempInCelsius());
    }

    @FXML
    void searchLocationBtn() {
        System.out.println("Search button");
        Weather weather = weatherService.getWeather(searchCountryField.getText(), searchCityField.getText());

//        Weather weather = new Weather(currentCityField.getText(), searchCityField.getText(),
//                currentCountryField.getText(), searchCountryField.getText());
    }
    public String getFxmlName() { return fxmlName;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
        currenrTemparatureLabel.setVisible(false);
        searchTemparatureLabel.setVisible(false);
    }
}