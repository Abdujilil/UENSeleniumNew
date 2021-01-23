package com.practice_cybertekschool.tests;

import com.practice_cybertekschool.utilities.BrowserUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.practice_cybertekschool.utilities.Driver.driver;

public abstract class TestBase {

    @BeforeMethod
    public void setup() {

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(2);
        driver.close();   //    comment:  ctrl(cmd) + /
    }
}
