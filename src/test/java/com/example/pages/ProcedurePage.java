package com.example.pages;

import com.example.common.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class ProcedurePage extends PageObject {
    String xPathInputSearch = "//*[contains(@class,'header-filter-search')]//input[@role='listbox']";

    public void selectMenu(String menu) {
        String[] menuItems = menu.split("->");
        String xPathMenuParent = "//ul[@class='kv-navbar-list']//*[text()='" + menuItems[0].trim() + "']";
        scrollToElement(getElement(xPathMenuParent));
        clickOn(getElement(xPathMenuParent));
        String xPathMenuChild = "//li[@class='ng-scope']//*[text()='" + menuItems[1].trim() + "']";
        clickOn(getElement(xPathMenuChild));

    }

    public void verifyPageDisplayed(String title) {
        String xpathHeader = "//h1[@class='heading-page']/span[text()='" + title + "']";
        Assert.assertTrue(isElementVisible(By.xpath(xpathHeader)));
    }

    public void verifyTextboxSearchDisplayed() {
        getElement(xPathInputSearch);
        Assert.assertTrue(isElementVisible(By.xpath(xPathInputSearch)));
    }

    public void verifyButtonsDisplayed(String button) {
        String xPathHeaderButton = "//*[contains(@class,'header-filter-buttons')]";
        String[] buttons = button.split("->");
        for (String btn : buttons) {
            String xPathButton = xPathHeaderButton + "//*[contains(text(),'" + btn.trim() + "')]/ancestor::a";
            Assert.assertTrue(getElement(xPathButton).isDisplayed());

        }
    }


    public void verifyTypeFilters(String typeFilters) {
        String xPathFilter = "//article[not(contains(@class,'hide'))]//h3[not(@ng-show) and contains(@class,'leftTitle') and contains(text(),'%s')]";
        String []filters = typeFilters.split("->");
        for(String filter:filters){
            System.out.println(String.format(xPathFilter,filter.trim()));
            scrollToElement(getElement(String.format(xPathFilter,filter.trim())));
            Assert.assertTrue(isElementVisible(By.xpath(String.format(xPathFilter,filter.trim()))));
        }
    }

    public void verifyTableWithTitleColumn(String column) {
        String xPathColumn = "//th[contains(@role,'columnheader') and not(@style)]//*[contains(text(),'%s')]";
        String []columns = column.split("->");
        for(String col:columns){
            if(!isExistElement(String.format(xPathColumn,col.trim())))
                xPathColumn= "//th[contains(@role,'columnheader') and not(@style) and contains(text(),'%s')]";
            System.out.println(String.format(xPathColumn,col.trim()));
            Assert.assertTrue(isElementVisible(By.xpath(String.format(xPathColumn,col.trim()))));
            getElement(String.format(xPathColumn,col.trim()));
        }
    }

    public void verifyListProcedureIsDisplayed() {
        String xPathRows= "//tr[contains(@class,'k-master-row ng-scope') and not(contains(@class,'cssSummaryRow'))]";
        System.out.println(getElements(xPathRows).size());
        Assert.assertTrue(getElements(xPathRows).size()==15);


    }

    public void inputIntoTextboxSearch(String value) {
        inputToElement(xPathInputSearch,value+ Keys.ENTER);
        new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));
    }

    public void verifyProcedureHaveNameContainsIsDisplayedOnTheTable(String name) {
        List<WebElement> elements = getElements("//tr[not(contains(@class,'cssSummaryRow'))]//td[contains(@class,'cell-auto ng-binding')]");
        for(WebElement element :elements) {
            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains(name));
            hightLightElement(element);
        }
    }
}
