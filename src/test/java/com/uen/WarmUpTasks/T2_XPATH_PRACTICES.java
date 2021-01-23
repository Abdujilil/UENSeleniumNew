package com.uen.WarmUpTasks;

import com.uen.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_XPATH_PRACTICES {

    private WebDriver driver;  // global variable

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {

        driver.findElement(By.xpath("//div[@class='example']/button")).click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        Assert.assertTrue(deleteButton.isDisplayed());

        deleteButton.click();

        String actualResult = driver.findElement(By.id("elements")).getText();

        Assert.assertEquals(actualResult,"");



    }


}

/*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.

5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
 */