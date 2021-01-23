package com.uen.WarmUpTasks;

import com.uen.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteButton50 {

    private WebDriver driver;

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

        WebElement addButton = driver.findElement(By.xpath("//div[@class='example']/button"));

        for (int i = 1; i <= 50; i++) {

            addButton.click();

        }

        List<WebElement> list = driver.findElements(By.xpath("//button[@class='added-manually']"));

        int displayedCount = 0;

        for (WebElement eachButton : list) {

            if (eachButton.isDisplayed()) {
                displayedCount++;
            }

        }

        Assert.assertEquals(displayedCount,50);

        WebElement deleteButton;

        for (int i = 0; i < list.size(); i++) {

            deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
            deleteButton.click();

        }

        String actualResult = driver.findElement(By.id("elements")).getText();  // ""

        Assert.assertEquals(actualResult,"");

    }
}

/*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.

5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
 */