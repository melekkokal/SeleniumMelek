package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.utils.OsgiUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/melekkokal/Downloads/Techtorial.html");


        WebElement countryBox= driver.findElement(By.xpath("//select[@name='country']"));
        Select country=new Select(countryBox);
        String actualFirstOption=country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="UNITED STATES ".trim();
        Assert.assertEquals(actualFirstOption, expectedFirstOption);

        List<WebElement> options1=country.getOptions();
        int counter=0;
        for(int i =0; i<options1.size();i++){
            System.out.println(options1.get(i).getText().trim());
            counter++;
        }
        System.out.println(counter);

        country.selectByVisibleText("TURKEY ");
        Thread.sleep(2000);
        country.selectByValue("200");
        Thread.sleep(2000);
        country.selectByIndex(96);
        Thread.sleep(2000);



    }
}
