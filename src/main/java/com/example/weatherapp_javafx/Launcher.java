package com.example.weatherapp_javafx;

import com.example.weatherapp_javafx.views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMainWindow();
    }

}