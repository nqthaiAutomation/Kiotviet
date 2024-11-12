package com.example.definitions;

import com.example.steps.RegisterSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class RegisterDefs {
    @Steps
    RegisterSteps registerSteps;
    @Then("I switch tab \"([^\"]*)\"")
    public void iSwitchTab(String titlePage) {
        registerSteps.switchTab(titlePage);

    }
}
