package SeleniumLocators.SeleniumHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button=driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

        String currenturl=driver.getCurrentUrl();
        String expectedurl= "https://www.saucedemo.com/inventory.html";
        System.out.println(currenturl.equals(expectedurl) ? "URL MATCHES" : "URL DOESN'T MATCH");

        Thread.sleep(2000);
        driver.quit();


    }
}
