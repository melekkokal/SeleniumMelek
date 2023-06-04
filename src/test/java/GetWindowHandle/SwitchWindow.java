package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver chromeDriverdriver=new ChromeDriver(options);
        chromeDriverdriver.manage().window().maximize();
        chromeDriverdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriverdriver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=chromeDriverdriver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header=chromeDriverdriver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        System.out.println(chromeDriverdriver.getWindowHandle()); //Gets you main pageID --> The internet.
        //7925132B7247631A7247333DE7D2C67A -->mainPageID. It changes everytime you run it.
        String mainPageID=chromeDriverdriver.getWindowHandle();
        Set<String> allPagesID=chromeDriverdriver.getWindowHandles(); //returns getWindowHandles List.
        for(String id : allPagesID){
            if(!id.equals(mainPageID)){
                chromeDriverdriver.switchTo().window(id);
                break;
            }

        }
        header=chromeDriverdriver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

    }


    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement tabButton = driver.findElement(By.cssSelector("#newTabBtn"));
        tabButton.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();

        for (String ids: allPagesId){
            if(!ids.equals(mainPageId)){
                driver.switchTo().window(ids);break;
            }
        }

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement alertDemoText = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualText = BrowserUtils.getText(alertDemoText);
        String expectedText = "AlertsDemo";
        Assert.assertEquals(actualText,expectedText);

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
    }
}
