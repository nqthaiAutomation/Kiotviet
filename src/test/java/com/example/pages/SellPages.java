package com.example.pages;

import com.example.common.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SellPages extends PageObject {
    public void verifyIconsDisplayed(String icon) {
        String xPathIcon = "//*[@class='header-right']//a[@uib-tooltip='" + icon + "']";
        System.out.println(xPathIcon);
        Assert.assertTrue(isElementVisible(By.xpath(xPathIcon)));
    }
}
