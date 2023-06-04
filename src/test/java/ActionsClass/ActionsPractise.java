package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsPractise {

    @Test
    public void practiceDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200);

        WebElement droppable= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualMessage= BrowserUtils.getText(droppable);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.dragAndDrop(draggable, droppable).perform();
        //droppable= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualMessageAfter=BrowserUtils.getText(droppable);
        String expectedMessageAfter="Dropped!";
        Assert.assertEquals(actualMessageAfter, expectedMessageAfter);
        String actualBackgroundColor=droppable.getCssValue("background-color");
        String expectedBackground="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualBackgroundColor, expectedBackground);

    }



    @Test
    public void practiceClickanadHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200);

        WebElement button= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        button.click();
        Thread.sleep(2000);

        WebElement notAcceptable= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Assert.assertEquals(BrowserUtils.getText(notAcceptable), "Not Acceptable");
        Thread.sleep(2000);
        WebElement drophere= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessage=BrowserUtils.getText(drophere);
        String expextedMessage="Drop here";
        Assert.assertEquals(actualMessage, expextedMessage);

        actions.clickAndHold(notAcceptable).moveToElement(drophere).release().perform();

        //drophere= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessageAfter=BrowserUtils.getText(drophere);
        String expextedMessageAfter="Drop here";
        Assert.assertEquals(actualMessageAfter, expextedMessageAfter);

    }
}
