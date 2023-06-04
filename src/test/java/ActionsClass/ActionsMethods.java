package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethods {
    @Test //right click
    public void contextClick(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box= driver.findElement(By.xpath("//div[@class='example']//div[@id='hot-spot']"));
        Actions action=new Actions(driver); //we create Action object to use its methods.
        action.contextClick(box).perform(); //right click. perform means do it!


    }

    @Test
    public void practiceContextClick(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action=new Actions(driver);
        action.contextClick(rightClick).perform();


    }
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClick= driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
        Actions action=new Actions(driver);
        action.doubleClick(doubleClick).perform();



    }
}
