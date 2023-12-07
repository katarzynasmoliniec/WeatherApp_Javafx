package com.example.weatherapp_javafx.controller;

import com.example.weatherapp_javafx.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;

public class MainViewController {
    @FXML
    private TreeView<?> currentTreeView;

    @FXML
    private TreeView<?> searchTreeView;

    @FXML
    void currentLocationBtn() {

    }

    @FXML
    void searchLocationBtn() {

    }

    protected ViewFactory viewFactory;
    private String fxmlName;

    public MainViewController(ViewFactory viewFactory, String fmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}