package ui.steps;

import io.cucumber.java.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UiHooks {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeAll()
    public static void beforeAllScenarios() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Before("@UITest")
    public void beforeEachScenario () {
        driver.manage().deleteAllCookies();
    }

    @AfterStep("@UITest")
    public static void afterEachStep(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName() + ": page where failure occurred");

            driver.navigate().back();
            byte[] previousScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(previousScreenshot, "image/png", scenario.getName() + ": page before failure");
        }
    }

    @AfterAll()
    public static void afterAllScenarios() {
        if (driver != null) {
            driver.quit();
        }
    }
}
