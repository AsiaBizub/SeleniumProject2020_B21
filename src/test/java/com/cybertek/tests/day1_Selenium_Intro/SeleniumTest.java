package com.cybertek.tests.day1_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        //1- Setup web driver manager
        WebDriverManager.chromedriver().setup();
        //System.setProperty("chrome", "path of driver");

        //2- Create instance of web driver
        // this is the line where the Selenium WebDriver opens the browser
        WebDriver driver = new ChromeDriver();

        //3- Use the instance to get the URL we want
        driver.get("https://www.google.com");

        //we are using navigate.back method from SELENIUM LIBRARY
        Thread.sleep(3000);

        //goes to back
        driver.navigate().back();

        Thread.sleep(3000);

        //goes to forward
        driver.navigate().forward();

        Thread.sleep(3000);

        //this is similar to get method. it gets the given URL.
        driver.navigate().to("https://www.tesla.com");







    }
}
