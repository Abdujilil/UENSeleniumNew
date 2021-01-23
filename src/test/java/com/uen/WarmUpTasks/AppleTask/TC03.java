package com.uen.WarmUpTasks.AppleTask;

import com.uen.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC03 {


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.apple.com");

        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class, 'item-menu')]/a"));  // //div[contains(@name, 'uu')]
        list.removeIf(p -> p.getAttribute("href").equals("https://www.apple.com/us/search"));

        int emptyLinkCount, linkTextCount;
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            WebElement eachElement = list.get(i);
            linkTextCount = 0;
            emptyLinkCount = 0;
            eachElement.click();
            List<WebElement> linkList = driver.findElements(By.tagName("a"));

            for (WebElement eachLink : linkList) {
                System.out.println(eachLink.getText());
                if (eachLink.getText().isEmpty()) {
                    emptyLinkCount++;
                } else {
                    linkTextCount++;
                }
            }

            System.out.println("Number of links with empty text: " + emptyLinkCount);
            System.out.println("Number of links with text: " + linkTextCount);
            System.out.println("Total number of texts: " + linkList.size());
            linkList.clear();
            driver.navigate().back();
            list = driver.findElements(By.xpath("//li[contains(@class, 'item-menu')]/a"));
        }

        driver.close();

    }
}
