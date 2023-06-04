package GetWindowHandle;

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

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPageID=driver.getWindowHandle();
        Set<String> allPages=driver.getWindowHandles();
        for(String id: allPages){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Kickstart ");
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());
    }

    @Test
    public void RealTask(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

                        /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */

        WebElement button= driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button);
        button.click();

        BrowserUtils.switchByTitle(driver,"Basic");
        WebElement firstName= driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Melek");
        WebElement lastName= driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("kokal");
        WebElement gender= driver.findElement(By.cssSelector("#femalerb"));
        BrowserUtils.scrollWithJS(driver,gender );
        gender.click();
        WebElement language= driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        WebElement email=driver.findElement(By.cssSelector("#email"));
        email.sendKeys("melek@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("melek123");
        WebElement registerButton=driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.scrollWithJS(driver,registerButton );
        registerButton.click();

        WebElement message=driver.findElement(By.cssSelector("#msg"));
        Assert.assertEquals(BrowserUtils.getText(message),"Registration is Successful");

        BrowserUtils.switchByTitle(driver,"Window");
        String actualTitleofWindowHandle=driver.getTitle();
        String expectedTitle="Window Handles Practice - H Y R Tutorials";
        Assert.assertEquals(actualTitleofWindowHandle,expectedTitle);

        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement promptBoxButton=driver.findElement(By.cssSelector("#promptBox"));
        //driver.close(); will close only the page you're on.
        promptBoxButton.click();
        driver.quit();



    }


}
