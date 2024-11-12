package com.example.definitions;

import com.example.pages.ProcedurePage;
import com.example.steps.LoginSteps;
import com.example.steps.ProcedureSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProcedureDefs {
    @Steps
    ProcedureSteps procedureSteps;
    @And("^I select menu \"([^\"]*)\"$")
    public void iSelectMenu(String menu)  {
        procedureSteps.selectMenu(menu);

    }

    @Then("^I verify page \"([^\"]*)\" displayed$")
    public void iVerifyPageDisplayed(String title) {
        procedureSteps.verifyPageDisplayed(title);

    }

    @And("^I verify textbox search displayed$")
    public void iVerifyTextboxSearchDisplayed() {
        procedureSteps.verifyTextboxSearchDisplayed();
    }

    @And("^I verify buttons \"([^\"]*)\" displayed$")
    public void iVerifyButtonsDisplayed(String button)   {
        procedureSteps.verifyButtonsDisplayed(button);
    }

    @And("^I verify type filters \"([^\"]*)\" displayed$")
    public void iVerifyTypeFilters(String typeFilters)   {
        procedureSteps.verifyTypeFilters(typeFilters);

    }

    @And("^I verify list procedure is displayed$")
    public void iVerifyListProcedureIsDisplayed() {
        procedureSteps.verifyListProcedureIsDisplayed();
    }

    @And("^I verify table with title column \"([^\"]*)\"$")
    public void iVerifyTableWithTitleColumn(String column)   {
        procedureSteps.verifyTableWithTitleColumn(column);

    }

    @When("^I input \"([^\"]*)\" into textbox search$")
    public void iInputIntoTextboxSearch(String value) {
        procedureSteps.inputIntoTextboxSearch(value);

    }

    @Then("^I verify procedure have name contains \"([^\"]*)\" is displayed on the list$")
    public void iVerifyProcedureHaveNameContainsIsDisplayedOnTheList(String name) {
        procedureSteps.verifyProcedureHaveNameContainsIsDisplayedOnTheTable(name);

    }
}
