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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCars() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");
/*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

        WebElement newused = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newused, "New", "text");

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "lexus", "value");

        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");

        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceofTheCar = new Select(price);
        Assert.assertEquals(BrowserUtils.getText(priceofTheCar.getFirstSelectedOption()), "No max price");

        WebElement mileage = driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(mileage, "40 miles", "text");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");

        WebElement button = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        button.click();

        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        Assert.assertEquals(BrowserUtils.getText(header), "New Lexus RX 350 for sale");

        WebElement sort = driver.findElement(By.cssSelector("#sort-dropdown"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(sort, "Lowest price", "text");
        Thread.sleep(2000);

        List<WebElement> carList = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title : carList) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));

            List<WebElement> Price = driver.findElements(By.cssSelector(".primary-price"));
            List<Integer> ActualCarPrice =new ArrayList<>();
            List<Integer> ExpectedCarPrice = new ArrayList<>();
            Thread.sleep(2000);

            for(int i =0; i<Price.size();i++){
                String CarPrice= BrowserUtils.getText(Price.get(i)).replace("$","").replace(",","");
                ActualCarPrice.add(Integer.parseInt(CarPrice));
                ExpectedCarPrice.add(Integer.parseInt(CarPrice));
            }
            Collections.sort(ExpectedCarPrice);
            Assert.assertEquals(ActualCarPrice,ExpectedCarPrice);

        }

        BrowserUtils.selectBy(sort, "Highest price", "text");
        Thread.sleep(2000);

        List<WebElement> carList1 = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title : carList1) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));

            List<WebElement> Price = driver.findElements(By.cssSelector(".primary-price"));
            List<Integer> ActualCarPrice =new ArrayList<>();
            List<Integer> ExpectedCarPrice = new ArrayList<>();
            Thread.sleep(2000);

            for(int i =0; i<Price.size();i++){
                String CarPrice= BrowserUtils.getText(Price.get(i)).replace("$","").replace(",","");
                ActualCarPrice.add(Integer.parseInt(CarPrice));
                ExpectedCarPrice.add(Integer.parseInt(CarPrice));
            }
            Collections.sort(ExpectedCarPrice);
            Collections.reverse(ExpectedCarPrice);
            Assert.assertEquals(ActualCarPrice,ExpectedCarPrice);
            Thread.sleep(2000);
            driver.quit();
        }


    }
}










