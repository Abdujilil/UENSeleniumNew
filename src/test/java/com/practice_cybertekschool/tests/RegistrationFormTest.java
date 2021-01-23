package com.practice_cybertekschool.tests;

import com.practice_cybertekschool.pages.HomePage;
import com.practice_cybertekschool.pages.RegistrationConfirmationPage;
import com.practice_cybertekschool.pages.RegistrationFormPage;
import com.practice_cybertekschool.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormTest extends TestBase{

    @Test
    public void test1() {

        HomePage homePage = new HomePage();

        homePage.registrationForm.click();

        BrowserUtils.sleep(2);

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage.firstname.sendKeys("John");

        registrationFormPage.lastname.sendKeys("Doe");

        registrationFormPage.username.sendKeys("john123");

        registrationFormPage.email.sendKeys("johndoe@hotmail.com");

        registrationFormPage.password.sendKeys("john123456");

        registrationFormPage.phoneNumber.sendKeys("123-123-1324");

        registrationFormPage.genders.get(1).click();

        registrationFormPage.birthday.sendKeys("01/01/1990");

        registrationFormPage.department.selectByVisibleText("Department of Engineering");

        registrationFormPage.jobTitle.selectByIndex(4);

        registrationFormPage.java.click();

        registrationFormPage.javaScript.click();

        registrationFormPage.clickSignUp();

        BrowserUtils.sleep(1);

        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = registrationConfirmationPage.confirmationMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verify confirmation message");

    }

}
