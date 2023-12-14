package com.example.weatherapp_javafx.controller;

import com.example.weatherapp_javafx.model.WeatherForecast;
import com.example.weatherapp_javafx.model.WeatherService;
import com.example.weatherapp_javafx.model.WeatherServiceFactory;
import com.example.weatherapp_javafx.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private Label weatherLabel;
    @FXML
    private TextField currentCityField;
    @FXML
    private Label errorCurrentLabel;
    @FXML
    private Label currentCityName;
    @FXML
    private TextArea currentTexArea;
    @FXML
    private TextField searchCityField;
    @FXML
    private Label errorSearchLabel;
    @FXML
    private Label searchCityName;
    @FXML
    private TextArea searchTextArea;

    protected WeatherService weatherService;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public MainViewController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    @FXML
    void currentLocationBtn() {
        System.out.println("Current button");
        if (currentFieldAreValid()) {
            WeatherForecast currentWeather = weatherService.getWeather(currentCityField.getText());
            displayWeatherCurrent(currentWeather);
        }
    }
    private void displayWeatherCurrent(WeatherForecast currentWeather) {
        currentCityName.setVisible(true);
        currentCityName.setText(currentWeather.getCityName().toUpperCase());
        currentTexArea.setVisible(true);
        currentTexArea.setText(currentWeather.toString());
    }

    @FXML
    void searchLocationBtn() {
        System.out.println("Search button");
        if (searchFieldAreValid()) {
            WeatherForecast searchWeather = weatherService.getWeather(searchCityField.getText());
            displayWeatherSearch(searchWeather);
        }
    }

    private void displayWeatherSearch(WeatherForecast searchWeather) {
        searchCityName.setVisible(true);
        searchCityName.setText(searchWeather.getCityName().toUpperCase());
        searchTextArea.setVisible(true);
        searchTextArea.setText(searchWeather.toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
        currentCityName.setVisible(false);
        currentTexArea.setVisible(false);
        searchCityName.setVisible(false);
        searchTextArea.setVisible(false);
    }
    private boolean currentFieldAreValid() {
        if (currentCityField.getText().isEmpty()) {
            errorCurrentLabel.setText("Proszę wpisać miasto");
            return false;
        } else {
            errorCurrentLabel.setText("");
            return true;
        }
    }

    private boolean searchFieldAreValid() {
        if (searchCityField.getText().isEmpty()) {
            errorSearchLabel.setText("Proszę wpisać miasto podróży");
            return false;
        } else {
            errorSearchLabel.setText("");
            return true;
        }
    }

    public String getFxmlName() {
        return fxmlName;
    }
}