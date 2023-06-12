import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Mentorings {
    @Test
    public void Test2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        WebElement table= driver.findElement(By.xpath("//a[.='Table Pagination']"));
        table.click();

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropdown, "0", "index");

        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails=driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String, String> map=new TreeMap<>();
        for(int i=0;i<allNames.size();i++){
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            System.out.println("Map = " + map);
        }



    }

    @Test
    public void Test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        WebElement table= driver.findElement(By.xpath("//a[.='Table Pagination']"));
        table.click();

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropdown, "5000", "value");

        List<WebElement> allNames=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allPhoneNumber=driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String, Long> map=new TreeMap<>();
        for(int i=0;i<allNames.size();i++){
            Thread.sleep(2000);
            map.put(BrowserUtils.getText(allNames.get(i)), Long.parseLong(BrowserUtils.getText(allPhoneNumber.get(i)).replace("-", "")));

        }System.out.println("Map = " + map);

    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

//        WebElement maybeButton= driver.findElement(By.name("Maybe later"));
//        maybeButton.click();

        WebElement homepage= driver.findElement(By.cssSelector(".GjGsN"));
        homepage.click();

        WebElement today= driver.findElement(By.xpath("//a[@class='wl0Ka sSq2h']"));
        today.click();

        WebElement trending=driver.findElement(By.linkText("Trending"));
        trending.click();

    }

    @Test
    public void practice1(){

        /*
        TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click pavilion (new tab will be opened, consider switch window)
        3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
        4-Validate the Header "Selenium-Python Tutorial"
        5-Print out(NO validation) Table of Content options on console(loop and getText())
        6-Wait for Second task

 */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        Actions actions=new Actions(driver);

        WebElement pavillion= driver.findElement(By.linkText("Pavilion"));
        pavillion.click();

        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(selenium).perform();
        WebElement sp= driver.findElement(By.linkText("Selenium-Python"));
        sp.click();


        WebElement header= driver.findElement(By.tagName("h1"));
        SoftAssert softAssert=new SoftAssert();
        String actualHeader=BrowserUtils.getText(header);
        softAssert.assertEquals(actualHeader,"Selenium-Python Tutorial");

        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));
        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        /*
        TASK 2:
        1-Go back to the main page "iframe"
        2-click category 1
        3-Validate the header "Category Archives: SeleniumTesting"
        4-Print out all the headers of the contents(i will show you)
                */

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Framename1");
        WebElement category1= driver.findElement(By.linkText("Category1"));
        category1.click();

        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives - qavalidation");
        WebElement header1= driver.findElement(By.xpath("//div//h1"));
        String actualHeader1=BrowserUtils.getText(header1);
        softAssert.assertEquals(actualHeader1, "Category Archives: SeleniumTesting");

        List<WebElement> headers= driver.findElements(By.xpath("//div//h3"));
        for(WebElement header3:headers){
            System.out.println(BrowserUtils.getText(header3));
        }

        /*TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Framename1");
        WebElement infram= driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(infram));
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement headerc=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(headerc));





    }
}
