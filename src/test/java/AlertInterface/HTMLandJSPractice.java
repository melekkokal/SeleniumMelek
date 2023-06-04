package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLandJSPractice {
    @Test
    public void practiceboth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        //JS Alert
        WebElement normalAlert= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        normalAlert.click();
        Alert alert=driver.switchTo().alert();
        String text= alert.getText().trim();
        System.out.println(text);
        alert.accept();

        //HTML Alert
        WebElement sweetAlert=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        sweetAlert.click();
        Thread.sleep(2000);
        WebElement message= driver.findElement(By.xpath("//div[@class='swal-modal']"));
        System.out.println(BrowserUtils.getText(message));
        String actualMessage=BrowserUtils.getText(message);
        String expextedMessage="Something went wrong";
        Assert.assertTrue(actualMessage.contains(expextedMessage));
        WebElement okbutton= driver.findElement(By.xpath("//button[.='OK']"));
        okbutton.click();

        driver.quit();
    }
}
