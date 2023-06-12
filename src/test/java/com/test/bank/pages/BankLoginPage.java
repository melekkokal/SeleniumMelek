package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this); //It does the same logic of driver.findElement
    }
    @FindBy(css =".mainHeading")
    WebElement header;  //instance variable.

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homePagebutton;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;

    public void LoginPageComponentValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed() && bankManagerLogin.isEnabled());
        Assert.assertTrue(bankManagerLogin.isDisplayed() && customerLogin.isEnabled());

    }

    public void clickManagerButton(){
        bankManagerLogin.click();
    }

    public void clickHomeButton(){
        homePagebutton.click();
    }
    public void clickCustomerButton() {
        customerLoginButton.click();
    }


}
