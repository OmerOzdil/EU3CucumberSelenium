package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {

        BrowserUtils.waitFor(1);

        //get the list of webelement and convert them to list of string and assert
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);


        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);

        Assert.assertEquals(menuOptions,actualOptions);

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String>userInfo) {

        String username= userInfo.get("username");
        String password= userInfo.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();
        String actualName = dashboardPage.userName.getText();

        String expectedName= userInfo.get("firstname")+" "+ userInfo.get("lastname");

        System.out.println("expectedName = " + expectedName);
        System.out.println("actualName = " + actualName);


        Assert.assertEquals(expectedName,actualName);



    }
}
