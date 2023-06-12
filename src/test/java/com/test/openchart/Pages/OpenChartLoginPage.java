package com.test.openchart.Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//input[@id='input-username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css="#alert")
    WebElement errorMessage;

    @FindBy(tagName ="title")
    WebElement title;

    public void LoginFunctionality(String userName,String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();Thread.sleep(2000);
    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
