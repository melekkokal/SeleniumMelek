package com.test.openchart.Tests;

import com.test.openchart.Pages.HomePage;
import com.test.openchart.Pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase{


    @Test
    public void happyPathLogin() throws InterruptedException {
        OpenChartLoginPage chartLoginPage=new OpenChartLoginPage(driver);
        chartLoginPage.LoginFunctionality("demo", "demo");
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");
        HomePage homePage=new HomePage(driver);
        homePage.HomePageComponentFunctionality(driver);

    }

    @Test
    public void ValidateNegativeLogin() throws InterruptedException {
        OpenChartLoginPage openChartLogin=new OpenChartLoginPage(driver);
        openChartLogin.LoginFunctionality("skdhf", "demosdsd");
        Assert.assertEquals(openChartLogin.errorMessage(), "No match for Username and/or Password.");
    }


}
