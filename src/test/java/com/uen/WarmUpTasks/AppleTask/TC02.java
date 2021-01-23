package com.uen.WarmUpTasks.AppleTask;

import com.uen.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC02 {


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.apple.com");

        driver.findElement(By.xpath("//a[@href='/iphone/']")).click();

        List<WebElement> list = driver.findElements(By.tagName("a"));

        int linkTextCount = 0;
        int emptyLinkCount = 0;

        for (WebElement eachLink : list) {
            System.out.println(eachLink.getText());
            if (eachLink.getText().length() == 0) {
                emptyLinkCount++;
            } else {
                linkTextCount++;
            }
        }

        System.out.println("Links with no text: " + emptyLinkCount);
        System.out.println("Links with text: " + linkTextCount);
        System.out.println("Total number of links: " + list.size());

        driver.close();

    }
}
