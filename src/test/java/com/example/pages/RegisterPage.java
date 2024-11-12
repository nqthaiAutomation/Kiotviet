package com.example.pages;

import com.example.common.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {
    public void switchTab(String titlePage) {
        String xPathTitlePageRegister= "//*[@class='new-register-top']//*[contains(text(),'"+titlePage+"')]";
        switchWindow();
        setWaitForElementTimeout(2000);
        Assert.assertTrue(isElementVisible(By.xpath(xPathTitlePageRegister)));
    }
}
