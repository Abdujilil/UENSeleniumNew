package com.uen.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class WebDriverFactory {


    public static WebDriver getDriver(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else if (browserName.equalsIgnoreCase("fire fox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("internet explorer")) {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }

        return null;

    }

    public static void testResultEquals(String expectedResult, String actualResult) {

        if (actualResult.equals(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Expected Result = " + expectedResult);
            System.out.println("Actual Result = " + actualResult);
            System.out.println("Test Failed!!!");
        }

    }

    public static void testResultEquals(List<String> expectedResult, List<String> actualResult) {

        if (actualResult.equals(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Expected Result = " + expectedResult);
            System.out.println("Actual Result = " + actualResult);
            System.out.println("Test Failed!!!");
        }

    }

    public static void testResultContains(String expectedResult, String actualResult) {

        if (actualResult.contains(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Expected Result = " + expectedResult);
            System.out.println("Actual Result = " + actualResult);
            System.out.println("Test Failed!!!");
        }

    }

    public static void testResultContains(List<String> expectedResult, List<String> actualResult) {

        if (actualResult.containsAll(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Expected Result = " + expectedResult);
            System.out.println("Actual Result = " + actualResult);
            System.out.println("Test Failed!!!");
        }

    }

    public static void testDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!!");
        }
    }

    public static void testNotDisplayed(WebElement element) {

        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Test Passed!");
        }

         /*
        if (!element.isDisplayed()) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!!");
        }

          */
    }

    public static void testSelected(WebElement element) {
        if (element.isSelected()) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!!!");
        }
    }

    public static void testNotSelected(WebElement element) {
        if (!element.isSelected()) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!!!");
        }
    }

    public static void sleep(double seconds)  {

        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {

        }
    }


}
