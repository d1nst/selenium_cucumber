package org.selenium_cucumber.myRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.selenium_cucumber.utils.Utils;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"test.java.org.selenium_cucumber"},
        plugin = {"pretty", "junit:junit_xml/result.xml"},
        monochrome = true
)

public class TestRunner {
    public static String URL = "https://magento.softwaretestingboard.com";
    public static final String EMAIL = Utils.generateEmail();
}
