module com.example.weatherapp_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires spring.web;
    requires com.google.gson;

    opens com.example.weatherapp_javafx to javafx.fxml;
    opens com.example.weatherapp_javafx.model;
    opens com.example.weatherapp_javafx.model.client.dto;
    opens com.example.weatherapp_javafx.controller;
    opens com.example.weatherapp_javafx.views;
    exports com.example.weatherapp_javafx;
}