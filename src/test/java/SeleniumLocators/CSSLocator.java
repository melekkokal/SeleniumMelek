package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement searchBar=driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("watch");
        WebElement search= driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn" +
                "                "));
        search.click();

        String url=driver.getCurrentUrl();
        String expectedurl="https://www.etsy.com/search?q=watch&ref=search_bar";
        System.out.println(url.equals(expectedurl) ? "PASSED" : "FAILED");







    }
}
