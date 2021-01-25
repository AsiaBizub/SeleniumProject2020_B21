package com.cybertek.tests.practiceTasks;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TC_9_SmartBear_DeleteOrder {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod (){
        // 1.Open browser and login to SmartBear
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);
    }



    @Test
    public void deleteMarkSmith() throws InterruptedException {

        // locate username input box using id
        // Enter username: tester

        //driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        // locate password input box using id
        // Enter password: test
        //driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //Click the sign in button
        //driver.findElement(By.id("ctl100_MainContent_login_button")).click();

        //Delete Mark Smith from the list
        WebElement markBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        markBox.click();
        Thread.sleep(5000);

        WebElement deleteButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']"));
        deleteButton.click();
        Thread.sleep(5000);

        // 3.Assert it is deleted from the list
        WebElement name = driver.findElement(By.xpath("//table/tbody/tr/td[2]"));

        String actualResult = name.getText();
        String expectedResult = "Mark Smith";

        Assert.assertTrue(!expectedResult.equals(actualResult));


        Assert.assertNotEquals(name.getText(),"Mark Smith");

        }


    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();

    }


}
