package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerTest extends BankTestBase {


    @Test
    public void ValidateCustomerLoginFunctionality() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver =new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Melek", "Kokal",
                "20111", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Melek Kokal", "Dollar",
                "Account created successfully with account Number");
        loginPage.clickHomeButton();
        Thread.sleep(1000);
        loginPage.clickCustomerButton();
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.CustomerLoginFunctionality("Melek Kokal", "Welcome Melek Kokal !!");
        customerPage.CustomerAccountDepositFunctionality( "500", "Deposit Successful");
        Thread.sleep(2000);
        customerPage.CustomerAccountWithdrawlFunctionality("300", "Transaction successful");
        Thread.sleep(2000);
        customerPage.ValidateTransactionAmountFunctionality("500", "300",
                "200");

    }


}
