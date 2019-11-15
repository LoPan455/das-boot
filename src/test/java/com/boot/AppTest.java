package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;

import static junit.framework.Assert.*;

public class AppTest {

    @Test
    public void testApp() {
        HomeController homeController = new HomeController();
        String result = homeController.home();
        assertEquals("Das Boot, reporting for duty!", result);
    }

}
