package com.BriteERP.Pages.login_navigation;

import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id = "login")
    public WebElement userNameElement;

    @FindBy(name = "password")
    public WebElement passwordElement;

    @FindBy(xpath="//button[contains(text(),'Log in')]")
    public WebElement loginButtonElement;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }





}

