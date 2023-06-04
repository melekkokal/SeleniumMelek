package SeleniumLocators.SeleniumHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement button=driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

        WebElement error= driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]"));
        String actualerror=error.getText();
        String expectederror="Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualerror.equals(expectederror) ? "PASSED" : "FAILED");



    }
}
