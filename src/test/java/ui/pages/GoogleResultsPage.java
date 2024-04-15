package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultsPage extends BasePage {

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageContains(String searchString) {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));
        for (WebElement result : searchResults) {
            if (result.getText().contains(searchString)) {
                return true;
            }
        }
        return false;
    }
}
