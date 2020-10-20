package com.vytrack.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

//import static org.junit.Assert.*;

public class NavigationMenuStepDefs {

    @When("the user navigates to Fleet and vehicles page")
    public void the_user_navigates_to_Fleet_and_vehicles_page() {
        System.out.println("The user navigates to Fleet --> Vehicles");
    }


    @Then("the user should land the Vehicle page")
    public void the_user_should_land_the_Vehicle_page() {
        String expectedUrl="https://qa1.vytrack.com/entity/Extend_Entity_Carreservation";
        String actualUrl="https://qa1.vytrack.com/entity/Extend_Entity_Carreservation";
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("PASSED");

    }

    @When("the user navigates to Marketing to Campaigns page")
    public void the_user_navigates_to_Marketing_to_Campaigns_page() {
        System.out.println("The user navigates to Marketing --> Campaigns");
    }

    @Then("the user should land the Campaigns page")
    public void the_user_should_land_the_Campaigns_page() {
        String expectedUrl="https://qa1.vytrack.com/campaign/";
        String actualUrl="https://qa1.vytrack.com/campaign/";
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("PASSED");
    }

    @When("the user navigates to Activities to Calendar Events page")
    public void the_user_navigates_to_Activities_to_Calendar_Events_page() {

        System.out.println("The user navigates to Activities --> Calendar Events");

    }

    @Then("the user should land the Calenders page")
    public void the_user_should_land_the_Calenders_page() {
        String expectedUrl="https://qa1.vytrack.com/calendar/event";
        String actualUrl="https://qa1.vytrack.com/calendar/event";
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("PASSED");


    }

}
