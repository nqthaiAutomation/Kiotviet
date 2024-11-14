package com.example.definitions;

import com.example.pages.ProcedurePage;
import com.example.steps.LoginSteps;
import com.example.steps.ProcedureSteps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class ProcedureDefs {
    @Steps
    ProcedureSteps procedureSteps;

    @And("^I select menu \"([^\"]*)\"$")
    public void iSelectMenu(String menu) {
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
    public void iVerifyButtonsDisplayed(String button) {
        procedureSteps.verifyButtonsDisplayed(button);
    }

    @And("^I verify type filters \"([^\"]*)\" displayed$")
    public void iVerifyTypeFilters(String typeFilters) {
        procedureSteps.verifyTypeFilters(typeFilters);

    }

    @And("^I verify list procedure is displayed$")
    public void iVerifyListProcedureIsDisplayed() {
        procedureSteps.verifyListProcedureIsDisplayed();
    }

    @And("^I verify table with title column \"([^\"]*)\"$")
    public void iVerifyTableWithTitleColumn(String column) {
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

    @And("^I select button \"([^\"]*)\"$")
    public void iSelectButton(String button) {
        procedureSteps.selectButton(button);

    }

    @Then("^I verify popup \"([^\"]*)\" displayed$")
    public void iVerifyPopupDisplayed(String headerPopup) {
        procedureSteps.verifyPopupDisplayed(headerPopup);

    }

    @And("^I verify tabs \"([^\"]*)\" displayed$")
    public void iVerifyTabsDisplayed(String tabsName) {
        procedureSteps.verifyTabsDisplayed(tabsName);

    }

    @And("^I verify buttons \"([^\"]*)\" displayed on the bottom$")
    public void iVerifyButtonsDisplayedOnTheBottom(String buttons) {
        procedureSteps.verifyButtonsDisplayedOnTheBottom(buttons);
    }

//    @And("^I upload file \"([^\"]*)\"$")
//    public void iUploadFile(String file) {
//        procedureSteps.uploadFile(file);
//
//    }

    @And("^I input into form with information below$")
    public void iInputIntoFormWithInformationBelow(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            System.out.println(row.keySet());
            for (String column : row.keySet())
                procedureSteps.inputValue(column.split(":")[0], column.split(":")[1], row.get(column));
        }
    }

    @And("^I click button \"([^\"]*)\" on the bottom$")
    public void iClickButtonOnTheBottom(String button) {
        procedureSteps.clickButtonOnTheBottom(button);


    }

    @Then("^I verify message error \"([^\"]*)\" displayed$")
    public void iVerifyMessageErrorDisplayed(String message) {
        procedureSteps.verifyMessageErrorDisplayed(message);
    }

    @Then("^I verify procedure \"([^\"]*)\" is added susses$")
    public void iVerifyProcedureIsAddedSusses(String name) {
        procedureSteps.verifyProcedureIsAddedSusses(name);
    }

    @And("^I upload file \"([^\"]*)\"$")
    public void iUploadFile(String file) {
        procedureSteps.iUploadFile(file);

    }

    @And("^I wait (\\d+) minute$")
    public void iWaitMinute(int number) {
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Then("^I verify procedure deleted$")
    public void iVerifyProcedureWithCodeDeleted()  {
        procedureSteps.verifyNoDataNotFound();
    }

    @And("^I click button \"([^\"]*)\" on the table$")
    public void iClickButtonOnTheTable(String button) {
        procedureSteps.clickButtonOnTheTable(button);
    }

    @And("^I expand first procedure$")
    public void iExpandFirstProcedure() {
        procedureSteps.expandFirstProcedure();
    }

    @And("^I click button add new of field \"([^\"]*)\"$")
    public void iClickButtonAddNewOfField(String field) throws Throwable {
        procedureSteps.clickButtonAddNewOfField(field);
    }

    @Then("^I verify message success \"([^\"]*)\" displayed$")
    public void iVerifyMessageSuccessDisplayed(String message) {
        procedureSteps.verifyMessageSuccessDisplayed(message);
    }

    @And("^I click button \"([^\"]*)\" on the dialog$")
    public void iClickButtonOnTheDialog(String button)  {
        procedureSteps.clickButtonOnTheDialog(button);
    }
}
