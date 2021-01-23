package com.practice_cybertekschool.utilities;

public class BrowserUtils {

    public static void sleep(int seconds) {  // 2 3

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {

        }

    }

}
