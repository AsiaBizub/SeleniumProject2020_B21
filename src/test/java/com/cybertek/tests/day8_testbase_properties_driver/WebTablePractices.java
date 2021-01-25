package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebOrderUtils;
import org.testng.annotations.Test;

public class WebTablePractices extends TestBase {

    @Test
    public void verify_order_test() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        WebOrderUtils.loginToSmartBear(driver);

        //This is re-usable method we created in BrowserUtil class to replace Thread.sleep
        BrowserUtils.sleep(1);

        //Verify "Mark Smith" is in the list
        WebOrderUtils.verifyOrder(driver, "Mark Smith");
    }


}
