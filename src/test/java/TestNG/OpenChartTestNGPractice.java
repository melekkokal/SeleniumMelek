package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Dashboard");

    }
    @Test
    public void negativeLoinTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("DEMO");
        WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);
        WebElement massage=driver.findElement(By.id("alert"));
        Assert.assertEquals(massage.getText().trim(),"No match for Username and/or Password.");

    }

    @Test
    public void validateProductButton() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement pw= driver.findElement(By.cssSelector("#input-password"));
        pw.sendKeys("demo");
        WebElement login= driver.findElement(By.xpath("//button"));
        login.click();
        Thread.sleep(1000);
        WebElement closeButton= driver.findElement(By.xpath("//button[@class='btn-close']"));//or .btn-close(By.cssSelector)
        Thread.sleep(1000);
        closeButton.click();
        WebElement catalogButton= driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        Thread.sleep(1000);
        catalogButton.click();
        Thread.sleep(200);

        WebElement product= driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());
    }

    @Test
    public void validateboxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);
        WebElement buttonx = driver.findElement(By.cssSelector(".btn-close"));
        buttonx.click();
        WebElement catalog = driver.findElement(By.cssSelector(".collapsed"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        product.click();
        List<WebElement> allboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allboxes.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(allboxes.get(i).isDisplayed());
            Assert.assertTrue(allboxes.get(i).isEnabled());
            Assert.assertFalse(allboxes.get(i).isSelected());
            allboxes.get(i).click();
            Assert.assertTrue(allboxes.get(i).isSelected());
            allboxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
    @Test
    public void prodyctNameFunctionalityDescending() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);
        WebElement buttonx=driver.findElement(By.cssSelector(".btn-close"));
        buttonx.click();
        WebElement catalog=driver.findElement(By.cssSelector(".collapsed"));
        catalog.click();
        WebElement product=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        product.click();

        WebElement productName=driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
        productName.click();
        Thread.sleep(1000);
        List<WebElement>  names=driver.findElements(By.xpath("//td[@class='text-start']"));
        ArrayList<String> actualdata=new ArrayList<>();
        ArrayList<String> expectedData=new ArrayList<>();
        Thread.sleep(1000);
       // names=driver.findElements(By.cssSelector(".text-start"));
        for(int i=1;i<names.size();i++){

            actualdata.add(names.get(i).getText().toUpperCase().trim());
            expectedData.add(names.get(i).getText().toUpperCase().trim());
        }
        Thread.sleep(3000);
        Collections.sort(expectedData);
        Collections.reverse(expectedData);
        Assert.assertEquals(actualdata,expectedData);




    }
    @Test
    public void Productnamefunctionalityascending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);
        WebElement buttonx=driver.findElement(By.cssSelector(".btn-close"));
        Thread.sleep(3000);
        buttonx.click();
        WebElement catalog=driver.findElement(By.cssSelector(".collapsed"));
        catalog.click();
        WebElement product=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        product.click();
        WebElement productName=driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
        productName.click();
        Thread.sleep(1000);
        List<WebElement>  names=driver.findElements(By.xpath("//td[@class='text-start']"));
        ArrayList<String> actualdata=new ArrayList<>();
        ArrayList<String> expectedData=new ArrayList<>();
        Thread.sleep(1000);
        // names=driver.findElements(By.cssSelector(".text-start"));
        for(int i=1;i<names.size();i++){

            actualdata.add(names.get(i).getText().toUpperCase().trim());
            expectedData.add(names.get(i).getText().toUpperCase().trim());
        }
        Thread.sleep(3000);
        Collections.sort(expectedData);
        Collections.reverse(expectedData);
        Assert.assertEquals(actualdata,expectedData);
    }

    }