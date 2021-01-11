package com.cybertek.tests.day6_drowndown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //maximize
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException {
        // We need to locate the dropdown and create Select class object
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois --> select by visible text
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia --> select by value
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California --> select by index
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOption = "California";

        //Finding currently selected option
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        //AssertEquals: expects args to compare

        Assert.assertEquals(actualOption, expectedOption, "Final selected option is not as expected.");

    }


    @Test
    public void test3_date_dropdown_verification() throws InterruptedException {

        //We need to locate all the dropdowns to be able to select options
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //for shortcut code moving:
        //mac: command + shift + d
        //window: control + shift + d

        //Select “December 1 , 1922” and verify it is selected.
        //   Select year using : visible text
        Thread.sleep(1000);
        yearDropdown.selectByVisibleText("1922");

        //   Select month using : value attribute
        Thread.sleep(1000);
        monthDropdown.selectByValue("11");

        //   Select day using : index number
        Thread.sleep(1000);
        dayDropdown.selectByIndex(0);



    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

        driver.close();

    }

}
