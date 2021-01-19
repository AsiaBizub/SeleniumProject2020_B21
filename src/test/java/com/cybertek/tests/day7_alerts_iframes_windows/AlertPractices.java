package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class AlertPractices {

    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {

        // 1. Open Browser
        driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 3.Click to “Click for JS Alert”button4.Click to OK button from the alert
        // 5.Verify “You successfulyclicked an alert”text is displayed.
    }

    @AfterMethod
    public void teardownMethod(){
        Thread.sleep(5000);
        driver.close();
    }
}


