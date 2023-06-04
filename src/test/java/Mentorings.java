import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Mentorings {
    @Test
    public void Test2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        WebElement table= driver.findElement(By.xpath("//a[.='Table Pagination']"));
        table.click();

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropdown, "0", "index");

        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails=driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String, String> map=new TreeMap<>();
        for(int i=0;i<allNames.size();i++){
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            System.out.println("Map = " + map);
        }



    }

    @Test
    public void Test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        WebElement table= driver.findElement(By.xpath("//a[.='Table Pagination']"));
        table.click();

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropdown, "5000", "value");

        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allPhoneNumber=driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String, Long> map=new TreeMap<>();
        for(int i=0;i<allNames.size();i++){
            Thread.sleep(2000);
            map.put(BrowserUtils.getText(allNames.get(i)), Long.parseLong(BrowserUtils.getText(allPhoneNumber.get(i)).replace("-", "")));

        }System.out.println("Map = " + map);



    }
}
