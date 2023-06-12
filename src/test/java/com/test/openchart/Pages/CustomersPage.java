package com.test.openchart.Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomersPage {
    public void CustomersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='float-end']//a")
    WebElement addNewButton;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement passwordConfirm;

    @FindBy(xpath = "//input[@id='input-newsletter']")
    WebElement newsletter;

    @FindBy(xpath = "//input[@id='input-status']")
    WebElement status;

    @FindBy(xpath = "//input[@id='input-safe']")
    WebElement safe;

    @FindBy(xpath = "//button[@data-bs-original-title='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//div[@id='alert']")
    WebElement warning;

    public void CustomersPageComponentFunctionality(String firstName, String lastName, String email, String password, String passwordConfirm) throws InterruptedException {
        Thread.sleep(2000);
        addNewButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(passwordConfirm);
        Assert.assertTrue(newsletter.isEnabled() && !newsletter.isSelected());
        newsletter.click();
        Assert.assertTrue(status.isEnabled() && !status.isSelected());
        status.click();
        Assert.assertTrue(safe.isEnabled() && !safe.isSelected());
        safe.click();
        saveButton.click();

    }

    public String errorMessage(){
        return BrowserUtils.getText(warning);
    }

}
