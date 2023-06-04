package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {

    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement passengerCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passengerCount);
        passenger.selectByValue("4");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select from = new Select(departingFrom);
        String actualDefault = from.getFirstSelectedOption().getText().trim();
        String expectedDefault = "Acapulco";
        Assert.assertEquals(actualDefault, expectedDefault);
        from.selectByVisibleText("Paris");
        Thread.sleep(2000);

        WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select month = new Select(date);
        month.selectByVisibleText("August");
        Thread.sleep(2000);

        WebElement date1 = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select day = new Select(date1);
        day.selectByValue("15");
        Thread.sleep(2000);

        WebElement arrivingTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select to = new Select(arrivingTo);
        to.selectByVisibleText("San Francisco");
        Thread.sleep(2000);

        WebElement returningDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returningdate = new Select(returningDate);
        returningdate.selectByVisibleText("December");
        Thread.sleep(2000);

        WebElement returningDate1 = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningdate1 = new Select(returningDate1);
        returningdate1.selectByValue("15");
        Thread.sleep(2000);

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        Thread.sleep(2000);

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select options1 = new Select(airline);
        List<WebElement> actualOptions = options1.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualOptions.size(); i++) {
            Assert.assertEquals(actualOptions.get(i).getText().trim(), expectedOptions.get(i).trim());
        }

        options1.selectByVisibleText("Unified Airlines");
        Thread.sleep(2000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "After flight finder - No Seats Available";
        Assert.assertEquals(actualHeader, expectedHeader);
        Thread.sleep(2000);

    }


    public class shortcut {

        @Test
        public void validateOrderMessage() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

            WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
            oneWay.click();

            WebElement passengerCount = driver.findElement(By.xpath("//select[@name='passCount']"));
            BrowserUtils.selectBy(passengerCount, "4", "value");

            WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
            Select from = new Select(departingFrom);
            String actualDefault = from.getFirstSelectedOption().getText().trim();
            String expectedDefault = "Acapulco";
            Assert.assertEquals(actualDefault, expectedDefault);
            BrowserUtils.selectBy(departingFrom, "Paris", "text");

            WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
            BrowserUtils.selectBy(date, "August", "text");

            WebElement date1 = driver.findElement(By.xpath("//select[@name='fromDay']"));
            BrowserUtils.selectBy(date1, "15", "value");

            WebElement arrivingTo = driver.findElement(By.xpath("//select[@name='toPort']"));
            BrowserUtils.selectBy(arrivingTo, "San Francisco", "text");

            WebElement returningDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
            BrowserUtils.selectBy(returningDate, "December", "text");

            WebElement returningDate1 = driver.findElement(By.xpath("//select[@name='toDay']"));
            BrowserUtils.selectBy(returningDate1, "15", "value");

            WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
            serviceClass.click();
            Thread.sleep(2000);

            WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
            Select options1 = new Select(airline);
            List<WebElement> actualOptions = options1.getOptions();
            List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
            for (int i = 0; i < actualOptions.size(); i++) {
                Assert.assertEquals(BrowserUtils.getText(actualOptions.get(i)), expectedOptions.get(i).trim());
            }

            options1.selectByVisibleText("Unified Airlines");
            WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
            continueButton.click();


            WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
            String actualHeader = header.getText().trim();
            String expectedHeader = "After flight finder - No Seats Available";
            Assert.assertEquals(actualHeader, expectedHeader);
            Thread.sleep(2000);

        }
    }
}
