package com.practice_cybertekschool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.practice_cybertekschool.utilities.Driver.driver;

public class HomePage {

    public WebElement registrationForm = driver.findElement(By.xpath("//a[.='Registration Form']"));

}
