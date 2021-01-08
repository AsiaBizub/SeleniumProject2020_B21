package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_cssSelectorTask {

    public static void main(String[] args) {

        //TC #3: Amazon link number verification
        // 1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to https://www.amazon.com

        driver.get("https://www.amazon.com");

        // 3. Enter search term (use cssSelectorto locate search box)

        WebElement amazonSearchBar = driver.findElement(By.cssSelector("input[id ='twotabsearchtextbox']"));

        // Second syntax for css Selector: tagName#attributeValue
        //WebElement amazonSearchBar = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        // tagname[attribute = 'value']

        amazonSearchBar.sendKeys("apple" + Keys.ENTER);

        /*
        How to open a search bar in Chrome:
        Mac: CMD+F
        WINDOWS: CNTRL + F
         */

        // 4. Verify title contains search term

        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedInTitle)){
            System.out.println("Title contains search key. Verification PASSED!");
        }else{
            System.out.println("Title does not contain search key. Verification FAILED!");
            System.out.println("actualTitle= " +actualTitle);
            System.out.println("expectedIntTitle = " +expectedInTitle);
        }



    }
    }
