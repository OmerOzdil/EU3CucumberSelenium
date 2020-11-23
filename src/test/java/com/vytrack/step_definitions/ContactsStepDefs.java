package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
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
    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {

        BrowserUtils.waitFor(4);
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail(email).click();

    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {


        BrowserUtils.waitFor(3);
        //get information from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullName = " + actualFullName);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);


        String query="select concat(first_name,' ',last_name) as \"full_name\", e.email,p.phone \n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id=e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id=p.owner_id\n" +
                "where first_name= 'Mariam'";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullName= (String) rowMap.get("full_name");
        String expectedPhone = (String) rowMap.get("phone");
        String expectedEmail = (String) rowMap.get("email");

        System.out.println("expectedFullName = " + expectedFullName);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);


        //assertion, compare UI against database
        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);



        BrowserUtils.waitFor(1);
    }

    @Then("the information for {string} should be same with database")
    public void the_information_for_should_be_same_with_database(String email) {
        BrowserUtils.waitFor(3);
        //get information from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullName = " + actualFullName);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);


        String query="select concat(first_name,' ',last_name) as \"full_name\", e.email,p.phone \n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id=e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id=p.owner_id\n" +
                "where e.email='"+email+"'";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullName= (String) rowMap.get("full_name");
        String expectedPhone = (String) rowMap.get("phone");
        String expectedEmail = (String) rowMap.get("email");

        System.out.println("expectedFullName = " + expectedFullName);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);


        //assertion, compare UI against database
        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);



        BrowserUtils.waitFor(1);
    }
}
