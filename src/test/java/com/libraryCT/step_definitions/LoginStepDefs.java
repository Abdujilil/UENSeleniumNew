package com.libraryCT.step_definitions;

import com.libraryCT.pages.LoginPage;
import com.libraryCT.utilities.BrowserUtils;
import com.libraryCT.utilities.ConfigurationReader;
import com.libraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user login as a {string}")
    public void the_user_login_as_a(String role) {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs(role);
    }

    @Then("the user is on {string} page")
    public void the_user_is_on_page(String expectedPage) {
        BrowserUtils.waitUntilURLContains(expectedPage);
        String actualURL = Driver.get().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedPage));
    }
}
