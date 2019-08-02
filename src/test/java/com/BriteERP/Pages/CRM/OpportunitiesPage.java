package com.BriteERP.Pages.CRM;

import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
    WebDriver driver = Driver.getDriver();


    @FindBy (xpath="//span[contains(text(),'CRM')][1]")
    public WebElement CRM_btn;

    @FindBy (xpath="//button[@aria-label='list']")
    public WebElement ClickList;

    @FindBy (xpath="//button[@aria-label='pivot']")
    public WebElement ClickPivot;

    @FindBy (xpath="//table//tbody//tr[2]//td[9]")
    public WebElement listView;

    @FindBy (xpath="//table//tbody//tr[4]//td[2]")
    public WebElement pivotView;

    @FindBy (xpath="//table//tbody//tr[3]//td[2]")
    public WebElement pivotView1;

    @FindBy (xpath="//table//tbody//tr[5]//td[2]")
    public WebElement pivotView2;

    @FindBy (xpath="//table//tbody//tr[1]//td[2]")
    public WebElement totalAmount;

    @FindBy (xpath="//table//tbody//tr[2]//td[1]")
    public WebElement newButton;

    @FindBy (xpath="//a[contains(text(),'Opportunity')]")
    public WebElement opportunity;



    public OpportunitiesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void openListView(){
        ClickList.click();
    }


    public String getListData(){
        return listView.getText();
    }


    public void openPivotView(){
        ClickPivot.click();
        SeleniumUtils.waitPlease(5);
        newButton.click();
        SeleniumUtils.waitPlease(5);
        opportunity.click();

    }

    public String getPivotData(){
        return pivotView.getText();
    }


    public double findTotal(){

        double a = Double.parseDouble(pivotView.getText().replaceAll(",",""));

        double b = Double.parseDouble(pivotView1.getText().replaceAll(",",""));

        double c = Double.parseDouble(pivotView2.getText().replaceAll(",",""));


        return a+b+c;
    }


    public double getTotalData(){

        double sum =Double.parseDouble(totalAmount.getText().replaceAll(",",""));

        return sum;
    }










}