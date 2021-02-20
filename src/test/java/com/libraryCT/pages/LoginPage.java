package com.libraryCT.pages;

import com.libraryCT.utilities.BrowserUtils;
import com.libraryCT.utilities.ConfigurationReader;
import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;


    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        BrowserUtils.waitUntilClickable(signInButton).click();
    }

    public void loginAs(String role) {
        String username;
        String password;
        if (role.equalsIgnoreCase("student")) {
            username = ConfigurationReader.get("studentusername");
            password = ConfigurationReader.get("studentpassword");
            login(username,password);
        } else if (role.equalsIgnoreCase("librarian")) {
            username = ConfigurationReader.get("librarianusername");
            password = ConfigurationReader.get("librarianpassword");
            login(username,password);
        } else {
            throw new RuntimeException("Invalid user type!!!");
        }
    }

}
