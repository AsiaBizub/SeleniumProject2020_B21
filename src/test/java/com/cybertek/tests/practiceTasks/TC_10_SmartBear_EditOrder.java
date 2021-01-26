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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_10_SmartBear_EditOrder {

    WebDriver driver;

    @BeforeMethod

    public void setUpMethod() {
        // 1.Open browser and login to SmartBear
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);
    }

    @Test
    public void orderEdit() throws InterruptedException {
        // 2.Click to edit button from the right for “Steve Johns”
        WebElement editButton = driver.findElement(By.xpath("//table[@class='SampleTable']//tr[4]/td[13]"));
        editButton.click();
        Thread.sleep(2000);

        // 3.Change name to “Michael Jordan”

        WebElement nameInputBox = driver.findElement(By.xpath("//table//tr//td[2]//ol[2]//li//input"));
        nameInputBox.clear();

        // 4.Click Update

        nameInputBox.sendKeys("Michael Jordan");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        // 5.Assert “Michael Jordan” is in the list

        List<WebElement> allNames = driver.findElements(By.xpath("(//table)[2]//tr//td[2]"));

        for( WebElement each : allNames){
            if(each.getText().equals("Michael Jordan")){
                Assert.assertTrue(each.getText().equals("Michael Jordan"));
                System.out.println("Michael Jordan located in the list");
            }else{
                System.err.println("Michael Jordan not found. Space Jam assertion failed");
            }
        }

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }
}
