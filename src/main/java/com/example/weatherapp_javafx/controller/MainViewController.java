package com.example.weatherapp_javafx.controller;

import com.example.weatherapp_javafx.model.*;
import com.example.weatherapp_javafx.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private Label currentTextLabel1;
    @FXML
    private Label currentTextLabel11;

    @FXML
    private Label currentTextLabel2;

    @FXML
    private Label currentTextLabel21;

    @FXML
    private Label currentTextLabel3;

    @FXML
    private Label currentTextLabel31;

    @FXML
    private Label currentTextLabel4;

    @FXML
    private Label currentTextLabel41;

    @FXML
    private Label currentTextLabel5;

    @FXML
    private Label currentTextLabel51;


    @FXML
    private TextField searchCityField;
    @FXML
    private Label errorSearchLabel;
    @FXML
    private Label searchCityName;
    @FXML
    private Label searchTextLabel1;

    @FXML
    private Label searchTextLabel11;

    @FXML
    private Label searchTextLabel2;

    @FXML
    private Label searchTextLabel21;

    @FXML
    private Label searchTextLabel3;

    @FXML
    private Label searchTextLabel31;

    @FXML
    private Label searchTextLabel4;

    @FXML
    private Label searchTextLabel41;

    @FXML
    private Label searchTextLabel5;

    @FXML
    private Label searchTextLabel51;

    protected WeatherService weatherService;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public MainViewController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    @FXML
    void currentLocationBtn() {
        if (currentFieldAreValid()) {

            StatusCode statusCode = weatherService.getStatusConnect(currentCityField.getText());

            switch (statusCode) {
                case SUCCESS:
                    WeatherForecast currentWeather = weatherService.getWeather(currentCityField.getText());
                    displayWeatherCurrent(currentWeather);
                    break;
                case FAILED_4:
                    errorCurrentLabel.setText("Proszę podać poprawne miasto");
                    currentCityName.setVisible(false);
                    currentTextLabel1.setVisible(false);
                    currentTextLabel11.setVisible(false);
                    currentTextLabel2.setVisible(false);
                    currentTextLabel21.setVisible(false);
                    currentTextLabel3.setVisible(false);
                    currentTextLabel31.setVisible(false);
                    currentTextLabel4.setVisible(false);
                    currentTextLabel41.setVisible(false);
                    currentTextLabel5.setVisible(false);
                    currentTextLabel51.setVisible(false);
                    break;
                case FAILED_5:
                    errorCurrentLabel.setText("Niestety serwer jest teraz niedostępny");
                    currentCityName.setVisible(false);
                    currentTextLabel1.setVisible(false);
                    currentTextLabel11.setVisible(false);
                    currentTextLabel2.setVisible(false);
                    currentTextLabel21.setVisible(false);
                    currentTextLabel3.setVisible(false);
                    currentTextLabel31.setVisible(false);
                    currentTextLabel4.setVisible(false);
                    currentTextLabel41.setVisible(false);
                    currentTextLabel5.setVisible(false);
                    currentTextLabel51.setVisible(false);
                    break;
                case FAILED_UNEXPECTED_ERROR:
                    errorCurrentLabel.setText("Nieoczekiwany błąd");
                    currentCityName.setVisible(false);
                    currentTextLabel1.setVisible(false);
                    currentTextLabel11.setVisible(false);
                    currentTextLabel2.setVisible(false);
                    currentTextLabel21.setVisible(false);
                    currentTextLabel3.setVisible(false);
                    currentTextLabel31.setVisible(false);
                    currentTextLabel4.setVisible(false);
                    currentTextLabel41.setVisible(false);
                    currentTextLabel5.setVisible(false);
                    currentTextLabel51.setVisible(false);
                    break;
            }
        }
    }

    private void displayWeatherCurrent(WeatherForecast currentWeather) {
        currentCityName.setVisible(true);
        currentCityName.setText(currentWeather.getWeathers().get(0).getCityName().toUpperCase()+ ", " + currentWeather.getWeathers().get(0).getCountry().toUpperCase());

        currentTextLabel1.setVisible(true);
        currentTextLabel11.setVisible(true);
        currentTextLabel1.setText(currentWeather.getWeathers().get(0).toString());
        String nameImage1 = currentWeather.getWeathers().get(0).getIcon();
        ImageView image1 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage1 +"@2x.png"));
        image1.setFitHeight(50);
        image1.setFitWidth(60);
        currentTextLabel11.setGraphic(image1);

        currentTextLabel2.setVisible(true);
        currentTextLabel21.setVisible(true);
        currentTextLabel2.setText(currentWeather.getWeathers().get(1).toString());
        String nameImage2 = currentWeather.getWeathers().get(1).getIcon();
        ImageView image2 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage2 +"@2x.png"));
        image2.setFitHeight(50);
        image2.setFitWidth(60);
        currentTextLabel21.setGraphic(image2);

        currentTextLabel3.setVisible(true);
        currentTextLabel31.setVisible(true);
        currentTextLabel3.setText(currentWeather.getWeathers().get(2).toString());
        String nameImage3 = currentWeather.getWeathers().get(2).getIcon();
        ImageView image3 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage3 +"@2x.png"));
        image3.setFitHeight(50);
        image3.setFitWidth(60);
        currentTextLabel31.setGraphic(image3);

        currentTextLabel4.setVisible(true);
        currentTextLabel41.setVisible(true);
        currentTextLabel4.setText(currentWeather.getWeathers().get(3).toString());
        String nameImage4 = currentWeather.getWeathers().get(3).getIcon();
        ImageView image4 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage4 +"@2x.png"));
        image4.setFitHeight(50);
        image4.setFitWidth(60);
        currentTextLabel41.setGraphic(image4);

        currentTextLabel5.setVisible(true);
        currentTextLabel51.setVisible(true);
        currentTextLabel5.setText(currentWeather.getWeathers().get(4).toString());
        String nameImage5 = currentWeather.getWeathers().get(4).getIcon();
        ImageView image5 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage5 +"@2x.png"));
        image5.setFitHeight(50);
        image5.setFitWidth(60);
        currentTextLabel51.setGraphic(image5);
    }

    @FXML
    void searchLocationBtn() {
        if (searchFieldAreValid()) {
            StatusCode statusCode = weatherService.getStatusConnect(searchCityField.getText());

            switch (statusCode) {
                case SUCCESS:
                    WeatherForecast searchWeather = weatherService.getWeather(searchCityField.getText());
                    displayWeatherSearch(searchWeather);
                    break;
                case FAILED_4:
                    errorSearchLabel.setText("Proszę podać poprawne miasto");
                    searchCityName.setVisible(false);
                    searchTextLabel1.setVisible(false);
                    searchTextLabel11.setVisible(false);
                    searchTextLabel2.setVisible(false);
                    searchTextLabel21.setVisible(false);
                    searchTextLabel3.setVisible(false);
                    searchTextLabel31.setVisible(false);
                    searchTextLabel4.setVisible(false);
                    searchTextLabel41.setVisible(false);
                    searchTextLabel5.setVisible(false);
                    searchTextLabel51.setVisible(false);
                    break;
                case FAILED_5:
                    errorSearchLabel.setText("Niestety serwer jest teraz niedostępny");
                    searchCityName.setVisible(false);
                    searchTextLabel1.setVisible(false);
                    searchTextLabel11.setVisible(false);
                    searchTextLabel2.setVisible(false);
                    searchTextLabel21.setVisible(false);
                    searchTextLabel3.setVisible(false);
                    searchTextLabel31.setVisible(false);
                    searchTextLabel4.setVisible(false);
                    searchTextLabel41.setVisible(false);
                    searchTextLabel5.setVisible(false);
                    searchTextLabel51.setVisible(false);
                    break;
                case FAILED_UNEXPECTED_ERROR:
                    errorSearchLabel.setText("Nieoczekiwany błąd");
                    searchCityName.setVisible(false);
                    searchTextLabel1.setVisible(false);
                    searchTextLabel11.setVisible(false);
                    searchTextLabel2.setVisible(false);
                    searchTextLabel21.setVisible(false);
                    searchTextLabel3.setVisible(false);
                    searchTextLabel31.setVisible(false);
                    searchTextLabel4.setVisible(false);
                    searchTextLabel41.setVisible(false);
                    searchTextLabel5.setVisible(false);
                    searchTextLabel51.setVisible(false);
                    break;
            }
        }
    }

    private void displayWeatherSearch(WeatherForecast searchWeather) {
        searchCityName.setVisible(true);
        searchCityName.setText(searchWeather.getWeathers().get(0).getCityName().toUpperCase() + ", " + searchWeather.getWeathers().get(0).getCountry().toUpperCase());

        searchTextLabel1.setVisible(true);
        searchTextLabel11.setVisible(true);
        searchTextLabel1.setText(searchWeather.getWeathers().get(0).toString());
        String nameImage1 = searchWeather.getWeathers().get(0).getIcon();
        ImageView image1 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage1 +"@2x.png"));
        image1.setFitHeight(50);
        image1.setFitWidth(60);
        searchTextLabel11.setGraphic(image1);

        searchTextLabel2.setVisible(true);
        searchTextLabel21.setVisible(true);
        searchTextLabel2.setText(searchWeather.getWeathers().get(1).toString());
        String nameImage2 = searchWeather.getWeathers().get(1).getIcon();
        ImageView image2 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage2 +"@2x.png"));
        image2.setFitHeight(50);
        image2.setFitWidth(60);
        searchTextLabel21.setGraphic(image2);

        searchTextLabel3.setVisible(true);
        searchTextLabel31.setVisible(true);
        searchTextLabel3.setText(searchWeather.getWeathers().get(2).toString());
        String nameImage3 = searchWeather.getWeathers().get(2).getIcon();
        ImageView image3 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage3 +"@2x.png"));
        image3.setFitHeight(50);
        image3.setFitWidth(60);
        searchTextLabel31.setGraphic(image3);

        searchTextLabel4.setVisible(true);
        searchTextLabel41.setVisible(true);
        searchTextLabel4.setText(searchWeather.getWeathers().get(3).toString());
        String nameImage4 = searchWeather.getWeathers().get(3).getIcon();
        ImageView image4 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage4 +"@2x.png"));
        image4.setFitHeight(50);
        image4.setFitWidth(60);
        searchTextLabel41.setGraphic(image4);

        searchTextLabel5.setVisible(true);
        searchTextLabel51.setVisible(true);
        searchTextLabel5.setText(searchWeather.getWeathers().get(4).toString());
        String nameImage5 = searchWeather.getWeathers().get(4).getIcon();
        ImageView image5 = new ImageView(new Image("https://openweathermap.org/img/wn/"+ nameImage5 +"@2x.png"));
        image5.setFitHeight(50);
        image5.setFitWidth(60);
        searchTextLabel51.setGraphic(image5);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
        currentCityName.setVisible(false);
        searchCityName.setVisible(false);
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