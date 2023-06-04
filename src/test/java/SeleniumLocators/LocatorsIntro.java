package SeleniumLocators;

import com.google.gson.stream.JsonToken;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//file:///Users/melekkokal/Downloads/Techtorial.html

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        //LOCATORS : is a way to locate(find) element and manipulate it.
        //ID Locator:

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //we're validating if the header is correct.
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("file:///Users/melekkokal/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header= driver.findElement(By.id("techtorial1")); //you find the driver with element.
        String actualheader=header.getText().trim(); //it gets the text from element.
        String expectedheader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualheader.equals(expectedheader) ? "PASSED" : "FAILED");
        //TASK Find and print the paragraph.
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME Locator: Finds the elements by name element.

        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Melek");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Kokal");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("1234567890");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("melekkokal@gmail.com");
        WebElement address1=driver.findElement(By.name("address1"));
        address1.sendKeys("7150 Royal Fern Cir");
        WebElement address2=driver.findElement(By.name("address2"));
        address2.sendKeys("Apt 301");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Manassas");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("VA");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("20111");


        //CLASS Locator : finds the element by classname.

        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox= driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected()? "JAVA IS SELECTED" : "NOT SELECTED");

        WebElement TesNGBox= driver.findElement(By.id("cond3"));
        if(TesNGBox.isDisplayed() && !TesNGBox.isSelected()){
            TesNGBox.click();
        }
        System.out.println(TesNGBox.isSelected() ? "TESTNG SELECTED" : "TESTNG IS NOT SELECTED");

        WebElement cucumber=driver.findElement(By.id("cond4"));
        if(cucumber.isDisplayed() && !cucumber.isSelected()){
            cucumber.click();
        }
        System.out.println(cucumber.isSelected() ? "CUCUMBER IS SELECTED" : "CUCUMBER IS NOT SELECTED");

        //TAG NAME LOCATOR

        WebElement header2=driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement uname= driver.findElement(By.tagName("u"));
        System.out.println(uname.getText());

        Thread.sleep(2000);
        driver.quit();












    }

}
