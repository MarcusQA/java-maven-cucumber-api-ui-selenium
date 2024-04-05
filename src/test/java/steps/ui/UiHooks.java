package steps.ui;

import io.cucumber.java.*;
import org.openqa.selenium.*;
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

    @AfterStep("@UITest")
    public static void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure screenshot: " + scenario.getName());
        }
    }

    @After("@UITest")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
