package steps.ui;

import org.openqa.selenium.WebDriver;
import steps.BaseStep;

public abstract class BaseUiStep extends BaseStep {
    protected WebDriver driver;

    public BaseUiStep() {
        this.driver = UiHooks.getDriver();
    }
}
