package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {

    //FIRST STEP is setting up your automation.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //we introduce our Chrome.
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); //because Chrome released a new bug. we have to write it.
        //Then create your driver to start automation.

        WebDriver driver = new ChromeDriver(options); //we did polymorphism. is a way to create our driver
        //to connect with our website. it's the key to our car.
        //What's the most important component in automation? DRIVER.
        driver.get("https://www.amazon.com/");//will be executed by this code.
        //How do you know it's gonna go to website?
        System.out.println(driver.getTitle());
        //getTitle() method.
        String actualTitle= driver.getTitle(); //your title comes from website.
        String expectedTitle="Amazon.com. Spend less. Smile more."; //expected comes from me.
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        //getCurrentUrl() method.
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL is passed");
        }else{
            System.out.println("URL is failed.");
        }

        //close() method

        driver.close();
    }
}
