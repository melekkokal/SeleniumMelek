package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {

    @Test
    public void ValidateAddCustomerFunctionality() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Melek", "Kokal", "20111", "Customer added successfully with customer id");
    }


    @Test
    public void ValidateOpenAccountFunctionality() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver =new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Melek", "Kokal",
                "20111", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Melek Kokal", "Dollar",
                "Account created successfully with account Number");
    }


    @Test
    public void ValidateCustomerInformation() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver =new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Melek", "Kokal",
                "20111", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Melek Kokal", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Melek","Kokal", "20111" );
    }




}
