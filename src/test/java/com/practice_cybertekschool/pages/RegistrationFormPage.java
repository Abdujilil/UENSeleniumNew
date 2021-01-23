package com.practice_cybertekschool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.practice_cybertekschool.utilities.Driver.driver;

public class RegistrationFormPage {


    public WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
    public WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
    public WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
    public WebElement email = driver.findElement(By.xpath("//input[@name='email']"));  // cmd + D    windows: ctl + D
    public WebElement password = driver.findElement(By.xpath("//input[@name='password']"));  // cmd + D    windows: ctl + D
    public WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));  // cmd + D    windows: ctl + D
    public WebElement birthday = driver.findElement(By.xpath("//input[@name='birthday']"));  // cmd + D    windows: ctl + D
    public List<WebElement> genders = driver.findElements(By.xpath("//input[@name='gender']"));
    public WebElement departmentDropdown = driver.findElement(By.xpath("//select[@name='department']"));
    public Select department = new Select(departmentDropdown);
    public WebElement jobTitleDropdown = driver.findElement(By.xpath("//select[@name='job_title']"));
    public Select jobTitle = new Select(departmentDropdown);
    public WebElement cPlusPlus = driver.findElement(By.xpath("//input[@value='cplusplus']"));
    public WebElement java = driver.findElement(By.xpath("//input[@value='java']"));
    public WebElement javaScript = driver.findElement(By.xpath("//input[@value='javascript']"));




    public void enterFirstname() {
        firstname.sendKeys();
    }

    public void enterFirstname(String firstname) {
        this.firstname.sendKeys(firstname);
    }


    public void clickSignUp() {
        WebElement signUpButton = driver.findElement(By.id("wooden_spoon"));
        signUpButton.click();
    }


}
