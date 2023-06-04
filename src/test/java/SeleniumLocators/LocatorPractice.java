package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
         /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the URL. //actual-expected comparison.
11-Close the webpage
Try your own logic and automate it without any help.
     */

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Melek");
        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("Kokal");
        WebElement gender= driver.findElement(By.id("sex-1"));
        gender.click();
        WebElement years=driver.findElement(By.id("exp-0"));
        years.click();
        WebElement profession=driver.findElement(By.id("profession-1"));
        profession.click();
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("03/07/1996");
        WebElement tools=driver.findElement(By.id("exp-0"));
        tools.click();
        WebElement tools1=driver.findElement(By.id("tool-1"));
        tools1.click();
        WebElement tools2=driver.findElement(By.id("tool-2"));
        tools2.click();
        WebElement continents=driver.findElement(By.id("continents"));
        continents.sendKeys("Asia");

        Thread.sleep(2000);
        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "PASSED" : "FAILED");

        Thread.sleep(2000);

        driver.close();


    }
}
