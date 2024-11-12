package com.example.steps;

import com.example.pages.SellPages;

import java.util.Map;

public class SellSteps {
    SellPages sellPages;
    public void verifyIconsDisplayed(String icon) {
        sellPages.verifyIconsDisplayed(icon);
    }
}
