package com.example.steps;

import com.example.pages.HomePage;

import java.util.logging.Logger;

public class HomeSteps {
//    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());
    HomePage homePage;
    public void clickLinkIntoOnTheHeaderPage(String link) {
        homePage.clickLinkIntoOnTheHeaderPage(link);
    }

    public void clickButtonOnTheHeaderPage(String button) {
        homePage.clickButtonOnTheHeaderPage(button);
    }

    public void openHomePage() {
        homePage.openHomePage();
    }
}
