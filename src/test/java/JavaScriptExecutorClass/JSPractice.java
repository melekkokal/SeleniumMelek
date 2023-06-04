package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yes= driver.findElement(By.cssSelector("#yesRadio"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        System.out.println(js.executeScript("arguments[0].click()",yes));
        WebElement yes1= driver.findElement(By.cssSelector(".mt-3"));
        Assert.assertEquals(BrowserUtils.getText(yes1), "You have selected Yes");

        WebElement impressed=driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()", impressed);
        WebElement impressed1=driver.findElement(By.cssSelector(".mt-3"));
        Assert.assertEquals(BrowserUtils.getText(impressed1), "You have selected Impressive");

        WebElement no=driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertTrue(!no.isEnabled());

    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/home");
        JavascriptExecutor js= (JavascriptExecutor) driver;

        WebElement header= driver.findElement(By.xpath("//div[@class='learnworlds-main-text learnworlds-main-text-small learnworlds-element']"));
        js.executeScript("arguments[0].scrollIntoView(true)", header);
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(header), "Copyright © 2023");

        WebElement applyNow=driver.findElement(By.xpath("//a[@id='menuItem_1594985863854_2']"));
        js.executeScript("arguments[0].scrollIntoView(true)", applyNow);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click()", applyNow);

        List<WebElement> info=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> actualInfo= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        List<String> expected=new ArrayList<>();
        for(int i =0; i<info.size(); i++){
            expected.add(BrowserUtils.getText(info.get(i)));
            Assert.assertEquals(BrowserUtils.getText(info.get(i)), expected.get(i));
        }

    }

    @Test //with JS BrowserUtils
    public void practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/home");
        JavascriptExecutor js= (JavascriptExecutor) driver;

        WebElement header= driver.findElement(By.xpath("//div[@class='learnworlds-main-text learnworlds-main-text-small learnworlds-element']"));
        BrowserUtils.scrollWithJS(driver,header);
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(header), "Copyright © 2023");
                          //this part works as actualHeader.
        WebElement applyNow=driver.findElement(By.xpath("//a[@id='menuItem_1594985863854_2']"));
        BrowserUtils.scrollWithJS(driver, applyNow);
        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver, applyNow);
        Thread.sleep(1000);
        String actualTitle=BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);

        List<WebElement> info=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> actualInfo= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        List<String> expected=new ArrayList<>();
        for(int i =0; i<info.size(); i++){
            expected.add(BrowserUtils.getText(info.get(i)));
            Assert.assertEquals(BrowserUtils.getText(info.get(i)), expected.get(i));
        }

    }
}
