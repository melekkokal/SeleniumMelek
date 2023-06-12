package com.test.openchart.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    /*
  1-Click "X" button. (HomePage)
  2-CLick Customers from left side and click sub Customers button (still HomePage)
  3-Click + sign on the top right (CustomerPage)
  4-Fill all the blanks and enable NewsLetter,Status,Safe and CLick save button top left(CustomerPage)
  5-Validate message "Warning:You do not have permission to modify customers!" (Customer Test) -->call the method in here
  */
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement xButton;

    @FindBy(linkText = "Customers")
    WebElement customersButton;

    @FindBy(xpath = "//ul[@id='collapse-5']//a[.='Customers']")
    WebElement customersBtn;

    public void HomePageComponentFunctionality(WebDriver driver) throws InterruptedException {
        //Alert alert=driver.switchTo().alert();
        xButton.click();
        Thread.sleep(2000);
        customersButton.click();
        customersBtn.click();

    }

}
