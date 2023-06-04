package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait times
        driver.get("file:///Users/melekkokal/Downloads/Techtorial.html");

        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']")); //you stored 4 elements here.
        for(WebElement box:allBoxes){
            if(box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                Thread.sleep(2000);
                box.click();
            }
        }


    }
}
