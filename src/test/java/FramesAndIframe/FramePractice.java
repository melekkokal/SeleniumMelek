package FramesAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class FramePractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");

        WebElement box= driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I LOVE SELENIUM");
        driver.switchTo().parentFrame();
        header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice1() throws InterruptedException {
        /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");


        WebElement pavillion= driver.findElement(By.linkText("Pavilion"));
        pavillion.click();

        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        Actions actions= new Actions(driver);
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(selenium).perform();
        WebElement seleniumPython = driver.findElement(By.linkText("Selenium-Python"));
        seleniumPython.click();

        WebElement header=driver.findElement(By.xpath("//div[@class='page-title-head hgroup']"));
        Assert.assertEquals(BrowserUtils.getText(header),"Selenium-Python Tutorial");

        List<WebElement>allLinks=driver.findElements(By.xpath("//p//a"));
        for(WebElement links:allLinks){
            System.out.println(BrowserUtils.getText(links));
        }



        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Framename1");

        WebElement category1button= driver.findElement(By.linkText("Category1"));
        category1button.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation" );
        WebElement header1= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header1), "Category Archives: SeleniumTesting");

        List<WebElement> headers=driver.findElements(By.tagName("//h3"));
        for(WebElement header2:headers){
            System.out.println(BrowserUtils.getText(header2));
        }

        /*
TASK 3:
TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */


        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement inframe=driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(inframe));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting");
        WebElement header3=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header3));

    }
}
