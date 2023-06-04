package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();

        WebElement firstname= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.sendKeys("Melek");
        WebElement lastname= driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Kokal");
        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("melekkokal3@gmail.com");
        WebElement phone= driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("1234567890");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("melek1234");
        WebElement confirm= driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirm.sendKeys("melek1234");
        WebElement subscribe=driver.findElement(By.xpath("//input[@name='newsletter']"));
        subscribe.click();
        WebElement privacy=driver.findElement(By.xpath("//input[@name='agree']"));
        privacy.click();
        WebElement button= driver.findElement(By.xpath("//input[@type='submit']"));
        button.click();
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader = header.getText();
        String expectedHeader = "Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Not Passed");

        WebElement continue1 = driver.findElement(By.xpath("//a[.='Continue')]"));
        continue1.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualURL.equals(expectedURL) ? "Passed" : "Not passed");
        Thread.sleep(2000);
        driver.quit();
    }
}
