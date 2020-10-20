package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("A new browser is opened");
    }

    @When("the user enters driver information")
    public void the_user_enters_driver_information() {
        System.out.println("Driver information is put as a credential");
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("Verify that I am on the home page");
    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {
        System.out.println("Sales manager information is put as a credential");
    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        System.out.println("Store manager information is put as a credential");
    }

}
