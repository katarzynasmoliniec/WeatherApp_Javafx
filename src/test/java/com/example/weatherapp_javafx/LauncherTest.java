package com.example.weatherapp_javafx;

import com.example.weatherapp_javafx.views.ViewFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {

    @Test
    void defaultViewFactoryShouldBeNotNull() {
        //given
        ViewFactory viewFactory = new ViewFactory();
        //when
        //then
        assertNotNull(viewFactory);
    }

}