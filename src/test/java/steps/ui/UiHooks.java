package steps.ui;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UiHooks {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before("@UITest")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Before("@UITest")
    public void beforeScenario (Scenario scenario) {
        driver.manage().deleteAllCookies();
    }

    @After("@UITest")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
