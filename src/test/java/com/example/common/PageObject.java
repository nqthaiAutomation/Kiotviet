package com.example.common;

//import io.cucumber.java.After;

import net.serenitybdd.core.annotations.*;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class PageObject extends net.serenitybdd.core.pages.PageObject {


    public void switchWindow() {
        Set<String> handles = getDriver().getWindowHandles();
        String handle = getDriver().getWindowHandle();
        for (String nextHandle : handles) {
            if (!nextHandle.equals(handle)) {
                getDriver().switchTo().window(nextHandle);
            }
        }
    }

    public void inputToElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public WebElement getElement(String xPathElement) {

        WebElement element = getDriver().findElement(By.xpath(xPathElement));
        if (element.isDisplayed())
            scrollToElement(element);
        hightLightElement(element);
        return element;

    }

    public List<WebElementFacade> getElements(String xPathElement) {
        return findAll(By.xpath(xPathElement));
    }

    public boolean isExistElement(String xPathElement) {
        return getElements(xPathElement).size() != 0;
    }

    public void hightLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
         waitABit(500);
    }

//    @After
//    public void endTheAct() {
//        if (getDriver() != null) {
//            getDriver().quit();
//        }
//
//
//    }

}