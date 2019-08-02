package com.BriteERP.Tests.components.CRM;

import com.BriteERP.Pages.CRM.OpportunitiesPage;
import com.BriteERP.Pages.login_navigation.LoginPage;
import com.BriteERP.utilities.BriteERP_utils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.SeleniumUtils;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpportunitiesTest extends TestBase {


    @Test                                            //Comparing Pivot table with List view
    public void verifyListAndPivot(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("eventscrmmanagerusername");
        String password = ConfigurationReader.getProperty("eventscrmmanagerpassword");
        loginPage.login(username, password);
        BriteERP_utils.waitUntilLoaderScreenDisappear();
        BriteERP_utils.navigateToModule(driver,"CRM");
        SeleniumUtils.waitPlease(5);
        OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
        opportunitiesPage.openListView();
        String expected = opportunitiesPage.getListData();
        SeleniumUtils.waitPlease(5);
        System.out.println(expected);
        opportunitiesPage.openPivotView();
        String actual=opportunitiesPage.getPivotData();
        SeleniumUtils.waitPlease(5);
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
    }
    @Test                                           //Positive TESTINIG
    public void verifyTotal(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("eventscrmmanagerusername");
        String password = ConfigurationReader.getProperty("eventscrmmanagerpassword");
        loginPage.login(username, password);
        BriteERP_utils.waitUntilLoaderScreenDisappear();
        BriteERP_utils.navigateToModule(driver,"CRM");
        SeleniumUtils.waitPlease(5);
        OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
        opportunitiesPage.openPivotView();
        SeleniumUtils.waitPlease(5);
        double expected =opportunitiesPage.findTotal();
        double actual =opportunitiesPage.getTotalData();
        System.out.println("actual:" + actual + "   expected: " + expected);
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void verifyNotTotal(){                     //Negative test .. will get  ScreenShot if fails
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("eventscrmmanagerusername");
        String password = ConfigurationReader.getProperty("eventscrmmanagerpassword");
        loginPage.login(username, password);
        BriteERP_utils.waitUntilLoaderScreenDisappear();
        BriteERP_utils.navigateToModule(driver,"CRM");
        SeleniumUtils.waitPlease(5);
        OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
        opportunitiesPage.openPivotView();
        SeleniumUtils.waitPlease(5);
        double expected =opportunitiesPage.findTotal();
        double actual =5000.00;                                       //  <-- WRONG DATA
        System.out.println("actual:" + actual + "   expected: " + expected);
        Assert.assertEquals(actual,expected);
    }
}