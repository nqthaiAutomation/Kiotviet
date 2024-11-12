package com.example.pages;


import com.example.common.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject {
    public void clickLinkIntoOnTheHeaderPage(String link) {

    }

    String xPathUlOnheader = "//ul[contains(@class,'navbar-header-content')]";

    public void openHomePage() {
        if (getDriver() != null)
            getDriver().quit();
        waitABit(2000);
        open();
        getDriver().manage().window().maximize();
//        getDriver().manage().window().
    }

    public void clickButtonOnTheHeaderPage(String button) {
        String xPathButton = xPathUlOnheader + "//li/button[text()='" + button + "']";
        WebElement elmButton = find(By.xpath(xPathButton));
        clickOn(elmButton);
    }
}
