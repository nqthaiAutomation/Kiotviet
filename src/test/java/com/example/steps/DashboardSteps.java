package com.example.steps;

import com.example.pages.DashboardPage;

public class DashboardSteps {
    DashboardPage dashboardPage;
    public boolean isDashboardDisplayed(String row) {
        return  dashboardPage.isDashboardDisplayed(row);
    }
}
