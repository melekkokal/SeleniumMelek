package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/melekkokal/Desktop/usa.png");
        WebElement uploadButton=driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        WebElement header= driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(header), "usa.png");
    }

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement chooseFile= driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/melekkokal/Desktop/usa.png");

        WebElement title= driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        Assert.assertEquals(BrowserUtils.getText(title), "Select file to send(max 196.45 MB)");
        WebElement box= driver.findElement(By.cssSelector("#terms"));
        if(box.isDisplayed() && !box.isSelected() && box.isEnabled()){
            box.click();
        }

        WebElement submit= driver.findElement(By.cssSelector("#submitbutton"));
        submit.click();

        Thread.sleep(2000);
        WebElement message= driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(message), "1 file\n" +
                "has been successfully uploaded.");

    }
}
