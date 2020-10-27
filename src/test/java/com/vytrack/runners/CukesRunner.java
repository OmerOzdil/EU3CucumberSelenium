package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // this line is used to create a json file under target folder and by cucumber to create a report.
        plugin = {"json:target/cucumber.json",
                //this line is for simple html report
        "html:target/default-html-report",
                "rerun:target/rerun.txt"
        },
        // informs feature files are here.(Normally first look at under runners)
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "@wip"


)
public class CukesRunner {
}

