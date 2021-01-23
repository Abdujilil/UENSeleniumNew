package com.uen.WarmUpTasks.E_commerce;

import com.github.javafaker.Faker;
import com.uen.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC1 {

    WebDriver driver;
    Faker faker = new Faker();
    Random random = new Random();

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.sleep(2);
        driver.close();
    }

    @Test
    public void test1() {

        WebElement createAccount = driver.findElement(By.xpath("//input[@id='email_create']"));
        createAccount.sendKeys(faker.internet().emailAddress());

        WebElement createAccountButton = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
        createAccountButton.click();

        WebDriverFactory.sleep(4);

        String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='id_gender']"));
        genders.get(random.nextInt(genders.size())).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement password = driver.findElement(By.xpath("//input[@name='passwd']"));
        password.sendKeys(faker.internet().password(5,16));  // excel   .text

        Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        days.selectByValue("25");

        Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        months.selectByIndex(4);
        months.selectByVisibleText("January");

        Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        years.selectByValue("1980");

        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys(faker.address().city());

        Select states = new Select(driver.findElement(By.xpath("//select[@name='id_state']")));
        states.selectByVisibleText(faker.address().state());

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='postcode']"));
        zipCode.sendKeys(faker.address().zipCode().substring(0,5));

        Select countries = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
        countries.selectByVisibleText("United States");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone_mobile']"));
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        WebElement alias = driver.findElement(By.id("alias"));
        alias.sendKeys("My address");

        WebElement registerButton = driver.findElement(By.xpath("//button[@name='submitAccount']"));
        registerButton.click();

        WebDriverFactory.sleep(3);

        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }
}


/*
Test Case 1 - Automate User Registration Process

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter your email address in 'Create and account' section.
4. Click on Create an Account button.
5. Enter your Personal Information, Address and Contact info.
6. Click on Register button.
7. Validate that user is created.
 */