package com.example.pages;

import com.example.common.PageObject;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
public class SellPages extends PageObject {
    public void verifyIconsDisplayed(String icon) {
        String xPathIcon = "//*[@class='header-right']//a[@uib-tooltip='" + icon + "']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathIcon)));
        Serenity.recordReportData().withTitle("Log Data").andContents("icon:"+icon+" displayed");
    }
}
