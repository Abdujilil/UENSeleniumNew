package com.uen.WarmUpTasks;

import com.practice_cybertekschool.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.practice_cybertekschool.utilities.Driver.driver;

public class WebTables {

    @BeforeMethod
    public void setup() {
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(2);
        driver.close();   //    comment:  ctrl(cmd) + /
    }

    @Test
    public void storeWebTables() {

        int numberOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        int numberOfColm = driver.findElements(By.xpath("//table[@id='table1']//th")).size();

        List<Map<String,String>> webTable = new LinkedList<>();



        for (int i = 1; i <= numberOfRows; i++) {  // 1

            Map<String, String> map = new LinkedHashMap<>();

            for (int j = 1; j <= numberOfColm; j++) {  // 1 2 3

                WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")); ////table[@id='table1']/tbody/tr[  1  ]/td[  3  ]
                WebElement header = driver.findElement(By.xpath("//table[@id='table1']//th[" + j + "]")); ////table[@id='table1']//th[ +  3  +]

                map.put(header.getText(),cell.getText());

            }

            webTable.add(map);

        }

        for (Map<String, String> row : webTable) {
            System.out.println(row);
        }

    }
}
