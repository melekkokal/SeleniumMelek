package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*
TASK:
 1-Click homeButton from top(You can store in Manager Page or LoginPage)
 2-Click Customer Login
 3-Find Your name from the List
 4-Click Login
 5-Validate the "Welcome Your Name" from header
 6-Click Deposit and put 500
 7-Validate "Deposit Successful
 8-Click Withdrawl and put 300
 9-Validate "Transaction successful"
 10-Get the balance from the Customer Page(200)
 11-Click Transactions
 12-get the 500 and 300 from the table and substract them
 13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
 14-Quit the driver

 NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
 */
public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement nameList;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositTheAmountButton;

    @FindBy(xpath = "//span[contains(text(), 'Deposit Successful')]")
    WebElement depositmessage;

    @FindBy(xpath = "//button[contains(text(), 'Withdrawl')]")
    WebElement withdrawlButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawlAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawlNowButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement withdrawlMessage;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement remainderAmount;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositAmountAsNumber;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawlAmountAsNumber;

    public void CustomerLoginFunctionality(String name, String expectedHeader) {
        BrowserUtils.selectBy(nameList, name, "text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
    }

    public void CustomerAccountDepositFunctionality(String amount, String expectedMessage) throws InterruptedException {
        depositButton.click();
        this.depositAmount.sendKeys(amount);
        depositTheAmountButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(depositmessage), expectedMessage);
    }
    public void CustomerAccountWithdrawlFunctionality(String withdrawlAmount1, String expectedMessage) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(2000);
        this.withdrawlAmount.sendKeys(withdrawlAmount1);
        withdrawlNowButton.click();
        Assert.assertEquals(BrowserUtils.getText(withdrawlMessage), expectedMessage);
    }
    public void ValidateTransactionAmountFunctionality(String amounOfDeposit, String amountOfWithdrawl, String expectedRemainingBalance){
        transactionButton.click();
        int remainingBalance=Integer.parseInt(amounOfDeposit)-Integer.parseInt(amountOfWithdrawl);
        Assert.assertEquals(remainingBalance, Integer.parseInt(expectedRemainingBalance));
    }

}
