package ui.hooks;

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
    public void beforeEachUIScenario () {
        if (driver == null) {
            driver = new ChromeDriver(); // It's possible to pass in a different browser driver (e.g. for Firefox, Chrome headless) as a parameter when calling a shell script
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.manage().deleteAllCookies();
    }

    @AfterStep("@UITest")
    public static void afterEachUIStep(Scenario scenario) throws InterruptedException {
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
