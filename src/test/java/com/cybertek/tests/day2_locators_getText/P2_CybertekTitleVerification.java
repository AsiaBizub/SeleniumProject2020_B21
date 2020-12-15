package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekTitleVerification {

    public static void main(String[] args) {

        //TC #2: Cybertek verifications
        //1. Open Chrome browser
        //setup my driver
        WebDriverManager.chromedriver().setup();
        //open browser
        WebDriver driver = new ChromeDriver();

        //2. Go to https://practice.cybertekschool.com
        driver.get("http://practice.cybertekschool.com");

        //3. Verify URL contains
        //Expected: cybertekschool
        //4. Verify title:
        //Expected: Practice

    }
}
