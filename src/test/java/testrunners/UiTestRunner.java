package testrunners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,value = "ui/hooks, ui/steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber.html")
public class UiTestRunner {
}
