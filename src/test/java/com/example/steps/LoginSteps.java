package com.example.steps;

import com.example.pages.LoginPages;

public class LoginSteps {
    LoginPages loginPages;
    public void inputIntoAddressAccess(String addressAccess) {
        loginPages.inputIntoAddressAccess(addressAccess);
    }

    public void clickButtonOnThePopup(String button) {
        loginPages.clickButtonOnThePopup(button);
    }

    public void verifyFormLoginDisplayed() {
        loginPages.verifyFormLoginDisplayed();
    }

    public void inputIntoUserName(String userName) {
        loginPages.inputIntoUserName(userName);
    }

    public void inputIntoPassword(String passwrod) {
        loginPages.inputIntoPassword(passwrod);
    }

    public void clickButtonOnTheFormLogin(String button) {
        loginPages.clickButtonOnTheFormLogin(button);
    }

    public void verifyErrorDisplayed(String message) {
        loginPages.verifyErrorDisplayed(message);
    }
}
