package ui.steps;

import helpers.BaseSteps;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiSteps extends BaseSteps {
    protected WebDriver driver;

    public BaseUiSteps() {
        this.driver = UiHooks.getDriver();
    }
}
