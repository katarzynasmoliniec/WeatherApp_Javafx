package com.example.weatherapp_javafx.views;

import com.example.weatherapp_javafx.controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() {
        MainViewController controller = new MainViewController(this, "MainView.fxml");
        initializeStage(controller);
    }

    protected void initializeStage(MainViewController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Zobacz pogodę dla miejsc z Twojej podróży!");
        scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
        stage.show();
    }
}
