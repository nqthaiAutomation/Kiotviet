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
    @Step
    public void verifyPopupDisplayed(String headerPopup) {
        procedurePage.verifyPopupDisplayed(headerPopup);
    }
    @Step
    public void verifyTabsDisplayed(String tabsName) {
        procedurePage.verifyTabsDisplayed(tabsName);
    }
    @Step
    public void verifyButtonsDisplayedOnTheBottom(String buttons) {
        procedurePage.verifyButtonsDisplayedOnTheBottom(buttons);
    }
    @Step
    public void inputValue(String field, String type, String value) {
        procedurePage.inputValue(field,type,value);
    }
    @Step
    public void clickButtonOnTheBottom(String button) {
        procedurePage.clickButtonOnTheBottom(button);
    }
    @Step
    public void verifyMessageErrorDisplayed(String message) {
        procedurePage.verifyMessageErrorDisplayed(message);
    }
    @Step
    public void verifyProcedureIsAddedSusses(String name) {
        procedurePage.verifyProcedureIsAddedSusses(name);
    }
    @Step
    public void iUploadFile(String file) {
        procedurePage.iUploadFile(file);
    }
    @Step
    public void verifyNoDataNotFound() {
        procedurePage.verifyNoDataNotFound();
    }
    @Step
    public void clickButtonOnTheTable(String button) {
        procedurePage.clickButtonOnTheTable(button);
    }
    @Step
    public void expandFirstProcedure() {
        procedurePage.expandFirstProcedure();
    }
    @Step
    public void clickButtonAddNewOfField(String field) {
        procedurePage.clickButtonAddNewOfField(field);
    }
    @Step
    public void verifyMessageSuccessDisplayed(String message) {
        procedurePage.verifyMessageSuccessDisplayed(message);
    }
    @Step
    public void clickButtonOnTheDialog(String button) {
        procedurePage.clickButtonOnTheDialog(button);
    }
    @Step
    public void clickButtonOnTheFormUpload(String button) {
        procedurePage.clickButtonOnTheFormUpload(button);
    }
    @Step
    public void verifyFieldHasValue(String field, String value) {
        procedurePage.verifyFieldHasValue(field,value);
    }
}
