package SeleniumLocators.SeleniumHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement userName= driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Melek Kokal");
        WebElement userEmail= driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("melek@gmail.com");
        WebElement currentAddres=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddres.sendKeys("123 Mel St");
        WebElement permanentAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("456 Mel Pl");
        WebElement button=driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(2000);
        button.click();

        System.out.println(userName.isDisplayed() ? "Passed" : "Failed");
        System.out.println(userEmail.isDisplayed() ? "Passed" : "Failed");
        System.out.println(currentAddres.isDisplayed() ? "Passed" : "Failed");
        System.out.println(permanentAddress.isDisplayed() ? "Passed" : "Failed");


    }
}
