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

import java.util.concurrent.TimeUnit;

public class BRP_CalendarTests {



    public class BRP_CalandarTest {

        //Project:         BRP Aplication?
        //Prog language:   Java HTML
        //Concept:        Polimorphisim/
        //Tools :         Selenium,Maven,Test_NG
        // IDE:            Inteliji
        //WebBrowser:      ChromeDriver
        //The Methodology  Scrum Agile/ Waterfall
        WebDriver driver;


        //Step1	Open the URL
        //Step2	Login with valid credidentials
        //Step3	click  Calander
        //Step4	Date window apears on the right
        //Steps5 Verify that Expanse Manager is Selected.



        @BeforeMethod
        public void setup(){

            WebDriverManager.chromedriver().setup();            //driver setup

            driver = new ChromeDriver();                       //to initialize driver
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//wait for 2 sec
            driver.manage().window().maximize();              // full window screen while running
            driver.get("http://34.220.250.213/web/login");    //invironment Link
            SeleniumUtils.waitPlease(2); // Call wait method from Swlwnium_utils class
        }

        @Test
        public void CalanderEvents(){
            // Call loginmethod from BRP_utils class
           BriteERP_utils.login(driver, "expensesmanager74@info.com", "expensesmanager");
            driver.findElement(By.xpath("//span[contains(text(),'Calendar') and contains(@class,'oe_menu_text')]")).click();
            SeleniumUtils.waitPlease(2); // Call wait method from Selenium_utils class
            boolean excpected = driver.findElement(By.xpath("//input[@type ='checkbox'][1]")).isSelected(); //Bolean expected check
            SeleniumUtils.waitPlease(2);  // Call wait method from Selenium_utils class
            boolean actual = Boolean.parseBoolean(driver.getTitle());
            Assert.assertEquals(excpected,actual); //Checking Actual with expected match
            System.out.println("Test passed");     //print out some notes on Console
            SeleniumUtils.waitPlease(2); // Call wait method from Selenium_utils class
        }






        @AfterMethod
        public void teardown(){
            driver.quit();     //driver.quit closess all chromes
        }







    }




}
