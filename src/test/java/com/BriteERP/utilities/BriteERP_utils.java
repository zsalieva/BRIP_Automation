package com.BriteERP.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BriteERP_utils {
    //we don't want to access these variables outside

    private static String loaderMaskLocator = "div[class='loader-mask shown']";
    private static String pageSubTitleLocator = "h1[class='oro-subtitle']";
    //we don't want to access these variables outside
    private static String usernamelocator = "login";
    private static String passwordLocator = "password";


    /**
     * Login into vytrack application
     * @param driver
     * @param username
     * @param password
     */
    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(usernamelocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(3);
    }


    /**
     *  This method will put on pause execution
     * @param seconds
     */
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
//**********************************************************************************************//

    WebDriver driver = Driver.getDriver();
    String actionButtonLocator = "//button[contains(text(),'Action')]";
    String okLocator = "//span[text()='Ok']";

    WebDriverWait wait = new WebDriverWait(driver, 10);

    /**
     * Select opportunity based on opportunity title
     * @param opportunity
     */
    public void selectOpportunity(String opportunity){
        String locator = "//td[text()='"+opportunity+"']/preceding-sibling::td//input";
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * Method that deletes opportunity based on opportunity title
     * @param opportunity
     */
    public void deleteOpportunity(String opportunity){
        selectOpportunity(opportunity);
        selectAction("Delete");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(okLocator)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(okLocator))));
        driver.findElement(By.xpath(okLocator)).click();
    }

    /**
     * Method that selects action for opportunity
     * @param actionName
     */
    public void selectAction(String actionName){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actionButtonLocator))));
        driver.findElement(By.xpath(actionButtonLocator)).click();
        String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'"+actionName+"')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(optionLocator))));
        driver.findElement(By.xpath(optionLocator)).click();
    }

    /**
     * Based on opportunity title this method will verify that there is no cell with a given text
     * @param opportunity
     */
    public void verifyThatOpportunityDeleted(String opportunity){
        String locator = "//td[text()='"+opportunity+"']";
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        Assert.assertTrue(elements.isEmpty());

    }





//*********************************************************************************************//
    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param driver
     * @param tab
     * @param module
     */
    public static void navigateToModule(WebDriver driver, String module){

        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'oe_menu_text')]";
//        driver.findElement(By.xpath(tabLocator)).click();

        driver.findElement(By.xpath(moduleLocator)).click();

//        SeleniumUtils.clickWithWait(driver, By.xpath(moduleLocator), 5);

//        SeleniumUtils.waitPlease(2);
    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     *
     * @param tab
     * @param module
     */
    public static void navigateToModule(String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'title title-level-2')]";
        SeleniumUtils.clickWithWait(Driver.getDriver(), By.xpath(tabLocator), 5);
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     * @param driver
     */
    public static void waitUntilLoaderScreenDisappear(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));
        }catch (Exception e){
            System.out.println(e+" :: Loader mask doesn't present.");
        }
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     *
     */
    public static void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
        }catch (Exception e){
            System.out.println("Loader mask doesn't present.");
        }
    }

    /**
     *
     * @return page name, for example: Dashboard
     */
    public static String getPageSubTitle(){
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear(Driver.getDriver());
        return Driver.getDriver().findElement(By.cssSelector(pageSubTitleLocator)).getText();
    }
}




