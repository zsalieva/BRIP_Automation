package com.BriteERP.Tests.components;
import com.BriteERP.utilities.BriteERP_utils;
import com.BriteERP.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class BRP_CRM_Test {


        //Project:         BRP Aplication?
        //Prog language:   Java HTML
        //Concept:        Polimorphisim/
        //Tools :         Selenium,Maven,Test_NG
        // IDE:            Inteliji
        //WebBrowser:      ChromeDriver
        //The Methodology  Scrum Agile/ Waterfall

        String listOfOpportunities= "div[class='table-responsive']";  //All needed locators been created here
        String CRM_locator ="//span[contains(text(),'CRM')][1]";
        String ListLocator ="button[aria-label='list']";
        String First_Opportunity ="td[width='1'] ";
        String Action_locator ="//button[contains(text(),'Action')]";

        WebDriver driver;

        @BeforeMethod
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://34.220.250.213/web/login");
        }
        @Test   // First Acceptance Criteria:
        // Verify that user should able to see the list view
        //1.Login
        //2.home page
        //3. select CRM
        //4.  Select the list view

        public void CRM_List_View_Test_1() {

            BriteERP_utils.login(driver, "eventscrmmanager15@info.com", "eventscrmmanager");
            driver.findElement(By.xpath(CRM_locator)).click();
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.cssSelector(ListLocator)).click();

            driver.findElement(By.cssSelector(First_Opportunity)).click();
            driver.findElement(By.cssSelector(listOfOpportunities)).isDisplayed();
            SeleniumUtils.waitPlease(3);
            String excpected= "Pipeline - Odoo";     // Expected and Actual comparison

            String actual= driver.getTitle();
            Assert.assertEquals(actual,excpected);
            System.out.println("Test passed,List of Opportunities is displayed");
            SeleniumUtils.waitPlease(2);

        }
        @Test   // Second Acceptance Criteria:
        // verify that user should able to delete the opportunity from doropDownList.

        public void Delete_Option_DropDown_Test2() {



            BriteERP_utils.login(driver, "eventscrmmanager15@info.com", "eventscrmmanager");
            driver.findElement(By.xpath(CRM_locator)).click();
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.cssSelector(ListLocator)).click();

            driver.findElement(By.cssSelector(First_Opportunity)).click();
            SeleniumUtils.waitPlease(2);


            driver.findElement(By.xpath(Action_locator)).click();
            // BRP_Utils.waitPlease(driver);
            SeleniumUtils.waitPlease(2);



            WebElement delete = driver.findElement(By.xpath("//a[@data-index='3']"));
            String expected = driver.findElement(By.xpath("//a[@data-index='3']")).getText();
            Actions action = new Actions(driver);
            Collection<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul"));

            for (WebElement option : options) {
                // action.contextClick(delete).perform();
                action.doubleClick(delete).perform();
                SeleniumUtils.waitPlease(5);
            }

            driver.findElement(By.xpath("//span[text()='Ok']")).click();
            SeleniumUtils.waitPlease(5);
            // BRP_Utils.waitPlease(driver);


            Actions action1 = new Actions(driver);
            Collection<WebElement> newOptions = driver.findElements(By.xpath("//td[@class='o_data_cell o_required_modifier']"));
            for (WebElement option1 : newOptions) {
                System.out.println(option1.getText());

            }

            // System.out.println(newOptions.contains(expected));
            Assert.assertEquals(options, newOptions);
            System.out.println("Passed not matching!!!");
        }


        @AfterMethod
        public void teardown() {
            driver.quit();
        }
    }


