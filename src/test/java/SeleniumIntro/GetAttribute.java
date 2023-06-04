package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment= driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppointment.click();
        WebElement name=driver.findElement(By.cssSelector("//input[@value='John Doe']"));
        System.out.println(name.getText());
        System.out.println(name.getAttribute("//input[@value='ThisIsNotAPassword']")); //John Doe
        System.out.println(name.getAttribute("type")); //text

    }
}
