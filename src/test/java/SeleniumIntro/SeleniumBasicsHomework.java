package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasicsHomework {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.kahoot.it/");
        System.out.println(driver.getTitle());

        String actualtitle= driver.getTitle();
        String expectedtitle="Enter Game PIN - Kahoot!";
        System.out.println(actualtitle.equals(expectedtitle) ? "KAHOOT PASSED" : " KAHOOT FAILED");

        String actualurl=driver.getCurrentUrl();
        String expectedurl="https://kahoot.it/";
        System.out.println(actualurl.equals(expectedurl) ? "KAHOOT PASSED" : "KAHOOT FAILED");

        System.out.println("------------------");

        driver.get("https://www.netflix.com/");
        System.out.println(driver.getTitle());

        String actualtitlen=driver.getTitle();
        String expectedtitlen="Netflix - Watch TV Shows Online, Watch Movies Online";
        System.out.println(actualtitlen.equals(expectedtitlen) ? "NETFLIX PASSED" : "NETFLIX FAILED");

        String actualurln= driver.getCurrentUrl();
        String expectedurln="https://www.netflix.com/";
        System.out.println(actualurln.equals(expectedurln) ? "NETFLIX PASSED" : "NETFLIX FAILED");

        System.out.println("------------------");

        driver.get("https://samedaycabinets.com/");
        System.out.println(driver.getTitle());

        String actualtitles= driver.getTitle();
        String expectedtitles="Wholesale Cabinets | Springfield VA | Bathroom & Kitchen Cabinets";
        System.out.println(actualtitles.equals(expectedtitles) ? "SAME DAY PASSED" : "SAME DAY FAILED");

        String actualurls=driver.getCurrentUrl();
        String expectedurls="https://samedaycabinets.com/";
        System.out.println(actualurls.equals(expectedurls) ? "SAME DAY PASSED" : "SAME DAY FAILED");

        driver.close();




    }
}
