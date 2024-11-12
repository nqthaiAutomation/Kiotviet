package com.example.common;

//import io.cucumber.java.After;

import net.serenitybdd.core.annotations.*;
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

    public void inputToElement(String xPathElement, String value) {
        getElement(xPathElement).clear();
        getElement(xPathElement).sendKeys(value);
    }

    public WebElement getElement(String xPathElement) {

        WebElement element= getDriver().findElement(By.xpath(xPathElement));
        hightLightElement(element);
        return element;

    }

    public List<WebElement> getElements(String xPathElement) {
        return getDriver().findElements(By.xpath(xPathElement));
    }

    public boolean isExistElement(String xPathElement) {
        return getElements(xPathElement).size() != 0;
    }
    public  void  hightLightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    public void scrollToElement(WebElement element)
    {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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