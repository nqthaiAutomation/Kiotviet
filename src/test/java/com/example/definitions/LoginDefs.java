package com.example.definitions;

import com.example.steps.HomeSteps;
import com.example.steps.LoginSteps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.json.Json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class LoginDefs {
    @Steps
    LoginSteps loginSteps;
    @Steps
    HomeSteps homeSteps;
    String content;

    {
        try {
            content = new String(Files.readAllBytes(Paths.get("src/test/data/InforStore/infostore.json")));
        } catch (IOException e) {
            Assert.fail("Wrong when read file json");
        }
    }
    JSONObject inforStore = new JSONObject(content);
    @And("I input \"([^\"]*)\" into address access")
    public void iInputIntoAddressAccess(String addressAccess) {
        loginSteps.inputIntoAddressAccess(addressAccess);
    }

    @And("I click button \"([^\"]*)\" on the popup")
    public void iClickButtonOnThePopup(String button) {
        loginSteps.clickButtonOnThePopup(button);
    }

    @Then("I verify form login displayed")
    public void iVerifyFormLoginDisplayed() {
        loginSteps.verifyFormLoginDisplayed();
    }

    @And("I input into form login with information below")
    public void iInputIntoFormWithInformationBelow(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String>row:data){
            String userName = row.get("username");
            String password = row.get("password");
            loginSteps.inputIntoUserName(userName);
            loginSteps.inputIntoPassword(password);
        }

    }

    @And("I click button \"([^\"]*)\" on the form login")
    public void iClickButtonOnTheFormLogin(String button) {
        loginSteps.clickButtonOnTheFormLogin(button);
    }

    @Then("I verify error \"([^\"]*)\" displayed")
    public void iVerifyErrorDisplayed(String message) {
        loginSteps.verifyErrorDisplayed(message);
    }


    @Given("^I login susses$")
    public void iLoginSusses() {
        homeSteps.openHomePage();
        homeSteps.clickButtonOnTheHeaderPage("Đăng nhập");
        System.out.println(inforStore.toString());
        loginSteps.inputIntoAddressAccess(inforStore.getString("StoreName"));
        loginSteps.clickButtonOnThePopup(" Vào cửa hàng ");
        loginSteps.inputIntoUserName(inforStore.getString("UserName"));
        loginSteps.inputIntoPassword(inforStore.getString("Password"));
        loginSteps.clickButtonOnTheFormLogin("Quản lý");
    }
}
