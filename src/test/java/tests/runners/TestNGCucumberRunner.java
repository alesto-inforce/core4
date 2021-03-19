package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/java/feature_files/underwriting/utilities",
        glue="tests",
        plugin = { "pretty", "html:test-output",
                    "json:target/cucumber-report/cucumber.json",
                    "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        })
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios(){
//                return super.scenarios();
//        }
}