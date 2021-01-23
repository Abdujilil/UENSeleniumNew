package com.uen.WarmUpTasks.Google;

import com.uen.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ajax {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testAjax() {

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("techlistic");

        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));

        for (WebElement searchResult : searchResults) {

            System.out.println(searchResult.getText());

        }

    }
}

/*
Test Steps:
Launch the Google Chrome.
Open URL - http://www.google.com
Enter keyword "techlistic" in search bar
Wait for ajax suggestion box to appear
Get/store all the options of suggestion box in a list
Print all the suggestions one by one.
 */