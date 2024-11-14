package com.example.pages;

import com.example.common.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.server.Session;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ProcedurePage extends PageObject {
    String xPathInputSearch = "//*[contains(@class,'header-filter-search')]//input[@role='listbox']";
    String xPathButtonAdd = "//*[text()='$s']/ancestor::[@class='form-group']//*[@class='far fa-plus']";

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
        String[] filters = typeFilters.split("->");
        for (String filter : filters) {
            System.out.println(String.format(xPathFilter, filter.trim()));
            scrollToElement(getElement(String.format(xPathFilter, filter.trim())));
            Assert.assertTrue(isElementVisible(By.xpath(String.format(xPathFilter, filter.trim()))));
        }
    }

    public void verifyTableWithTitleColumn(String column) {
        String xPathColumn = "//th[contains(@role,'columnheader') and not(@style)]//*[contains(text(),'%s')]";
        String[] columns = column.split("->");
        for (String col : columns) {
            if (!isExistElement(String.format(xPathColumn, col.trim())))
                xPathColumn = "//th[contains(@role,'columnheader') and not(@style) and contains(text(),'%s')]";
            System.out.println(String.format(xPathColumn, col.trim()));
            Assert.assertTrue(isElementVisible(By.xpath(String.format(xPathColumn, col.trim()))));
            getElement(String.format(xPathColumn, col.trim()));
        }
    }

    public void verifyListProcedureIsDisplayed() {
        String xPathRows = "//tr[contains(@class,'k-master-row ng-scope') and not(contains(@class,'cssSummaryRow'))]";
        System.out.println(getElements(xPathRows).size());
        Assert.assertTrue(getElements(xPathRows).size() == 15);


    }

    public void inputIntoTextboxSearch(String value) {
//        System.out.println("Size:" + getElements(xPathInputSearch).size());
        for (WebElement element : getElements(xPathInputSearch)) {
            if (element.isDisplayed())
                inputToElement(element, value + Keys.ENTER);
        }
        String xPathcode = "//*[contains(text(),'" + value + "')]/ancestor::tr//td[contains(@class,'cell-code tdCodeDoctor')]";
//        System.out.println("codeProcedue:" + codeProcedue);
        waitABit(2000);
        new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));

        if (Serenity.sessionVariableCalled("codeProcedue") == null && isExistElement(xPathcode)) {
            Serenity.setSessionVariable("codeProcedue").to(getElement(xPathcode).getText());
            System.out.println("codeProcedue:" + Serenity.sessionVariableCalled("codeProcedue"));
        }
    }

    public void verifyProcedureHaveNameContainsIsDisplayedOnTheTable(String name) {
        List<WebElementFacade> elements = getElements("//tr[not(contains(@class,'cssSummaryRow'))]//td[contains(@class,'cell-auto ng-binding')]");
        for (WebElement element : elements) {
            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains(name));
            hightLightElement(element);
        }
    }

    public void selectButton(String button) {
        String[] buttons = button.split("->");
        String xPathButtonParent = "//*[contains(@class,'btn btn-success')]/*[text()='" + buttons[0] + "']";
        clickOn(getElement(xPathButtonParent));
        if (buttons.length > 1) {
            String xPathButtonChild = "//*[@class='addProductBtn']//ul//a[text()='" + buttons[1] + "']";
            clickOn(getElement(xPathButtonChild));
        }
    }

    public void verifyPopupDisplayed(String headerPopup) {
        String xPathHeaderTitle = "//*[@class='k-window-title' and text()='" + headerPopup + "']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathHeaderTitle)));
        getElement(xPathHeaderTitle);
    }

    public void verifyTabsDisplayed(String tabsName) {
        String[] tabs = tabsName.split("->");
        String xPathTab = "//*[contains(@class,'kvTabs')]//a[contains(@kv-focus-item,'tabBut') and text()='%s']";
        for (String tab : tabs) {
            Assert.assertTrue(isElementVisible(By.xpath(String.format(xPathTab, tab))));
            getElement(String.format(xPathTab, tab));
        }
    }

    public void verifyButtonsDisplayedOnTheBottom(String buttons) {
        String[] btns = buttons.split("->");
        String xPathbutton = "//*[contains(@class,'kv-window-footer')]//a[text()='%s']";
        boolean checkDisplayed = false;
        for (String btn : btns) {
            List<WebElementFacade> bt = getElements(String.format(xPathbutton, btn));
            int i = 1;
            for (WebElement button : bt) {
                if (button.isDisplayed()) {
                    i++;
                    checkDisplayed = true;
                    hightLightElement(button);
                    break;
                }
            }

            Assert.assertTrue(checkDisplayed);


        }
    }

    public void uploadFile(String files) {
        File file = new File(files);
        System.out.println(file.getAbsolutePath());
        getElement("//input[@id='new-files' and @type='file']").sendKeys(file.getAbsolutePath());
//        getElement("//input[@id='new-files']").sendKeys(file.getAbsolutePath());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inputValue(String field, String type, String value) {
        String xPathInput = "";
        switch (type) {
            case "TXT":
                xPathInput = "//*[text()='" + field + "']/ancestor::*[contains(@class,'form-group')]//input[@type='text']";
                inputToElement(getElement(xPathInput), value);
                break;
            case "NUMBER":
                xPathInput = "//*[text()='" + field + "']/ancestor::*[contains(@class,'form-group')]//input[@type='text' and @k-min='0']";
                inputToElement(getElement(xPathInput), value);
                break;
            case "CHECKBOX":
                xPathInput = "//*[text()='" + field + "']";
                String xPath_Check_CheckBox_Selelected = "//*[text()='" + field + "']/ancestor::*[contains(@class,'prettycheckbox')]//a[@class='checked']";
                if ((!isExistElement(xPath_Check_CheckBox_Selelected) && Boolean.parseBoolean(value)) || (isExistElement(xPath_Check_CheckBox_Selelected) && !Boolean.parseBoolean(value)))
                    clickOn(getElement(xPathInput));
                break;
            case "OPTION":
                xPathInput = "//*[text()='" + field + "']/ancestor::*[contains(@class,'form-group')]//span";
                String xPathValue = "//li[@role='option']//*[text()='" + value + "']";
                clickOn(getElement(xPathInput));
                for (WebElement element : getElements("//*[text()='Nhóm hàng']/following::input[@role='listbox' and not(@type) and @aria-haspopup='true']")) {
                    if (element.isDisplayed())
                        inputToElement(element, value);
                }
                waitABit(1000);
                List<WebElementFacade> elements = getElements(xPathValue);
                for (WebElement elm : elements)
                    if (elm.isDisplayed())
                        clickOn(elm);
                break;
            case "IMAGE":

                uploadFile(value);
                break;
            default:
                Assert.fail("Have not type:" + type + " yet");

        }
    }

    public void clickButtonOnTheBottom(String button) {
        String xPathbutton = "//*[contains(@class,'kv-window-footer')]//*[contains(text(),'%s')]";
        boolean checkDisplayed = false;
        List<WebElementFacade> bt = getElements(String.format(xPathbutton, button));
        for (WebElementFacade btn : bt) {
            if (btn.isDisplayed()&&btn.isCurrentlyEnabled()) {
                checkDisplayed = true;
                scrollToElement(btn);
                clickOn(btn);
                break;
            }
        }
        Assert.assertTrue(checkDisplayed);
    }

    public void verifyMessageErrorDisplayed(String message) {
        String xPathToast = "//*[@class='toast toast-error']//*[text()='" + message + "']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathToast)));
        getElement(xPathToast);
    }

    public void verifyProcedureIsAddedSusses(String name) {
        String xPathTitleProcedure = "//*[contains(@class,'product-detail')]//*[contains(@class,'title') and text()='" + name + "']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathTitleProcedure)));
        getElement(xPathTitleProcedure);
    }

    public void iUploadFile(String file) {
        File file1 = new File(file);

        inputToElement(getElement("//input[@type='file' and @id='files']"), file1.getAbsolutePath());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyNoDataNotFound() {
//        xPathInputSearch = "//*[contains(@class,'header-filter-search')]//input[@ng-model='filterQuickSearch']";
        getDriver().navigate().refresh();
        inputIntoTextboxSearch(Serenity.sessionVariableCalled("codeProcedue"));
        String xPathNoDataNotFound = "//*[@class='no-data']//*[text()='Không tìm thấy kết quả nào phù hợp']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathNoDataNotFound)));
        getElement(xPathNoDataNotFound);
    }

    public void clickButtonOnTheTable(String button) {
        String xPathButtonOnTheTable = "//table//*[contains(@class,'kv-group-btn')]//*[contains(@class,'btn') and contains(text(),'" + button + "')]";
//        System.out.println(xPathButtonOnTheTable);
        clickOn(getElement(xPathButtonOnTheTable));
    }

    public void expandFirstProcedure() {
        String xPathDetallProcedure = "//*[contains(@class,'k-detail-row')]";
        if (!isElementVisible(By.xpath(xPathDetallProcedure))) {
            clickOn(getElement("//td[contains(@class,'cell-auto ng-binding') and not(text()='')]"));
        }
    }

    public void clickButtonAddNewOfField(String field) {
        String xPath = "//*[text()='" + field + "']/ancestor::*[@class='form-group']//*[@class='far fa-plus']";
        clickOn(getElement(xPath));
        waitABit(2000);
    }

    public void verifyMessageSuccessDisplayed(String message) {
        String xPathMessageSuccess = "//*[contains(@class,'toast-success')]//*[text()='" + message + "']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathMessageSuccess)));
        getElement(xPathMessageSuccess);
    }
    //chưa run dc
    public void clickButtonOnTheDialog(String button) {
        String xPathbutton = "//input[@type='text' and (@id='trademarkAddOrEdit' or @id='shelvesAddOrEdit' or @id='idCategorySearchTerm')]/following::*//*[text()='%s']";
        boolean checkDisplayed = false;
        List<WebElementFacade> bt = getElements(String.format(xPathbutton, button));
        System.out.println(bt.size());
        for (WebElementFacade btn : bt) {
            if (btn.isDisplayed()) {
                checkDisplayed = true;
                scrollToElement(btn);
                clickOn(btn);
                break;
            }
        }
        Assert.assertTrue(checkDisplayed);
    }
}

