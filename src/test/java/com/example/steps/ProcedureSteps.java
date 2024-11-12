package com.example.steps;

import com.example.pages.ProcedurePage;
import net.thucydides.core.annotations.Step;

public class ProcedureSteps {
    ProcedurePage procedurePage;
    @Step
    public void selectMenu(String menu) {
        procedurePage.selectMenu(menu);
    }
    @Step
    public void verifyPageDisplayed(String title) {
        procedurePage.verifyPageDisplayed(title);
    }
    @Step
    public void verifyTextboxSearchDisplayed() {
        procedurePage.verifyTextboxSearchDisplayed();
    }
    @Step
    public void verifyButtonsDisplayed(String button) {
        procedurePage.verifyButtonsDisplayed(button);
    }
    @Step
    public void verifyTypeFilters(String typeFilters) {
        procedurePage.verifyTypeFilters(typeFilters);
    }
    @Step
    public void verifyTableWithTitleColumn(String column) {
        procedurePage.verifyTableWithTitleColumn(column);
    }
    @Step
    public void verifyListProcedureIsDisplayed() {
        procedurePage.verifyListProcedureIsDisplayed();
    }
    @Step
    public void inputIntoTextboxSearch(String value) {
        procedurePage.inputIntoTextboxSearch(value);
    }
    @Step
    public void verifyProcedureHaveNameContainsIsDisplayedOnTheTable(String name) {
        procedurePage.verifyProcedureHaveNameContainsIsDisplayedOnTheTable(name);
    }
    @Step
    public void selectButton(String button) {
        procedurePage.selectButton(button);
    }
}
