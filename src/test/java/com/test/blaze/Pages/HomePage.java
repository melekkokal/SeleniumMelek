package com.test.blaze.Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    /*
    1-Navigate to the website "https://www.demoblaze.com/#"
    2-Click the Laptops by using the logic that if the element text is Laptops then click it.(loop)
    3-Click MacBook Pro from the list with Loop(LaptopPage)
    4-Validate the header="MacBook Pro"(MacBook Pro Page)
    5-Validate the price=$1100 *includes tax(MacBook Pro Page)
    6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multi-touchstrip display that sits above the MacBook Pro's keyboard."
    7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button(MacBook Pro Page)
     */
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='cat']")
    WebElement categoriesButton;

    @FindBy(xpath = "//a[@id='itemc']")
    WebElement getElements;

    @FindBy(partialLinkText = "Phones")
    WebElement phones;

    @FindBy(partialLinkText = "Laptops")
    WebElement laptops;

    @FindBy(partialLinkText = "Monitors")
    WebElement monitors;

    @FindBy(xpath = "//div//h4")
    WebElement getLaptops;


    public void CategoriesFunctionality(String element){
        List<WebElement> getElements=new ArrayList<>();
        for(int i=0; i<getElements.size(); i++){
            if(getElements.get(i).equals(element)){
                this.getElements.click();
                break;
            }else if(getElements.get(i).equals(element)){
                this.getElements.click();
                break;
            }else if (getElements.get(i).equals(element)){
                this.getElements.click();
                break;
            }
        }
        List<WebElement> getLaptops=new ArrayList<>();
        for(WebElement Laptops:getLaptops){
            if(BrowserUtils.getText(Laptops).equals("MacBook Pro")){
                Laptops.click();
                break;
            }
        }
        }
    }
