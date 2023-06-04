package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        //RELATIVE XPATH
        WebElement abTesting=driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTesting.click();
        //ABSOLUTE XPATH
        WebElement header= driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());

        WebElement paragraph=driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

        WebElement elemental=driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        elemental.click();



    }
}
