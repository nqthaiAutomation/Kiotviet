package com.example.definitions;

import com.example.pages.HomePage;
import com.example.steps.HomeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class HomeDefs {

    @Steps
    HomeSteps homeSteps;

    @Given("User is on Home page")
    public void userIsOnHomePage() {

        homeSteps.openHomePage();
    }
    @And("I click link into \"([^\"]*)\" on the header page")
    public void iClickLinkIntoOnTheHeaderPage(String links) {
        homeSteps.clickLinkIntoOnTheHeaderPage(links);
    }


    @And("I click button \"([^\"]*)\" on the header page")
    public void iClickButtonOnTheHeaderPage(String button) {
        homeSteps.clickButtonOnTheHeaderPage(button);
    }
}
