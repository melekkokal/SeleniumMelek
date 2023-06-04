package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLOutput;

public class XPATHRealHealthProject {
     /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
     public static void main(String[] args) throws InterruptedException {

         WebDriverManager.chromedriver().setup();
         ChromeOptions option=new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");
         ChromeDriver driver=new ChromeDriver(option);
         driver.manage().window().maximize();
         driver.get("https://katalon-demo-cura.herokuapp.com/");

         WebElement makeAppointment= driver.findElement(By.cssSelector("#btn-make-appointment"));
         makeAppointment.click();
         WebElement username= driver.findElement(By.xpath("//input[@id='txt-username']"));
         username.sendKeys("John Doe");
         WebElement password= driver.findElement(By.xpath("//input[@id='txt-password']"));
         password.sendKeys("ThisIsNotAPassword");
         WebElement login= driver.findElement(By.xpath("//button[@id='btn-login']"));
         login.click();
         WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
         facility.sendKeys("Tokyo CURA Healthcare Center");
         WebElement box=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
         box.click();
         if(box.isDisplayed() && !box.isSelected()){
             box.click();
         }
         WebElement program= driver.findElement(By.xpath("//input[@id='radio_program_medicare']"));
         program.click();
         WebElement date= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
         date.sendKeys("03/07/2023");
         WebElement comment=driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
         comment.sendKeys("I am okay");
         WebElement book= driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
         book.click();
         WebElement header= driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
         String actualheader= header.getText();
         String expectedheader="Appointment Confirmation";
         System.out.println(actualheader.equals(expectedheader) ? "PASSED" : "FAILED");
         System.out.println(header.getText());
         WebElement facility1= driver.findElement(By.xpath("//p[contains(text(), 'Tokyo CURA Healthcare Center')]"));
         System.out.println(facility1.getText());
         WebElement apply= driver.findElement(By.xpath("//p[contains(text(), 'Yes')]"));
         System.out.println(apply.getText());
         WebElement date1= driver.findElement(By.xpath("//p[@id='visit_date']"));
         System.out.println(date1.getText());
         WebElement comment1= driver.findElement(By.xpath("//p[@id='comment']"));
         System.out.println(comment1.getText());
         WebElement home= driver.findElement(By.xpath("//a[@class='btn btn-default']"));
         home.click();
         Thread.sleep(2000);
         String actualURL = driver.getCurrentUrl();
         String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
         System.out.println(actualURL.equals(expectedURL) ? "Passed" : "Not passed");
         System.out.println();


         driver.quit();







     }



}
