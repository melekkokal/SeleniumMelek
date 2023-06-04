package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/melekkokal/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR
        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader= driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "PASSED" : "FAILED");

        /* TASK
        1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
        2-Go back to the main page
        3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
        4-Go back to the main page
        5-Click TestNG and validate(ternary) header -->TestNG
        6-Go back to the main page
        7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
        */
        driver.navigate().back();
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualHeader1=seleniumHeader.getText().trim();
        String expectedHeader1="Selenium automates browsers. That's it!";
        System.out.println(actualHeader1.equals(expectedHeader1) ? "Selenium PASSED" : "Selenium Failed");
        driver.navigate().back();
        WebElement cucumberlink=driver.findElement(By.linkText("Cucumber"));
        cucumberlink.click();
        WebElement cucumberHeader= driver.findElement(By.tagName("h1"));
        String actualHeader2= cucumberHeader.getText().trim();
        String expectedHeader2="Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeader2.equals(expectedHeader2) ? "Cucumber PASSED" : "Cucumber FAILED");

        driver.navigate().back();
        WebElement testnglink=driver.findElement(By.linkText("TestNG"));
        testnglink.click();
        WebElement testngheader=driver.findElement(By.tagName("h2"));
        String actualheader3=testngheader.getText().trim();
        String expectedheader3="TestNG";
        System.out.println(actualheader3.equals(expectedheader3) ? "TestNG PASSED" : "TestNG FAILED");

        //LOCATOR PARTIALLINKTEXT:
        driver.navigate().back();
        WebElement restapilink=driver.findElement(By.partialLinkText("Rest"));
        restapilink.click();

        driver.quit();







    }
}
