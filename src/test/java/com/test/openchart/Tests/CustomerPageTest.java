package com.test.openchart.Tests;

import com.test.openchart.Pages.CustomersPage;
import com.test.openchart.Pages.HomePage;
import com.test.openchart.Pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerPageTest extends OpenChartTestBase{
    @Test
    public void ValidateCostumerPageFunctionaliy() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("demo", "demo");

        HomePage homePage=new HomePage(driver);
        homePage.HomePageComponentFunctionality(driver);

        CustomersPage customersPage=new CustomersPage();
        customersPage.CustomersPageComponentFunctionality("Melek", "Kokal", "melek@gmail.com",
                "abcde", "abcde");

        Assert.assertEquals(customersPage.errorMessage(), "Warning: You do not have permission to modify customers!");

    }
}
