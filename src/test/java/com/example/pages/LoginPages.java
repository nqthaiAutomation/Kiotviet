package com.example.pages;

import com.example.common.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPages extends PageObject {
    public void inputIntoAddressAccess(String addressAccess) {
        inputToProcessLogin("Địa chỉ truy cập cửa hàng", addressAccess);
    }

    private void inputToProcessLogin(String field, String addressAccess) {
        String xPathField = "//span[@data-label='" + field + "']/parent::label/input[@type='text']|//input[(@type='text' or @type='password') and @placeholder='" + field + "']";
        inputToElement(getElement(xPathField), addressAccess);
    }

    public void clickButtonOnThePopup(String button) {
        String xPathButton = "//*[contains(@class,'popup-login-content')]//button[text()='" + button + "']";
        clickOn(getElement(xPathButton));
    }

    public void verifyFormLoginDisplayed() {
        String xPathFormLogin = "//form[@id='loginForm']//*[contains(@class,'loginBox')]";
        Assert.assertTrue(isElementVisible(By.xpath(xPathFormLogin)));
    }

    public void inputIntoUserName(String userName) {
        inputToProcessLogin("Tên đăng nhập", userName);
    }

    public void inputIntoPassword(String password) {
        inputToProcessLogin("Mật khẩu", password);
    }

    public void clickButtonOnTheFormLogin(String button) {
        String xPathButon="//input[(@type='submit' or @type='button') and @value='"+button+"']";
        clickOn(getElement(xPathButon));
    }

    public void verifyErrorDisplayed(String message) {
        String xPathMessageError="//*[@class='validation-summary-errors']//li[text()='"+message+"']";
        Assert.assertTrue(isElementVisible(By.xpath(xPathMessageError)));
    }
}
