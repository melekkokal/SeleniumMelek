package SoftAssertClass;

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
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertbox=driver.findElement(By.cssSelector("#alertBox"));
        alertbox.click();
        Alert alert=alert=driver.switchTo().alert();
        alert.accept();
        SoftAssert softAssert=new SoftAssert();
        WebElement message= driver.findElement(By.cssSelector("#output"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You selected alert popup";
        softAssert.assertEquals(actualMessage, expectedMessage);
      //  Assert.assertEquals(actualMessage,expectedMessage);

        Thread.sleep(2000);
        WebElement confirmBox= driver.findElement(By.xpath("//button[contains(@id,'confirmBox')]"));
        confirmBox.click();
        alert.dismiss();
        WebElement message1=driver.findElement(By.cssSelector("#output"));
        String actualConfirmMessage=BrowserUtils.getText(message1);
        String expectedConfirmMessage="You pressed Cancel in confirmation popup";
        softAssert.assertEquals(actualConfirmMessage,expectedConfirmMessage);

        Thread.sleep(2000);
        WebElement promptBox= driver.findElement(By.xpath("//button[contains(@id,'promptBox')]"));
        promptBox.click();
        alert.sendKeys("Melek");
        alert.accept();
        WebElement message2= driver.findElement(By.cssSelector("#output"));
        String actualPromptMessage=BrowserUtils.getText(message2);
        String expectedPromptMessage="You entered text Melek in propmt popup";
        softAssert.assertEquals(actualPromptMessage,expectedPromptMessage);
        softAssert.assertAll();


    }
}
