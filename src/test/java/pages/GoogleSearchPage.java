package pages;

import org.openqa.selenium.*;

import java.util.List;

public class GoogleSearchPage extends BasePage {

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        driver.get("https://www.google.co.uk");
    }

    public void rejectCookies() {
        WebElement rejectAllButton = driver.findElement(By.id("W0wltc"));
        rejectAllButton.click();
    }

    public void submitSearchTerm(String searchTerm) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
    }

    public boolean pageContains(String searchString) {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));
        System.out.println("Search Results:");
        for (WebElement result : searchResults) {
            if (result.getText().contains(searchString)) {
                System.out.println("Search Results: " + result);
                return true;
            }
        }
        System.out.println("Search results do not contain " + searchString);
        return false;
    }
}
