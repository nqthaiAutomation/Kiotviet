package com.example.definitions;

import com.example.steps.SellSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SellDefs {
    @Steps
    SellSteps sellSteps;
    @Then("I verify icons displayed")
    public void iVerifyIconsDisplayed(DataTable dataTable) {
        List<String> list = new ArrayList<>(dataTable.asList(String.class));
        list.remove(0);
        for(String row:list){
            sellSteps.verifyIconsDisplayed(row);
        }

    }
}
