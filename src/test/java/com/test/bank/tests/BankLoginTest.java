package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest extends BankTestBase {


    @Test
    public void ValidateLoginPageComponents(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver =new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.LoginPageComponentValidation("XYZ Bank");
        bankLoginPage.clickManagerButton();

    }
}
