package com.vytrack.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    // this comes from Cucumber.java
    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
    }
    @After
    public void tearDown(){
        System.out.println("\tthis is coming from After");
    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database.........");
    }
    @After("@db")
    public void closedb(){
        System.out.println("\tdisconnecting from database..........");
    }

}
