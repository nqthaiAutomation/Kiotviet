package com.example.pages;

import com.example.common.PageObject;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {
    public boolean isDashboardDisplayed(String row) {
        String xPathDashboard = "//*[(contains(@class,'Title') or contains(@id,'Title'))  and text()='" + row + "']";
        return isElementVisible(By.xpath(xPathDashboard));
    }
}
