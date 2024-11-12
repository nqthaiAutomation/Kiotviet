package com.example.definitions;

import com.example.steps.DashboardSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DashboardDefs {
    @Steps
    DashboardSteps dashboardSteps;

    @Then("I verify dashboards is displayed")
    public void iVerifyDashboardsIsDisplayed(DataTable dataTable) {
        List<String> list = new ArrayList<>(dataTable.asList(String.class));
        list.remove(0);
         for(String row:list){
             Assert.assertTrue(dashboardSteps.isDashboardDisplayed(row));
             System.out.println(row+": is displayed");
         }
    }
}
