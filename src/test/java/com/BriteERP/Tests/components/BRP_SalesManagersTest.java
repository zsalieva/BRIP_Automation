package com.BriteERP.Tests.components;
import com.BriteERP.utilities.BriteERP_utils;
import com.BriteERP.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BRP_SalesManagersTest {



    //Project:         BRP Aplication?
    //Prog language:   Java HTML
    //Concept:        Polimorphisim
    //Tools :         Selenium,Maven,Test_NG
    // ID:            Inteliji
    //WebBrowser:      ChromeDriver
    //The Methodology  Scrum Agile/ Waterfall

    WebDriver driver;
    //  Step 1	Go to website
    //  Step 2	Login with valid credidentials
    //Step 3	Click on login
    // Step 4	Click on sales
    //Step 5	Click on first item in the list
    //Step 6	item details will be displayed


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //Call chrome driver
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //implicit wait
        driver.manage().window().maximize();
        // full screen while the application running
        driver.get("http://34.220.250.213/web/login");
        //invironment link

    }
    @Test
    public void salesTest()throws Exception{
        String excpected ="SO812 - Odoo";
        // Expected Result
        BriteERP_utils.login(driver,"salesmanager10@info.com","salesmanager");
        //Login method called from BRP_utils class
        SeleniumUtils.waitPlease(2);
        // Call wait method from Selenium_utils class

        driver.findElement(By.xpath("//span[contains(text(),'Sales') and contains (@class ,'oe_menu_text')]")).click();
        //xpath to click sales
        SeleniumUtils.waitPlease(2);
        // Call wait method from Selenium_utils class

        driver.findElement(By.xpath("//td[contains(text(),'SO812') and contains( @class ,'o_data_cell o_readonly_modifier o_required_modifier')]")).click();

        SeleniumUtils.waitPlease(2);
        // Call wait method from Selenium_utils class
        String actual =driver.getTitle();
        //get actual result
        Assert.assertEquals(excpected,actual);
        //Asserts compares the excpected with actual.
        System.out.println("Test Passed ! /SO812 displayed");
        //Print put on Console
        SeleniumUtils.waitPlease(2);
        // Call wait method from Selenium_utils class

    }

    @AfterMethod
    public void teardown(){     //driver.quit method will close all running browser once done.
        driver.quit();          //driver.close will close only current browser.
    }


}


