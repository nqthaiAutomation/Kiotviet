package com.example.steps;

import com.example.pages.RegisterPage;

public class RegisterSteps {
    RegisterPage registerPage;
    public void switchTab(String titlePage) {
        registerPage.switchTab(titlePage);
    }
}
