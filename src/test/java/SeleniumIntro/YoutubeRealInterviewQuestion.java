package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");

        //song.sendKeys(Keys.ARROW_DOWN)
        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("justin bieber");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> allsongs= driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song:allsongs){
            if(song.getAttribute("title").equals("Justin Bieber - What Do You Mean?")){
              Thread.sleep(500);
              song.sendKeys(Keys.ARROW_DOWN);
              song.click();
              break;
            }
        }


















    }
}
