package com.BriteERP.Tests.components.login_navigation;

import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests {

    @Test
    public void loginTest1(){
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
     //   LoginPage loginPage = new LoginPage();

   //     String username = ConfigurationReader.getProperty("storemanagerusername");
   //     String password = ConfigurationReader.getProperty("storemanagerpassword");

  //      loginPage.login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
  //      Assert.assertEquals(BriteErpUtils.getPageSubTitle(), "Dashboard");
    }

    @Test
    public void negativeLoginTest1(){
 //       LoginPage loginPage = new LoginPage();

 //       loginPage.login("wrongusername", "wrongpassword");

    }


}

