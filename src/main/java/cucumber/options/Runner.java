package cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json"
        },
        glue = "com.ca.awesometestreport.log4jappender"
)
public class Runner {

}
