package com.practice_cybertekschool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.practice_cybertekschool.utilities.Driver.driver;

public class RegistrationConfirmationPage {


    public WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]/p"));

}
